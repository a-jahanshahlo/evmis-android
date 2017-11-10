package ir.jahanshahloo.evmis.di.modules;

import dagger.Module;
import dagger.Provides;
import ir.jahanshahloo.evmis.Service.Contract.IHouseForRentService;
import ir.jahanshahloo.evmis.di.scopes.UserScope;
import retrofit2.Retrofit;

@Module

public class HouseForRentModule {

    @Provides
    @UserScope
    public IHouseForRentService provideHouseForRentService (Retrofit retrofit){
        return retrofit.create(IHouseForRentService.class);
    }
}
