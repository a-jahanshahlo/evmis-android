package ir.jahanshahloo.evmis.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.android.databinding.library.baseAdapters.BR;

import ir.jahanshahloo.evmis.validation.NewRentHouseValidation;

/**
 * Created by Adminstrator on 10/5/2016.
 */
public class NewHouseForRent extends BaseObservable {
    private static final String TAG = "ali";
    private String phone;
    private String niceName;
    private String description;
    private Double price;
    private Integer rentAdvertiseTypeId;

    private Integer personId;
    private Integer rentTypeId;
    private Integer timeUnitId;
    private NewHouse house;
    private NewBuildingFacility buildingFacility;

    private NewRentHouseValidation validation;

    public NewHouseForRent() {
        this.setValidation(new NewRentHouseValidation());
        this.setPhone("");
        this.setBuildingFacility(new NewBuildingFacility( this.getValidation()));
        this.setDescription("");
        this.setHouse(new NewHouse( this.getValidation()));
        this.setNiceName("");
        this.setPrice(0d);
        this.setRentAdvertiseTypeId(0);
        this.setPersonId(-1);
        this.setRentTypeId(-1);
        this.setTimeUnitId(-1);


    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
        notifyPropertyChanged(BR.niceName);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public Integer getRentAdvertiseTypeId() {
        return rentAdvertiseTypeId;
    }

    public void setRentAdvertiseTypeId(Integer rentAdvertiseTypeId) {
        this.rentAdvertiseTypeId = rentAdvertiseTypeId;
        notifyPropertyChanged(BR.rentAdvertiseTypeId);
        Log.i(TAG, "setRentAdvertiseTypeId: " + rentAdvertiseTypeId);
    }

    @Bindable
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
        notifyPropertyChanged(BR.personId);
    }

    @Bindable
    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
        notifyPropertyChanged(BR.rentTypeId);
    }

    @Bindable
    public Integer getTimeUnitId() {
        return timeUnitId;
    }

    public void setTimeUnitId(Integer timeUnitId) {
        this.timeUnitId = timeUnitId;
        notifyPropertyChanged(BR.timeUnitId);
    }

    @Bindable
    public NewHouse getHouse() {
        return house;
    }

    public void setHouse(NewHouse house) {
        this.house = house;
        notifyPropertyChanged(BR.house);
    }

    @Bindable
    public NewBuildingFacility getBuildingFacility() {
        return buildingFacility;
    }

    public void setBuildingFacility(NewBuildingFacility buildingFacility) {
        this.buildingFacility = buildingFacility;
        notifyPropertyChanged(BR.buildingFacility);
    }

    public TextWatcher getNameWatcher() {
        return new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i(TAG, "onTextChanged: " + charSequence.toString());
                Double.parseDouble(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    public NewRentHouseValidation getValidation() {
        return validation;
    }

    public void setValidation(NewRentHouseValidation validation) {
        this.validation = validation;
    }
}

