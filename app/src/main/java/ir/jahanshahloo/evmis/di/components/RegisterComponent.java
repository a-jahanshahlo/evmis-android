package ir.jahanshahloo.evmis.di.components;

import javax.inject.Inject;

import dagger.Component;
import ir.jahanshahloo.evmis.Service.Provider.RefreshTokenAuthenticator;
import ir.jahanshahloo.evmis.UI.ConfirmCodeBySmsActivity;

import ir.jahanshahloo.evmis.UI.RegisterActivity;
import ir.jahanshahloo.evmis.di.modules.RegisterModule;
import ir.jahanshahloo.evmis.di.scopes.LoginRetrofit;
import ir.jahanshahloo.evmis.di.scopes.UserScope;
import ir.jahanshahloo.evmis.model.RegisterModel;


@UserScope
@Component(
        dependencies = NetComponent.class,
        modules = RegisterModule.class
)
public interface RegisterComponent {

    void inject(RegisterActivity activity);
    void inject(ConfirmCodeBySmsActivity activity);

}
