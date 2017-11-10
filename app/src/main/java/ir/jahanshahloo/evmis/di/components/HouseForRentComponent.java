package ir.jahanshahloo.evmis.di.components;

import dagger.Component;
import ir.jahanshahloo.evmis.Service.Handler.Handlers;
import ir.jahanshahloo.evmis.UI.HouseForRentFragment;
import ir.jahanshahloo.evmis.di.modules.HouseForRentModule;
import ir.jahanshahloo.evmis.di.scopes.UserScope;

@UserScope
@Component(
        dependencies = NetComponent.class,
        modules = HouseForRentModule.class
)
public interface HouseForRentComponent {
    void inject(HouseForRentFragment fragment);
    void inject(Handlers handlers);
}
