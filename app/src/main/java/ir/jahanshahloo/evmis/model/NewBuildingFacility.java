package ir.jahanshahloo.evmis.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import ir.jahanshahloo.evmis.BR;
import ir.jahanshahloo.evmis.validation.NewRentHouseValidation;

public class NewBuildingFacility extends BaseObservable {

    private Boolean radiator;
    private Boolean chiler;
    private Boolean splite;
    private Boolean doctSplite;
    private Boolean heatOnFloor;
    private Boolean shomine;
    private Boolean mpackage;
    private Boolean cooler;
    private Boolean heater;
    private Boolean fanCuel;
    private Boolean yard;
    private Boolean open;
    private Boolean farangiToalet;
    private Boolean lobbby;
    private Boolean remoteDoor;
    private Boolean roofGarden;
    private Boolean centralVacuumCleaner;
    private Boolean centralAnnten;
    private Boolean barbecue;
    private Boolean secureityCamera;
    private Boolean smartSystem;
    private Boolean fitnessSlon;
    private Boolean jonitor;
    private Boolean garbage;
    private Boolean balcony;
    private Boolean parking;
    private Boolean elevator;
    private Boolean pool;
    private Boolean jacuzzi;
    private Boolean wareHouse;
    private Boolean electricite;
    private Boolean water;
    private Boolean gas;
    private Boolean sauna;
    private Boolean hasKitchen;
private NewRentHouseValidation validation;
    public NewBuildingFacility(NewRentHouseValidation validation) {
        this.validation=validation;
        this.setRadiator(false);
        this.setChiler(false);
        this.setSplite(false);
        this.setDoctSplite(false);
        this.setHeatOnFloor(false);
        this.setShomine(false);
        this.setMpackage(false);
        this.setCooler(false);
        this.setHeater(false);
        this.setFanCuel(false);
        this.setYard(false);
        this.setOpen(false);
        this.setFarangiToalet(false);
        this.setLobbby(false);
        this.setRemoteDoor(false);
        this.setRoofGarden(false);
        this.setCentralVacuumCleaner(false);
        this.setCentralAnnten(false);
        this.setBarbecue(false);
        this.setSecureityCamera(false);
        this.setSmartSystem(false);
        this.setFitnessSlon(false);
        this.setJonitor(false);
        this.setGarbage(false);
        this.setBalcony(false);
        this.setParking(false);
        this.setElevator(false);
        this.setPool(false);
        this.setJacuzzi(false);
        this.setWareHouse(false);
        this.setElectricite(false);
        this.setWater(false);
        this.setGas(false);
        this.setSauna(false);
        this.setHasKitchen(false);

    }

    @Bindable
    public Boolean getRadiator() {
        return radiator;
    }

    public void setRadiator(Boolean radiator) {
        this.radiator = radiator;
        notifyPropertyChanged(BR.radiator);
    }

    @Bindable
    public Boolean getChiler() {
        return chiler;
    }

    public void setChiler(Boolean chiler) {
        this.chiler = chiler;
        notifyPropertyChanged(BR.chiler);
    }

    @Bindable
    public Boolean getSplite() {
        return splite;
    }

    public void setSplite(Boolean splite) {
        this.splite = splite;
        notifyPropertyChanged(BR.splite);
    }

    @Bindable
    public Boolean getDoctSplite() {
        return doctSplite;
    }

    public void setDoctSplite(Boolean doctSplite) {
        this.doctSplite = doctSplite;
        notifyPropertyChanged(BR.doctSplite);
    }

    @Bindable
    public Boolean getHeatOnFloor() {
        return heatOnFloor;
    }

    public void setHeatOnFloor(Boolean heatOnFloor) {
        this.heatOnFloor = heatOnFloor;
        notifyPropertyChanged(BR.heatOnFloor);
    }

    @Bindable
    public Boolean getShomine() {
        return shomine;
    }

    public void setShomine(Boolean shomine) {
        this.shomine = shomine;
        notifyPropertyChanged(BR.shomine);
    }

    @Bindable
    public Boolean getMpackage() {
        return mpackage;
    }

    public void setMpackage(Boolean mpackage) {
        this.mpackage = mpackage;
        notifyPropertyChanged(BR.mpackage);
    }

    @Bindable
    public Boolean getCooler() {
        return cooler;
    }

    public void setCooler(Boolean cooler) {
        this.cooler = cooler;
        notifyPropertyChanged(BR.cooler);
    }

    @Bindable
    public Boolean getHeater() {
        return heater;
    }

    public void setHeater(Boolean heater) {
        this.heater = heater;
        notifyPropertyChanged(BR.heater);
    }

    @Bindable
    public Boolean getFanCuel() {
        return fanCuel;
    }

    public void setFanCuel(Boolean fanCuel) {
        this.fanCuel = fanCuel;
        notifyPropertyChanged(BR.fanCuel);
    }

    @Bindable
    public Boolean getYard() {
        return yard;
    }

    public void setYard(Boolean yard) {
        this.yard = yard;
        notifyPropertyChanged(BR.yard);
    }

    @Bindable
    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
        notifyPropertyChanged(BR.open);
    }

    @Bindable
    public Boolean getFarangiToalet() {
        return farangiToalet;
    }

    public void setFarangiToalet(Boolean farangiToalet) {
        this.farangiToalet = farangiToalet;
        notifyPropertyChanged(BR.farangiToalet);
    }

    @Bindable
    public Boolean getLobbby() {
        return lobbby;
    }

    public void setLobbby(Boolean lobbby) {
        this.lobbby = lobbby;
        notifyPropertyChanged(BR.lobbby);
    }

    @Bindable
    public Boolean getRemoteDoor() {
        return remoteDoor;
    }

    public void setRemoteDoor(Boolean remoteDoor) {
        this.remoteDoor = remoteDoor;
        notifyPropertyChanged(BR.remoteDoor);
    }

    @Bindable
    public Boolean getRoofGarden() {
        return roofGarden;
    }

    public void setRoofGarden(Boolean roofGarden) {
        this.roofGarden = roofGarden;
        notifyPropertyChanged(BR.roofGarden);
    }

    @Bindable
    public Boolean getCentralVacuumCleaner() {
        return centralVacuumCleaner;
    }

    public void setCentralVacuumCleaner(Boolean centralVacuumCleaner) {
        this.centralVacuumCleaner = centralVacuumCleaner;
        notifyPropertyChanged(BR.centralVacuumCleaner);
    }

    @Bindable
    public Boolean getCentralAnnten() {
        return centralAnnten;
    }

    public void setCentralAnnten(Boolean centralAnnten) {
        this.centralAnnten = centralAnnten;
        notifyPropertyChanged(BR.centralAnnten);
    }

    @Bindable
    public Boolean getBarbecue() {
        return barbecue;
    }

    public void setBarbecue(Boolean barbecue) {
        this.barbecue = barbecue;
        notifyPropertyChanged(BR.barbecue);
    }

    @Bindable
    public Boolean getSecureityCamera() {
        return secureityCamera;
    }

    public void setSecureityCamera(Boolean secureityCamera) {
        this.secureityCamera = secureityCamera;
        notifyPropertyChanged(BR.secureityCamera);
    }

    @Bindable
    public Boolean getSmartSystem() {
        return smartSystem;
    }

    public void setSmartSystem(Boolean smartSystem) {
        this.smartSystem = smartSystem;
        notifyPropertyChanged(BR.smartSystem);
    }

    @Bindable
    public Boolean getFitnessSlon() {
        return fitnessSlon;
    }

    public void setFitnessSlon(Boolean fitnessSlon) {
        this.fitnessSlon = fitnessSlon;
        notifyPropertyChanged(BR.fitnessSlon);
    }

    @Bindable
    public Boolean getJonitor() {
        return jonitor;
    }

    public void setJonitor(Boolean jonitor) {
        this.jonitor = jonitor;
        notifyPropertyChanged(BR.jonitor);
    }

    @Bindable
    public Boolean getGarbage() {
        return garbage;
    }

    public void setGarbage(Boolean garbage) {
        this.garbage = garbage;
        notifyPropertyChanged(BR.garbage);
    }

    @Bindable
    public Boolean getBalcony() {
        return balcony;
    }

    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;
        notifyPropertyChanged(BR.balcony);
    }

    @Bindable
    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
        notifyPropertyChanged(BR.parking);
    }

    @Bindable
    public Boolean getElevator() {
        return elevator;
    }

    public void setElevator(Boolean elevator) {
        this.elevator = elevator;
        notifyPropertyChanged(BR.elevator);
    }

    @Bindable
    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
        notifyPropertyChanged(BR.pool);
    }

    @Bindable
    public Boolean getJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(Boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
        notifyPropertyChanged(BR.jacuzzi);
    }

    @Bindable
    public Boolean getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(Boolean wareHouse) {
        this.wareHouse = wareHouse;
        notifyPropertyChanged(BR.wareHouse);
    }

    @Bindable
    public Boolean getElectricite() {
        return electricite;
    }

    public void setElectricite(Boolean electricite) {
        this.electricite = electricite;
        notifyPropertyChanged(BR.electricite);
    }

    @Bindable
    public Boolean getWater() {
        return water;
    }

    public void setWater(Boolean water) {
        this.water = water;
        notifyPropertyChanged(BR.water);
    }

    @Bindable
    public Boolean getGas() {
        return gas;
    }

    public void setGas(Boolean gas) {
        this.gas = gas;
        notifyPropertyChanged(BR.gas);
    }

    @Bindable
    public Boolean getSauna() {
        return sauna;
    }

    public void setSauna(Boolean sauna) {
        this.sauna = sauna;
        notifyPropertyChanged(BR.sauna);
    }

    @Bindable
    public Boolean getHasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(Boolean hasKitchen) {
        this.hasKitchen = hasKitchen;
        notifyPropertyChanged(BR.hasKitchen);
    }
}
