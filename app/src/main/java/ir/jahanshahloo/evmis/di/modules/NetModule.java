package ir.jahanshahloo.evmis.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.jahanshahloo.evmis.Service.Contract.IRegisterService;
import ir.jahanshahloo.evmis.Service.Provider.RefreshTokenAuthenticator;
import ir.jahanshahloo.evmis.Util.CacheUtils;
import ir.jahanshahloo.evmis.Util.DateTypeDeserializer;
import ir.jahanshahloo.evmis.Util.DotNetDateConverter;
import ir.jahanshahloo.evmis.di.scopes.LoginRetrofit;
import ir.jahanshahloo.evmis.localdata.AppPreference;
import ir.jahanshahloo.evmis.model.AccessTokenModel;
import ir.jahanshahloo.evmis.model.RefreshTokenRequestModel;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adminstrator on 7/16/2016.
 */
@Module

public class NetModule {
    String mBaseUrl;

    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Singleton
    @Provides
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application.getApplicationContext());
    }

    @Singleton
    @Provides
    AppPreference providesAppPreferences(Application application) {
        AppPreference preference = new
                AppPreference(application.getApplicationContext());
        return preference;
    }

    @Singleton
    @Provides
    Cache provideOkHttpCache(Application app) {
        int cacheSize = 10 * 1024 * 1024;//10 MB
        Cache cache = new Cache(app.getCacheDir(), cacheSize);
        return cache;
    }

    @Singleton
    @Provides
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
       //  gsonBuilder.registerTypeAdapter(Date.class, new DotNetDateConverter());
        gsonBuilder.registerTypeAdapter(Date.class, new DateTypeDeserializer());

        //  gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    @Named("loginOkHttp")
    OkHttpClient provideOkHttpLogin( final AppPreference appPreference, Application application) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // httpClient.cache(c);
        Log.i("ali", "init okhttpclient");
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Log.i("ali", "build request");

                //build request
                Request.Builder requestBuilder = original.newBuilder();
                //add header for all of the request
                requestBuilder.addHeader("Accept", "application/json");
                //check is user logged in , if yes should add authorization header to every request
                if (appPreference.isAuthorized() && appPreference.isTokenValid()) {
                    requestBuilder.addHeader("Authorization", "bearer " + appPreference.getAccessToken());
            //    } else if (appPreference.isTokenValid()) {

                }
                requestBuilder.method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);

            }
        });

        //when request get 401 http error code this method run and get refreshToken and send original request again
        httpClient.authenticator(new RefreshTokenAuthenticator(application, appPreference));

        return httpClient.build();
    }
    @Provides
    @Singleton

    OkHttpClient provideOkHttpClient(Cache c, final AppPreference appPreference, Application application) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // httpClient.cache(c);
        Log.i("ali", "init okhttpclient");
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Log.i("ali", "build request");

                //build request
                Request.Builder requestBuilder = original.newBuilder();
                //add header for all of the request
                requestBuilder.addHeader("Accept", "application/json");
                //check is user logged in , if yes should add authorization header to every request
                if (appPreference.isAuthorized() && appPreference.isTokenValid()) {
                    requestBuilder.addHeader("Authorization", "bearer " + appPreference.getAccessToken());
                    //    } else if (appPreference.isTokenValid()) {

                }
                requestBuilder.method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);

            }
        });

        //when request get 401 http error code this method run and get refreshToken and send original request again
        httpClient.authenticator(new RefreshTokenAuthenticator(application, appPreference));

        return httpClient.build();
    }

    @Singleton
    @Provides
    @LoginRetrofit
    Retrofit provideRetrofitLogin(Gson gson, @Named("loginOkHttp") OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    @Singleton
    @Provides

    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    Picasso providePicasso(OkHttpClient okHttpClient, final AppPreference appPreference, Context ctx) {
        Log.i("ali", "appPreference is null? " + appPreference == null ? "true" : "false");
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        File file = CacheUtils.createDefaultCacheDir(ctx);
        httpClient.cache(new Cache(file, CacheUtils.calculateDiskCacheSize(file)));
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Log.i("ali: ","picasso request began");
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder();
                requestBuilder.addHeader("Accept", "application/json");
                String token=    appPreference.getAccessToken();
                Log.i("ali token: ",token);
                requestBuilder.removeHeader("Authorization");
                requestBuilder.addHeader("Authorization", "bearer " +token);
                requestBuilder.method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        Picasso picasso = new Picasso.Builder(ctx).downloader(new OkHttp3Downloader(client))
                .defaultBitmapConfig(Bitmap.Config.RGB_565)
                .build();
        Log.i("ali: ", "Build Picasso");

        return picasso;
    }
}
