package ir.jahanshahloo.evmis.model;

/**
 * Created by Ali on 8/8/2016.
 */

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import ir.jahanshahloo.evmis.BR;
import javax.annotation.Generated;




public class HouseForRent extends BaseObservable {


    private Integer id;

    private String phone;

    private String niceName;

    private String description;

    private Float price;

    private Integer rentAdvertiseTypeId;

    private Integer houseId;

    private Integer personId;

    private Integer rentTypeId;

    private Integer timeUnitId;

    private TimeUnit timeUnit;

    private House house;

    private RentType rentType;

    private RentAdvertiseType rentAdvertiseType;

    private BuildingFacility buildingFacility;

    @Bindable
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
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
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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
    }

    @Bindable
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
        notifyPropertyChanged(BR.houseId);
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
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        notifyPropertyChanged(BR.timeUnit);
    }

    @Bindable
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
        notifyPropertyChanged(BR.house);
    }

    @Bindable
    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
        notifyPropertyChanged(BR.rentType);
    }


    @Bindable
    public RentAdvertiseType getRentAdvertiseType() {
        return rentAdvertiseType;
    }


    public void setRentAdvertiseType(RentAdvertiseType rentAdvertiseType) {
        this.rentAdvertiseType = rentAdvertiseType;
        notifyPropertyChanged(BR.rentAdvertiseType);
    }


    @Bindable
    public BuildingFacility getBuildingFacility() {
        return buildingFacility;
    }


    public void setBuildingFacility(BuildingFacility buildingFacility) {
        this.buildingFacility = buildingFacility;
        notifyPropertyChanged(BR.buildingFacility);
    }

}