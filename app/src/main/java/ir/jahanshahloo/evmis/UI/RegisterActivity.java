package ir.jahanshahloo.evmis.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import ir.jahanshahloo.evmis.R;

import ir.jahanshahloo.evmis.Service.Contract.IRegisterService;

import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.Util.RegisterUtil;
import ir.jahanshahloo.evmis.di.scopes.LoginRetrofit;
import ir.jahanshahloo.evmis.localdata.AppPreference;
import ir.jahanshahloo.evmis.model.GetRegisterModel;
import ir.jahanshahloo.evmis.model.RegisterModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alireza on 6/30/2016.
 */
public class RegisterActivity extends AppCompatActivity {
    Button btn_send;
    EditText txt_phone;
    @Inject
    @LoginRetrofit
    IRegisterService service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ((App) getApplication()).getRegisterComponent().inject(this);

        txt_phone = (EditText) findViewById(R.id.txt_phone_number_to_register);

        btn_send = (Button) findViewById(R.id.btn_send_to_register);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txt_phone.getText().toString();

                RegisterModel registerModel = new RegisterModel();
                registerModel.mobileNumber = phoneNumber;
                Log.i("ali_login", phoneNumber);
                Call<GetRegisterModel> call = service.sendPhoneNumber(registerModel);
                //async request
                call.enqueue(new Callback<GetRegisterModel>() {
                    @Override
                    public void onResponse(Call<GetRegisterModel> call, Response<GetRegisterModel> response) {
                        Log.i("ali_login", "Check login");

                        if (response.isSuccessful()) {
                            Log.i("ali_login", "success login");

                            // AppPreference preference = new AppPreference(getBaseContext());
                            GetRegisterModel model = response.body();
                            // Log.i("ali_login", model.code +" " +model.smsNumber);
                            Toast.makeText(getBaseContext(), model.code + " " + model.smsNumber, Toast.LENGTH_LONG).show();
                            /// preference.saveUserAuthenticationInfo();
                            Intent i = new Intent(RegisterActivity.this, ConfirmCodeBySmsActivity.class);
                            i.putExtra(RegisterUtil.CODE, model.code);
                            i.putExtra(RegisterUtil.SMS_NUMBER, model.smsNumber);
                            i.putExtra(RegisterUtil.USER_MOBILE_NUMBER, txt_phone.getText().toString());

                            startActivity(i);


                        } else {
                            ResponseBody errorBody = response.errorBody();
                            try {
                                String string = errorBody.string();


                                Log.i("ali_notresponse", response.message());
                                Log.i("ali_notresponse", string);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<GetRegisterModel> call, Throwable t) {
                        Log.i("ali_login", t.getMessage());

                    }
                });

            }
        });

    }
}
