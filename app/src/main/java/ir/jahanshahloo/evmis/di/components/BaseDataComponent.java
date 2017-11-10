package ir.jahanshahloo.evmis.di.components;

import android.app.Activity;
import android.support.v4.app.DialogFragment;

import dagger.Component;
import ir.jahanshahloo.evmis.UI.HouseForRentDialogFragment;
import ir.jahanshahloo.evmis.UI.NewHouseForRentActivity;
import ir.jahanshahloo.evmis.di.modules.BaseDataModule;
import ir.jahanshahloo.evmis.di.scopes.UserScope;

@UserScope
@Component(
        dependencies = NetComponent.class,
        modules = BaseDataModule.class
)
public interface BaseDataComponent {
  void inject(DialogFragment fragment);
  void inject(NewHouseForRentActivity activity);
  void inject(HouseForRentDialogFragment fragment);
}
