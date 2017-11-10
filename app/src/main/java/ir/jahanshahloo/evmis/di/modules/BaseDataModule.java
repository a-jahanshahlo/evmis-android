package ir.jahanshahloo.evmis.di.modules;

import dagger.Module;
import dagger.Provides;
import ir.jahanshahloo.evmis.Service.Contract.IBaseDataService;
import ir.jahanshahloo.evmis.di.scopes.UserScope;
import retrofit2.Retrofit;

@Module
public class BaseDataModule {

    @Provides
    @UserScope
    public IBaseDataService provideBaseDataService (Retrofit retrofit){
        return retrofit.create(IBaseDataService.class);
    }
}
