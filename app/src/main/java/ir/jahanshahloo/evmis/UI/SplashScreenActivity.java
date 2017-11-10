package ir.jahanshahloo.evmis.UI;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;


import ir.jahanshahloo.evmis.R;

import ir.jahanshahloo.evmis.localdata.AppPreference;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000;
AppPreference preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        } else {
            //for blow 21 API
        }
preference=new AppPreference(getBaseContext());
        //set activity to full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                if (!preference.isAuthorized()) {
                    Intent i = new Intent(SplashScreenActivity.this, RegisterActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(i);
                }


                // close this activity
                finish();
                //   overridePendingTransition(R.drawable.logo,R.drawable.logo);
            }
        }, SPLASH_TIME_OUT);
    }
}
