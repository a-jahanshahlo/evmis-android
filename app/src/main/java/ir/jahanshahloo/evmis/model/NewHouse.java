package ir.jahanshahloo.evmis.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.Date;

import ir.jahanshahloo.evmis.BR;
import ir.jahanshahloo.evmis.validation.NewRentHouseValidation;

public class NewHouse extends BaseObservable {
    private Boolean isPreSales;
    private Integer dateHouseCreated;
    private Date dateHouseCreatedEn;
    private Integer hasKitchen;
    private Boolean hasFloorCovering;
    private Integer area;
    private Integer houseGeoViewId;
    private Integer houseViewId;
    private Integer houseTypeId;
    private Integer cabinetId;
    private Integer floorCoveringId;
    private Integer proofOwnershipId;
    private Integer livingStateId;
    private Integer numberOfFloors;
    private Integer numberUnitOnFloor;
    private Integer toulBar;
    private Integer arzeGozar;
    private Integer eslahi;
    private Integer ownerPercent;
    private Integer foundation;
    private Integer height;
    private Boolean isPenthouse;
    private Boolean isOffice;
    private Boolean dastor;
    private Boolean collaborative;
    private Integer registerDate;
    private Integer room;
    private Integer floorId;
    private Double geoLatitude;
    private Double geoLongitude;
    private NewAddress address;
private NewRentHouseValidation validation;
    public NewHouse(NewRentHouseValidation validation) {
        this.validation=validation;
        this.setAddress(new NewAddress());
        this.setPreSales(false);
        this.setDateHouseCreated(0);
        this.setDateHouseCreatedEn(new Date());
        this.setHasKitchen(0);
        this.setHasFloorCovering(false);
        this.setArea(0);
        this.setHouseGeoViewId(0);
        this.setHouseViewId(0);
        this.setCabinetId(0);
        this.setFloorCoveringId(0);
        this.setProofOwnershipId(0);
        this.setLivingStateId(0);
        this.setNumberOfFloors(0);
        this.setNumberUnitOnFloor(0);
        this.setToulBar(0);
        this.setArzeGozar(0);
        this.setEslahi(0);
        this.setOwnerPercent(0);
        this.setFoundation(0);
        this.setFloorId(1);
        this.setHeight(0);
        this.setRoom(0);
        this.setPenthouse(false);
        this.setOffice(false);
        this.setDastor(false);
        this.setCollaborative(false);
        this.setRegisterDate(0);
        this.setGeoLatitude(0d);
        this.setGeoLongitude(0d);
        this.setHouseTypeId(0);
    }

    @Bindable
    public Boolean getPreSales() {
        return isPreSales;
    }

    public void setPreSales(Boolean preSales) {
        isPreSales = preSales;
        notifyPropertyChanged(BR.preSales);
    }

    @Bindable
    public Integer getDateHouseCreated() {
        return dateHouseCreated;
    }

    public void setDateHouseCreated(Integer dateHouseCreated) {
        this.dateHouseCreated = dateHouseCreated;
        notifyPropertyChanged(BR.dateHouseCreated);
    }


    public Date getDateHouseCreatedEn() {
        return dateHouseCreatedEn;
    }

    public void setDateHouseCreatedEn(Date dateHouseCreatedEn) {
        this.dateHouseCreatedEn = dateHouseCreatedEn;

    }

    @Bindable
    public Integer getHasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(Integer hasKitchen) {
        this.hasKitchen = hasKitchen;
        notifyPropertyChanged(BR.hasKitchen);
    }

    @Bindable
    public Boolean getHasFloorCovering() {
        return hasFloorCovering;
    }

    public void setHasFloorCovering(Boolean hasFloorCovering) {
        this.hasFloorCovering = hasFloorCovering;
        notifyPropertyChanged(BR.hasFloorCovering);
    }

    @Bindable
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
        notifyPropertyChanged(BR.area);
    }

    @Bindable
    public Integer getHouseGeoViewId() {
        return houseGeoViewId;
    }

    public void setHouseGeoViewId(Integer houseGeoViewId) {
        this.houseGeoViewId = houseGeoViewId;
        notifyPropertyChanged(BR.houseGeoViewId);
    }

    @Bindable
    public Integer getHouseViewId() {
        return houseViewId;
    }

    public void setHouseViewId(Integer houseViewId) {
        this.houseViewId = houseViewId;
        notifyPropertyChanged(BR.houseViewId);
    }

    @Bindable
    public Integer getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Integer cabinetId) {
        this.cabinetId = cabinetId;
        notifyPropertyChanged(BR.cabinetId);
    }

    @Bindable
    public Integer getFloorCoveringId() {
        return floorCoveringId;
    }

    public void setFloorCoveringId(Integer floorCoveringId) {
        this.floorCoveringId = floorCoveringId;
        notifyPropertyChanged(BR.floorCoveringId);
    }

    @Bindable
    public Integer getProofOwnershipId() {
        return proofOwnershipId;
    }

    public void setProofOwnershipId(Integer proofOwnershipId) {
        this.proofOwnershipId = proofOwnershipId;
        notifyPropertyChanged(BR.proofOwnershipId);
    }

    @Bindable
    public Integer getLivingStateId() {
        return livingStateId;
    }

    public void setLivingStateId(Integer livingStateId) {
        this.livingStateId = livingStateId;
        notifyPropertyChanged(BR.livingStateId);
    }

    @Bindable
    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        notifyPropertyChanged(BR.numberOfFloors);
    }

    @Bindable
    public Integer getNumberUnitOnFloor() {
        return numberUnitOnFloor;
    }

    public void setNumberUnitOnFloor(Integer numberUnitOnFloor) {
        this.numberUnitOnFloor = numberUnitOnFloor;
        notifyPropertyChanged(BR.numberUnitOnFloor);
    }

    @Bindable
    public Integer getToulBar() {
        return toulBar;
    }

    public void setToulBar(Integer toulBar) {
        this.toulBar = toulBar;
        notifyPropertyChanged(BR.toulBar);
    }

    @Bindable
    public Integer getArzeGozar() {
        return arzeGozar;
    }

    public void setArzeGozar(Integer arzeGozar) {
        this.arzeGozar = arzeGozar;
        notifyPropertyChanged(BR.arzeGozar);
    }

    @Bindable
    public Integer getEslahi() {
        return eslahi;
    }

    public void setEslahi(Integer eslahi) {
        this.eslahi = eslahi;
        notifyPropertyChanged(BR.eslahi);
    }

    @Bindable
    public Integer getOwnerPercent() {
        return ownerPercent;
    }

    public void setOwnerPercent(Integer ownerPercent) {
        this.ownerPercent = ownerPercent;
        notifyPropertyChanged(BR.ownerPercent);
    }

    @Bindable
    public Integer getFoundation() {
        return foundation;
    }

    public void setFoundation(Integer foundation) {
        this.foundation = foundation;
        notifyPropertyChanged(BR.foundation);
    }

    @Bindable
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
        notifyPropertyChanged(BR.height);
    }

    @Bindable
    public Boolean getPenthouse() {
        return isPenthouse;
    }

    public void setPenthouse(Boolean penthouse) {
        isPenthouse = penthouse;
        notifyPropertyChanged(BR.penthouse);
    }

    @Bindable
    public Boolean getOffice() {
        return isOffice;
    }

    public void setOffice(Boolean office) {
        isOffice = office;
        notifyPropertyChanged(BR.office);
    }

    @Bindable
    public Boolean getDastor() {
        return dastor;
    }

    public void setDastor(Boolean dastor) {
        this.dastor = dastor;
        notifyPropertyChanged(BR.dastor);
    }

    @Bindable
    public Boolean getCollaborative() {
        return collaborative;
    }

    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
        notifyPropertyChanged(BR.collaborative);
    }


    public Integer getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Integer registerDate) {
        this.registerDate = registerDate;

    }

    @Bindable
    public Double getGeoLatitude() {
        return geoLatitude;
    }

    public void setGeoLatitude(Double geoLatitude) {
        this.geoLatitude = geoLatitude;
        notifyPropertyChanged(BR.geoLatitude);
    }

    @Bindable
    public Double getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoLongitude(Double geoLongitude) {
        this.geoLongitude = geoLongitude;
        notifyPropertyChanged(BR.address);
    }

    @Bindable
    public NewAddress getAddress() {
        return address;
    }

    public void setAddress(NewAddress address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    @Bindable
    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
        notifyPropertyChanged(BR.houseTypeId);
        validation.HouseTypeValidation(houseTypeId);
    }

    @Bindable
    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
        notifyPropertyChanged(BR.room);
    }

    @Bindable
    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
        notifyPropertyChanged(BR.floorId);
    }
}
