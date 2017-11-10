package ir.jahanshahloo.evmis.di.components;

import dagger.Component;
import ir.jahanshahloo.evmis.UI.HouseForRentFragment;
import ir.jahanshahloo.evmis.UI.HouseFragment;

import ir.jahanshahloo.evmis.UI.MainActivity;
import ir.jahanshahloo.evmis.di.modules.AppModule;
import ir.jahanshahloo.evmis.di.modules.BaseDataModule;
import ir.jahanshahloo.evmis.di.modules.HouseForRentModule;
import ir.jahanshahloo.evmis.di.modules.HouseModule;
import ir.jahanshahloo.evmis.di.modules.UploadModule;
import ir.jahanshahloo.evmis.di.scopes.UserScope;
import ir.jahanshahloo.evmis.model.HouseModel;
import ir.jahanshahloo.evmis.model.RegisterModel;

/**
 * Created by Adminstrator on 7/16/2016.
 */
@UserScope
@Component(
        dependencies = NetComponent.class,
        modules = HouseModule.class
)
public interface HouseComponent {
    void inject(HouseFragment fragment);
}

