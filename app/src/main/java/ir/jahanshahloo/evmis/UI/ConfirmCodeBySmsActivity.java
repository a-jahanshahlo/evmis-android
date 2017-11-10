package ir.jahanshahloo.evmis.UI;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import ir.jahanshahloo.evmis.R;

import ir.jahanshahloo.evmis.Service.Contract.IRegisterService;

import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.Util.RegisterUtil;
import ir.jahanshahloo.evmis.di.scopes.LoginRetrofit;
import ir.jahanshahloo.evmis.localdata.AppPreference;
import ir.jahanshahloo.evmis.model.AccessTokenModel;
import ir.jahanshahloo.evmis.model.RegisterModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmCodeBySmsActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txt_code;
    TextView txt_smsNumber;
    ProgressDialog progress;
    private Boolean isActiveUser = false;

    @Inject
    @LoginRetrofit
    IRegisterService service;
    RegisterModel model;
    int counter = 0;
    Thread threadLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_code_by_sms);
        ((App)getApplication()).getRegisterComponent().inject(this);


        model = new RegisterModel();

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txt_code = (TextView) findViewById(R.id.activation_code);
        txt_smsNumber = (TextView) findViewById(R.id.sms_center_number);

        Intent i = getIntent();
        txt_code.setText(i.getStringExtra(RegisterUtil.CODE));
        txt_smsNumber.setText(i.getStringExtra(RegisterUtil.SMS_NUMBER));
        model.mobileNumber = i.getStringExtra(RegisterUtil.USER_MOBILE_NUMBER);

        Button btn_send_sms = (Button) findViewById(R.id.btn_send_confirm_sms);
        btn_send_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  sendSMS(txt_smsNumber.getText().toString(), txt_code.getText().toString());
                showProgress();

            }
        });
        progress = new ProgressDialog(ConfirmCodeBySmsActivity.this);
        progress.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                counter = 1000;
            }
        });
        progress.setButton(DialogInterface.BUTTON_POSITIVE, "Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showProgress();
            }
        });
        progress.setTitle("Wait");
        progress.setMessage("Please wait for server");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCancelable(true);

    }

    private void showProgress() {
        final int totalProgressTime = 100;

         progress.setProgress(0);
      //  progress.setIndeterminate(true);
        progress.show();


        threadLogin = new Thread(new Runnable() {
            @Override
            public void run() {
                counter = 0;
                int second=0;
                while ((counter < totalProgressTime) && !isActiveUser) {
                    //  Log.i("ali_login", String.valueOf(counter) + " ====== " + String.valueOf(isActiveUser));
                    //  Log.i("ali_login", String.valueOf((counter % 20)));

                    if ((counter % 50) == 0) {
                        ///  Log.i("ali_login", "Call Active API");

                        isUserActive();
                    }


                    counter += 1;
                     progress.setProgress(counter);

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                progress.dismiss();
            }
        });
        threadLogin.start();
    }

    private boolean isUserActive() {

        Call<AccessTokenModel> call = service.sendLogin(model.grant_type, model.mobileNumber);
        call.enqueue(new Callback<AccessTokenModel>() {
            @Override
            public void onResponse(Call<AccessTokenModel> call, Response<AccessTokenModel> response) {
                if (response.isSuccessful()) {
                    AccessTokenModel accessTokenModel = response.body();
                    Log.i("ali_login_success", accessTokenModel.access_token);


                    isActiveUser = true;
                    AppPreference preference =new AppPreference(getBaseContext());
                    preference.saveTokenModel(accessTokenModel);
                    Intent i =new Intent(ConfirmCodeBySmsActivity.this,MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    finish();
                    Log.i("ali_login_success",preference.getExpireTime());
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
            public void onFailure(Call<AccessTokenModel> call, Throwable t) {
                Log.i("ali_login_error", t.getMessage());
            }
        });

        return isActiveUser;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(ConfirmCodeBySmsActivity.this, RegisterActivity.class);
        startActivity(i);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void sendSMS(String phoneNumber, String message) {

        try {
            SmsManager sms = SmsManager.getDefault();


            sms.sendTextMessage(phoneNumber, null, message,
                    null, null);

        } catch (Exception e) {

            e.printStackTrace();
            Toast.makeText(getBaseContext(), "SMS sending failed...", Toast.LENGTH_SHORT).show();
        }

    }
}
