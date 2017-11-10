package ir.jahanshahloo.evmis.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.jahanshahloo.evmis.Service.Contract.IBaseDataService;
import ir.jahanshahloo.evmis.Service.Contract.IHouseForRentService;
import ir.jahanshahloo.evmis.Service.Contract.IHouseService;
import ir.jahanshahloo.evmis.di.scopes.UserScope;
import retrofit2.Retrofit;

/**
 * Created by Adminstrator on 7/16/2016.
 */
@Module
public class HouseModule {

    @Provides
    @UserScope
    public IHouseService provideHouseService (Retrofit retrofit){
        return retrofit.create(IHouseService.class);
    }
}
