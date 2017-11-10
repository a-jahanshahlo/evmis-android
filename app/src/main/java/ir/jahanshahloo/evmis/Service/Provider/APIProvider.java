package ir.jahanshahloo.evmis.Service.Provider;

import android.util.Log;

import java.io.IOException;


import ir.jahanshahloo.evmis.Util.App;

import ir.jahanshahloo.evmis.config.ClientConfigs;
import ir.jahanshahloo.evmis.localdata.AppPreference;
import ir.jahanshahloo.evmis.model.AccessTokenModel;
import ir.jahanshahloo.evmis.model.RefreshTokenRequestModel;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alireza on 6/30/2016.
 */
public class APIProvider {


    private Retrofit mRetrofitClient;
    private AppPreference mAppPreference;

    public APIProvider() {
        Log.i("ali_login", App.applicationContext==null?"context is null":"context not null");

        this.mAppPreference = new AppPreference(App.applicationContext);
        OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                String originalPath = original.url().url().getPath();
                if (originalPath.endsWith("user/profile/image") || originalPath.endsWith("refreshtoken")) {
                    return chain.proceed(original);
                } else {
                    //build request
                    Request.Builder requestBuilder = original.newBuilder();
                    //add header for all of the request
                    requestBuilder.addHeader("Accept", "application/json");
                    //check is user logged in , if yes should add authorization header to every request
                    if (mAppPreference.isAuthorized()) {
                         requestBuilder.addHeader("Authorization", "bearer " + mAppPreference.getAccessToken());
                    }
                    requestBuilder.method(original.method(), original.body());
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            }
        });

        //when request get 401 http error code this method run and get refreshToken and send original request again
        httpClient.authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
              if (mAppPreference.isAuthorized()) {
                    //make the refresh token request model
                    RefreshTokenRequestModel requestModel = new RefreshTokenRequestModel();
                    requestModel.refresh_token=  mAppPreference.getRefreshToken();
                    //make call
                    Call<AccessTokenModel> call =null;// mService.getRefreshToken(requestModel);
                    retrofit2.Response<AccessTokenModel> tokenModelResponse = call.execute();
                    if (tokenModelResponse.isSuccessful()) {
                        mAppPreference.saveTokenModel(tokenModelResponse.body());
                        return response
                                .request()
                                .newBuilder()
                                .removeHeader("Authorization")
                                .addHeader("Authorization", "bearer " + mAppPreference.getAccessToken())
                                .build();
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        });
        //create new gson object to define custom converter on Date type
      /* Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new UTCDateTypeAdapter())
                .create();
        */
        mRetrofitClient = new Retrofit.Builder()
                .baseUrl(ClientConfigs.REST_API_BASE_URL) // set Base URL , should end with '/'
                .client(httpClient.build()) // add http client
                .addConverterFactory(GsonConverterFactory.create())
               // .addConverterFactory(GsonConverterFactory.create(gson))//add gson converter
                .build();
       // mService = mRetrofitClient.create(IAPIService.class);
    }
    /**
     * can get Retrofit Service
     *
     * @return
     */
  //  public IAPIService getTService() {
  //      return mService;
  //  }

    /**
     * get Retrofit client
     * used in ErrorUtil class
     *
     * @return
     */
    public Retrofit getRetrofitClient() {
        return mRetrofitClient;
    }
}
