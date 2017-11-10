package ir.jahanshahloo.evmis.Service.Provider;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.Util.CacheUtils;
import ir.jahanshahloo.evmis.localdata.AppPreference;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ali on 7/29/2016.
 */
public class PicassoBuilder {
    public static Picasso getImageLoader(Context ctx) {
        Log.i("ali ","call picasso");
        final AppPreference appPreference = ((App) ctx.getApplicationContext()).getNetComponent().appPreference();
        Log.i("ali","appPreference is null? "+appPreference==null?"true":"false");
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        File file = CacheUtils.createDefaultCacheDir(ctx);
        httpClient.cache(new Cache(file,CacheUtils.calculateDiskCacheSize(file)));
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
        Log.i("ali: ","Build Picasso");

        return  picasso;
    }
}
