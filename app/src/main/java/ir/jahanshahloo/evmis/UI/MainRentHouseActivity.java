package ir.jahanshahloo.evmis.UI;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.databinding.ActivityMainRentHouseBinding;

public class MainRentHouseActivity extends AppCompatActivity {

  //  ActivityMainRentHouseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainRentHouseBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main_rent_house);

        setSupportActionBar(binding.toolbarMainRent);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Test2");
        binding.toolbarMainRent.setSubtitle("ghjghj");


    }
}
