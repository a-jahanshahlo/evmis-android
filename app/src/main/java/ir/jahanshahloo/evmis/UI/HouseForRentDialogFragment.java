package ir.jahanshahloo.evmis.UI;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.appyvet.rangebar.RangeBar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Service.Contract.IBaseDataService;
import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.Util.NumberToWordsLib;
import ir.jahanshahloo.evmis.model.BaseModel;
import ir.jahanshahloo.evmis.model.City;
import ir.jahanshahloo.evmis.model.HouseType;
import ir.jahanshahloo.evmis.model.Province;
import ir.jahanshahloo.evmis.model.RentAdvertiseType;
import ir.jahanshahloo.evmis.model.RentType;
import ir.jahanshahloo.evmis.model.TimeUnit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ali on 8/9/2016.
 */
public class HouseForRentDialogFragment extends DialogFragment {

    AppCompatSpinner _provinceSpinner;

    AppCompatSpinner _citySpinner;
    AppCompatSpinner _rentadvertisetype;
    AppCompatSpinner _housetype;
    AppCompatSpinner _rentType;
    AppCompatSpinner _timeUnit;
    AppCompatButton _okButton, _cancelButton;
    @Inject
    IBaseDataService iBaseDataService;
    RangeBar range_room, range_area, range_price;
    TextView rightIndexValue, leftIndexValue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_house_for_rent, container, false);

        ((App) view.getContext().getApplicationContext()).getBaseDataComponent().inject(this);
        getDialog().setTitle("My Dialog Title");
        range_area = (RangeBar) view.findViewById(R.id.range_area);
        range_price = (RangeBar) view.findViewById(R.id.range_price);
        range_room = (RangeBar) view.findViewById(R.id.range_room);
        _cancelButton = (AppCompatButton) view.findViewById(R.id.action_cancel_search_rent);
        _okButton = (AppCompatButton) view.findViewById(R.id.action_ok_search_rent);

        _provinceSpinner = (AppCompatSpinner) view.findViewById(R.id.house_for_rent_spinner_province);
        _citySpinner = (AppCompatSpinner) view.findViewById(R.id.house_for_rent_spinner_city);
        _rentadvertisetype = (AppCompatSpinner) view.findViewById(R.id.house_for_rent_spinner_rentadvertisetype);
        _housetype = (AppCompatSpinner) view.findViewById(R.id.house_for_rent_spinner_housetype);
        _rentType = (AppCompatSpinner) view.findViewById(R.id.house_for_rent_spinner_rentType);
        _timeUnit = (AppCompatSpinner) view.findViewById(R.id.house_for_rent_spinner_timeUnit);
        leftIndexValue = (TextView) view.findViewById(R.id.tv_left_range_price);
        rightIndexValue = (TextView) view.findViewById(R.id.tv_right_range_price);

        _provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BaseModel province = (BaseModel) parent.getSelectedItem();
                Toast.makeText(view.getContext(), "province ID: " + province.getId() + ",  province Name : " + province.getTitle(), Toast.LENGTH_SHORT).show();
                bindCity(view.getContext(), province.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        setupSpinner(view.getContext());


        range_price.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {


                leftIndexValue.setText(NumberToWordsLib.BigNumberToWords.getWordsFromNumber(leftPinIndex).getValueAsString());
                rightIndexValue.setText(NumberToWordsLib.BigNumberToWords.getWordsFromNumber(rightPinIndex).getValueAsString());
            }
        });
        _cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        _okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    private void setupSpinner(Context context) {
        bindModel(context,_provinceSpinner,iBaseDataService.getProvince().clone());
        bindModel(context,_rentadvertisetype,iBaseDataService.getRentAdvertiseType());
        bindModel(context,_housetype,iBaseDataService.getHouseType());
        bindModel(context,_rentType,iBaseDataService.getRentType());
        bindModel(context,_timeUnit,iBaseDataService.getTimeUnit());
    }
    private void bindModel(final Context context, final AppCompatSpinner _spinner, Call<List<BaseModel>> call) {
        Log.i("ali", "bind RentAdvertiseType");

        call.enqueue(new Callback<List<BaseModel>>() {
            @Override
            public void onResponse(Call<List<BaseModel>> call, Response<List<BaseModel>> response) {
                Log.i("ali", "load RentAdvertiseType");
                if (response.isSuccessful()) {
                    Log.i("ali", "load RentAdvertiseType successfully");

                    List<BaseModel> list = response.body();

                    ArrayAdapter<BaseModel> adapter = new ArrayAdapter<BaseModel>(context, R.layout.custom_spinner_textview, list);
                    _spinner.setAdapter(adapter);
                } else {
                    Log.i("ali", "load RentAdvertiseType error");

                }
            }

            @Override
            public void onFailure(Call<List<BaseModel>> call, Throwable t) {
                Log.e("ali", t.getMessage());

            }
        });
    }

    private void bindCity(final Context context, int province) {
        Log.i("ali", "bind city");

        Call<List<BaseModel>> city = iBaseDataService.getCity(province);
        city.enqueue(new Callback<List<BaseModel>>() {
            @Override
            public void onResponse(Call<List<BaseModel>> call, Response<List<BaseModel>> response) {
                Log.i("ali", "load city");
                if (response.isSuccessful()) {
                    Log.i("ali", "load city successfully");

                    List<BaseModel> cityList = response.body();

                    ArrayAdapter<BaseModel> adapter = new ArrayAdapter<BaseModel>(context, R.layout.custom_spinner_textview, cityList);
                    _citySpinner.setAdapter(adapter);
                } else {
                    Log.i("ali", "load city error");

                }
            }

            @Override
            public void onFailure(Call<List<BaseModel>> call, Throwable t) {
                Log.e("ali", t.getMessage());

            }
        });
    }


//dismiss

}
