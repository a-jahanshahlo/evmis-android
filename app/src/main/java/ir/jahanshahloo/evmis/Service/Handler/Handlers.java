package ir.jahanshahloo.evmis.Service.Handler;

import android.content.Intent;
import android.text.Annotation;
import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;

import ir.jahanshahloo.evmis.Service.Contract.IBaseDataService;
import ir.jahanshahloo.evmis.Service.Contract.IHouseForRentService;
import ir.jahanshahloo.evmis.UI.MainRentHouseActivity;
import ir.jahanshahloo.evmis.UI.NewHouseForRentActivity;
import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.Util.InjectorUtil;
import ir.jahanshahloo.evmis.model.NewHouseForRent;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Ali on 10/13/16.
 */
public class Handlers {
    @Inject
    IHouseForRentService iHouseForRentService;
App app;


     public Handlers(){
        InjectorUtil.INSTANCE.Inject(this);
app=InjectorUtil.INSTANCE.getApp();
    }

    public  void saveNewHouse(NewHouseForRent model){
        Log.d("ali", "SaveNewHouse: "+model.toString());
        Call<ResponseBody> call = this.iHouseForRentService.sendHouseForRent(model);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    Log.d("ali", "SaveNewHouse: "+response.message());
                    Intent intent = new Intent();

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setClass(app.getBaseContext(), MainRentHouseActivity.class);
                    app.startActivity(intent);


                }else {
                    try {
                        Log.d("LOG", "Retrofit Response: " + response.errorBody().string().substring(200));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("ali", "onFailure: "+t.getMessage());
            }
        });
    }

}
