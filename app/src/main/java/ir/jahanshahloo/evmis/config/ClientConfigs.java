package ir.jahanshahloo.evmis.config;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import ir.jahanshahloo.evmis.Util.App;

/**
 * Created by Adminstrator on 7/9/2016.
        */
public class ClientConfigs {
    //TODO: should get network ip address like 192.168.1.2 and replace inside REST_API_BASE_URL
    public static final String REST_API_BASE_URL ="http://192.168.1.50:9716/";//"http://10.0.14.183:9716/";//
    //TODO: create new Client with postman in http://localshot:/api/v1/client with body {"name":"android client app"} and set these values with client_id and client_key
    public static final String CLIENT_ID = "";
    public static final String CLIENT_KEY = "";

    public static void Init(Application app){
        Picasso picasso = ((App) app).getNetComponent().getPicasso();
        ClientConfigs. ConfigDrawer(picasso);
    }
    private static void ConfigDrawer(final Picasso picasso){
        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                Log.i("ali","set Config prifle image");

                picasso.load(uri).memoryPolicy(MemoryPolicy.NO_STORE).placeholder(placeholder).into(imageView);
            }

            @Override
            public void cancel(ImageView imageView) {
                Log.i("ali","cancel Config prifle image");
                picasso.cancelRequest(imageView);
            }

    /*
    @Override
    public Drawable placeholder(Context ctx) {
        return super.placeholder(ctx);
    }

    @Override
    public Drawable placeholder(Context ctx, String tag) {
        return super.placeholder(ctx, tag);
    }
    */
        });

    }


}