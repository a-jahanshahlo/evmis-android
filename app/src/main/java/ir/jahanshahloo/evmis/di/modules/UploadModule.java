package ir.jahanshahloo.evmis.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.jahanshahloo.evmis.Service.Contract.IUploadService;
import ir.jahanshahloo.evmis.di.scopes.UserScope;
import retrofit2.Retrofit;

/**
 * Created by Ali on 7/27/2016.
 */
@Module
public class UploadModule {

    @Provides@UserScope
    public IUploadService provideUploadService(Retrofit retrofit){
        return retrofit.create(IUploadService.class);
    }
}
