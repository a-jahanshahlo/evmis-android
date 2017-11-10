package ir.jahanshahloo.evmis.di.components;

import android.content.SharedPreferences;

import com.squareup.picasso.Picasso;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import ir.jahanshahloo.evmis.Service.Contract.IRegisterService;
import ir.jahanshahloo.evmis.Service.Provider.RefreshTokenAuthenticator;
import ir.jahanshahloo.evmis.UI.SettingsActivity;
import ir.jahanshahloo.evmis.di.modules.AppModule;
import ir.jahanshahloo.evmis.di.modules.NetModule;
import ir.jahanshahloo.evmis.di.modules.RegisterModule;
import ir.jahanshahloo.evmis.localdata.AppPreference;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Adminstrator on 7/16/2016.
 */
@Singleton
@Component(
        modules = {AppModule.class, NetModule.class}
)
public interface NetComponent {

    Retrofit retrofit();


    OkHttpClient okHttpClient();

    SharedPreferences sharedPreferences();

    AppPreference appPreference();

    Picasso getPicasso();


}
