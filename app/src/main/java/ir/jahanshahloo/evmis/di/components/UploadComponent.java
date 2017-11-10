package ir.jahanshahloo.evmis.di.components;

import dagger.Component;
import ir.jahanshahloo.evmis.UI.SettingsActivity;
import ir.jahanshahloo.evmis.di.modules.UploadModule;
import ir.jahanshahloo.evmis.di.scopes.UserScope;

@UserScope
@Component(
        dependencies = NetComponent.class,
        modules = UploadModule.class
)
public interface UploadComponent{
void inject(SettingsActivity activity);
}
