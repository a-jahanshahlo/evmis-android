package ir.jahanshahloo.evmis.di.modules;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.jahanshahloo.evmis.Service.Contract.IHouseService;
import ir.jahanshahloo.evmis.Service.Contract.IRegisterService;
import ir.jahanshahloo.evmis.di.scopes.LoginRetrofit;
import ir.jahanshahloo.evmis.di.scopes.UserScope;
import retrofit2.Retrofit;

@Module

public class RegisterModule {

    @Provides
    @UserScope
    @LoginRetrofit

    public IRegisterService provideRegisterService ( Retrofit retrofit){
        return retrofit.create(IRegisterService.class);
    }
}
