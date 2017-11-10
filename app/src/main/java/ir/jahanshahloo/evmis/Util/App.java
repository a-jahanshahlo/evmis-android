package ir.jahanshahloo.evmis.Util;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import ir.jahanshahloo.evmis.config.ClientConfigs;

import ir.jahanshahloo.evmis.di.components.BaseDataComponent;
import ir.jahanshahloo.evmis.di.components.DaggerBaseDataComponent;
import ir.jahanshahloo.evmis.di.components.DaggerHouseComponent;
import ir.jahanshahloo.evmis.di.components.DaggerHouseForRentComponent;
import ir.jahanshahloo.evmis.di.components.DaggerNetComponent;

import ir.jahanshahloo.evmis.di.components.DaggerRegisterComponent;
import ir.jahanshahloo.evmis.di.components.DaggerUploadComponent;
import ir.jahanshahloo.evmis.di.components.HouseComponent;
import ir.jahanshahloo.evmis.di.components.HouseForRentComponent;
import ir.jahanshahloo.evmis.di.components.NetComponent;

import ir.jahanshahloo.evmis.di.components.RegisterComponent;
import ir.jahanshahloo.evmis.di.components.UploadComponent;
import ir.jahanshahloo.evmis.di.modules.AppModule;
import ir.jahanshahloo.evmis.di.modules.BaseDataModule;
import ir.jahanshahloo.evmis.di.modules.HouseForRentModule;
import ir.jahanshahloo.evmis.di.modules.HouseModule;
import ir.jahanshahloo.evmis.di.modules.NetModule;
import ir.jahanshahloo.evmis.di.modules.RegisterModule;
import ir.jahanshahloo.evmis.di.modules.UploadModule;

/**
 * extend application class
 */
public class App extends Application {

    public static volatile Context applicationContext;

    private NetComponent netComponent;
    private HouseComponent houseComponent;
    private HouseForRentComponent houseForRentComponent;
    private RegisterComponent registerComponent;
    private UploadComponent uploadComponent;
    private BaseDataComponent baseDataComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //   FontsOverride.setDefaultFont(this, "DEFAULT", "irsans.ttf");

InjectorUtil.INSTANCE.initialize(this);
        applicationContext = getApplicationContext();
        TypefaceUtil.setDefaultFont(applicationContext, "DEFAULT", "fonts/irsans.ttf");
        TypefaceUtil.setDefaultFont(applicationContext, "MONOSPACE", "fonts/irsans.ttf");
        TypefaceUtil.setDefaultFont(applicationContext, "SANS_SERIF", "fonts/irsans.ttf");

        netComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(ClientConfigs.REST_API_BASE_URL))
                .build();
        houseComponent = DaggerHouseComponent.builder()
                .houseModule(new HouseModule())
                .netComponent(netComponent)
                .build();
        houseForRentComponent = DaggerHouseForRentComponent.builder()
                .houseForRentModule(new HouseForRentModule())
                .netComponent(netComponent)
                .build();
        registerComponent = DaggerRegisterComponent
                .builder()
                .netComponent(netComponent)
                .registerModule(new RegisterModule())
                .build();
        uploadComponent = DaggerUploadComponent
                .builder()
                .uploadModule(new UploadModule())
                .netComponent(netComponent)
                .build();
        baseDataComponent = DaggerBaseDataComponent
                .builder()
                .netComponent(netComponent)
                .baseDataModule(new BaseDataModule())
                .build();

        /*Init app third component config*/
        ClientConfigs.Init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public HouseComponent getHouseComponent() {
        return houseComponent;
    }

    public HouseForRentComponent getHouseForRentComponent() {
        return houseForRentComponent;
    }

    public RegisterComponent getRegisterComponent() {
        return registerComponent;
    }

    public UploadComponent getUploadComponent() {
        return uploadComponent;
    }

    public BaseDataComponent getBaseDataComponent() {
        return baseDataComponent;
    }
}
