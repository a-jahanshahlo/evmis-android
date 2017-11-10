package ir.jahanshahloo.evmis.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import ir.jahanshahloo.evmis.BR;

public class NewAddress extends BaseObservable {
    private String address1;
    private String postalCode;
    private Integer cityId;

    public NewAddress() {
        this.setAddress1("");
        this.setCityId(-1);
        this.setPostalCode("");
    }

    @Bindable
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
        notifyPropertyChanged(BR.address1);
    }

    @Bindable
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        notifyPropertyChanged(BR.postalCode);
    }

    @Bindable
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
        notifyPropertyChanged(BR.cityId);
    }
}
