package ir.jahanshahloo.evmis.model;

/**
 * Created by Ali on 8/8/2016.
 */

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

public class BuildingFacility extends BaseObservable{

    private Integer id;
    private Boolean radiator;
    private Boolean chiler;
    private Boolean splite;
    private Boolean doctSplite;
    private Boolean heatOnFloor;
    private Boolean shomine;
    private Boolean mPackage;
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

    /**
     *
     * @return
     * The id
     */
    @Bindable
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;        notifyPropertyChanged(BR.id);

    }

    /**
     *
     * @return
     * The radiator
     */
    @Bindable   public Boolean getRadiator() {
        return radiator;
    }

    /**
     *
     * @param radiator
     * The radiator
     */
    public void setRadiator(Boolean radiator) {
        this.radiator = radiator;        notifyPropertyChanged(BR.radiator);

    }

    /**
     *
     * @return
     * The chiler
     */
    @Bindable  public Boolean getChiler() {
        return chiler;
    }

    /**
     *
     * @param chiler
     * The chiler
     */
    public void setChiler(Boolean chiler) {
        this.chiler = chiler;        notifyPropertyChanged(BR.chiler);

    }

    /**
     *
     * @return
     * The splite
     */
    @Bindable  public Boolean getSplite() {
        return splite;
    }

    /**
     *
     * @param splite
     * The splite
     */
    public void setSplite(Boolean splite) {
        this.splite = splite;        notifyPropertyChanged(BR.splite);

    }

    /**
     *
     * @return
     * The doctSplite
     */
    @Bindable  public Boolean getDoctSplite() {
        return doctSplite;
    }

    /**
     *
     * @param doctSplite
     * The doctSplite
     */
    public void setDoctSplite(Boolean doctSplite) {
        this.doctSplite = doctSplite;        notifyPropertyChanged(BR.doctSplite);

    }

    /**
     *
     * @return
     * The heatOnFloor
     */
    @Bindable public Boolean getHeatOnFloor() {
        return heatOnFloor;
    }

    /**
     *
     * @param heatOnFloor
     * The heatOnFloor
     */
    public void setHeatOnFloor(Boolean heatOnFloor) {
        this.heatOnFloor = heatOnFloor;        notifyPropertyChanged(BR.heatOnFloor);

    }

    /**
     *
     * @return
     * The shomine
     */
    @Bindable public Boolean getShomine() {
        return shomine;
    }

    /**
     *
     * @param shomine
     * The shomine
     */
    public void setShomine(Boolean shomine) {
        this.shomine = shomine;        notifyPropertyChanged(BR.shomine);

    }

    /**
     *
     * @return
     * The _package
     */
    @Bindable public Boolean getMPackage() {
        return mPackage;
    }

    /**
     *
     * @param _package
     * The package
     */
    public void setMPackage(Boolean _package) {
        this.mPackage = _package;
        notifyPropertyChanged(BR.mPackage);
    }

    /**
     *
     * @return
     * The cooler
     */
    @Bindable  public Boolean getCooler() {
        return cooler;
    }

    /**
     *
     * @param cooler
     * The cooler
     */
    public void setCooler(Boolean cooler) {
        this.cooler = cooler;        notifyPropertyChanged(BR.cooler);

    }

    /**
     *
     * @return
     * The heater
     */
    @Bindable   public Boolean getHeater() {
        return heater;
    }

    /**
     *
     * @param heater
     * The heater
     */
    public void setHeater(Boolean heater) {
        this.heater = heater;        notifyPropertyChanged(BR.heater);

    }

    /**
     *
     * @return
     * The fanCuel
     */
    @Bindable public Boolean getFanCuel() {
        return fanCuel;
    }

    /**
     *
     * @param fanCuel
     * The fanCuel
     */
    public void setFanCuel(Boolean fanCuel) {
        this.fanCuel = fanCuel;        notifyPropertyChanged(BR.fanCuel);

    }

    /**
     *
     * @return
     * The yard
     */
    @Bindable   public Boolean getYard() {
        return yard;
    }

    /**
     *
     * @param yard
     * The yard
     */
    public void setYard(Boolean yard) {
        this.yard = yard;        notifyPropertyChanged(BR.yard);

    }

    /**
     *
     * @return
     * The open
     */
    @Bindable  public Boolean getOpen() {
        return open;
    }

    /**
     *
     * @param open
     * The open
     */
    public void setOpen(Boolean open) {
        this.open = open;        notifyPropertyChanged(BR.open);

    }

    /**
     *
     * @return
     * The farangiToalet
     */
    @Bindable  public Boolean getFarangiToalet() {
        return farangiToalet;
    }

    /**
     *
     * @param farangiToalet
     * The farangiToalet
     */
    public void setFarangiToalet(Boolean farangiToalet) {
        this.farangiToalet = farangiToalet;        notifyPropertyChanged(BR.farangiToalet);

    }

    /**
     *
     * @return
     * The lobbby
     */
    @Bindable public Boolean getLobbby() {
        return lobbby;
    }

    /**
     *
     * @param lobbby
     * The lobbby
     */
    public void setLobbby(Boolean lobbby) {
        this.lobbby = lobbby;        notifyPropertyChanged(BR.lobbby);

    }

    /**
     *
     * @return
     * The remoteDoor
     */
    @Bindable   public Boolean getRemoteDoor() {
        return remoteDoor;
    }

    /**
     *
     * @param remoteDoor
     * The remoteDoor
     */
    public void setRemoteDoor(Boolean remoteDoor) {
        this.remoteDoor = remoteDoor;        notifyPropertyChanged(BR.remoteDoor);

    }

    /**
     *
     * @return
     * The roofGarden
     */
    @Bindable  public Boolean getRoofGarden() {
        return roofGarden;
    }

    /**
     *
     * @param roofGarden
     * The roofGarden
     */
    public void setRoofGarden(Boolean roofGarden) {
        this.roofGarden = roofGarden;        notifyPropertyChanged(BR.roofGarden);

    }

    /**
     *
     * @return
     * The centralVacuumCleaner
     */
    @Bindable   public Boolean getCentralVacuumCleaner() {
        return centralVacuumCleaner;
    }

    /**
     *
     * @param centralVacuumCleaner
     * The centralVacuumCleaner
     */
    public void setCentralVacuumCleaner(Boolean centralVacuumCleaner) {
        this.centralVacuumCleaner = centralVacuumCleaner;        notifyPropertyChanged(BR.centralVacuumCleaner);

    }

    /**
     *
     * @return
     * The centralAnnten
     */
    @Bindable  public Boolean getCentralAnnten() {
        return centralAnnten;
    }

    /**
     *
     * @param centralAnnten
     * The centralAnnten
     */
    public void setCentralAnnten(Boolean centralAnnten) {
        this.centralAnnten = centralAnnten;        notifyPropertyChanged(BR.centralAnnten);

    }

    /**
     *
     * @return
     * The barbecue
     */
    @Bindable  public Boolean getBarbecue() {
        return barbecue;
    }

    /**
     *
     * @param barbecue
     * The barbecue
     */
    public void setBarbecue(Boolean barbecue) {
        this.barbecue = barbecue;        notifyPropertyChanged(BR.barbecue);

    }

    /**
     *
     * @return
     * The secureityCamera
     */
    @Bindable  public Boolean getSecureityCamera() {
        return secureityCamera;
    }

    /**
     *
     * @param secureityCamera
     * The secureityCamera
     */
    public void setSecureityCamera(Boolean secureityCamera) {
        this.secureityCamera = secureityCamera;        notifyPropertyChanged(BR.secureityCamera);

    }

    /**
     *
     * @return
     * The smartSystem
     */
    @Bindable public Boolean getSmartSystem() {
        return smartSystem;
    }

    /**
     *
     * @param smartSystem
     * The smartSystem
     */
    public void setSmartSystem(Boolean smartSystem) {
        this.smartSystem = smartSystem;        notifyPropertyChanged(BR.smartSystem);

    }

    /**
     *
     * @return
     * The fitnessSlon
     */
    @Bindable  public Boolean getFitnessSlon() {
        return fitnessSlon;
    }

    /**
     *
     * @param fitnessSlon
     * The fitnessSlon
     */
    public void setFitnessSlon(Boolean fitnessSlon) {
        this.fitnessSlon = fitnessSlon;        notifyPropertyChanged(BR.fitnessSlon);

    }

    /**
     *
     * @return
     * The jonitor
     */
    @Bindable public Boolean getJonitor() {
        return jonitor;
    }

    /**
     *
     * @param jonitor
     * The jonitor
     */
    public void setJonitor(Boolean jonitor) {
        this.jonitor = jonitor;        notifyPropertyChanged(BR.jonitor);

    }

    /**
     *
     * @return
     * The garbage
     */
    @Bindable public Boolean getGarbage() {
        return garbage;
    }

    /**
     *
     * @param garbage
     * The garbage
     */
    public void setGarbage(Boolean garbage) {
        this.garbage = garbage;        notifyPropertyChanged(BR.garbage);

    }

    /**
     *
     * @return
     * The balcony
     */
    @Bindable  public Boolean getBalcony() {
        return balcony;
    }

    /**
     *
     * @param balcony
     * The balcony
     */
    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;        notifyPropertyChanged(BR.balcony);

    }

    /**
     *
     * @return
     * The parking
     */
    @Bindable public Boolean getParking() {
        return parking;
    }

    /**
     *
     * @param parking
     * The parking
     */
    public void setParking(Boolean parking) {
        this.parking = parking;        notifyPropertyChanged(BR.parking);

    }

    /**
     *
     * @return
     * The elevator
     */
    @Bindable  public Boolean getElevator() {
        return elevator;
    }

    /**
     *
     * @param elevator
     * The elevator
     */
    public void setElevator(Boolean elevator) {
        this.elevator = elevator;        notifyPropertyChanged(BR.elevator);

    }

    /**
     *
     * @return
     * The pool
     */
    @Bindable  public Boolean getPool() {
        return pool;
    }

    /**
     *
     * @param pool
     * The pool
     */
    public void setPool(Boolean pool) {
        this.pool = pool;        notifyPropertyChanged(BR.pool);

    }

    /**
     *
     * @return
     * The jacuzzi
     */
    @Bindable  public Boolean getJacuzzi() {
        return jacuzzi;
    }

    /**
     *
     * @param jacuzzi
     * The jacuzzi
     */
    public void setJacuzzi(Boolean jacuzzi) {
        this.jacuzzi = jacuzzi;        notifyPropertyChanged(BR.jacuzzi);

    }

    /**
     *
     * @return
     * The wareHouse
     */
    @Bindable  public Boolean getWareHouse() {
        return wareHouse;
    }

    /**
     *
     * @param wareHouse
     * The wareHouse
     */
    public void setWareHouse(Boolean wareHouse) {
        this.wareHouse = wareHouse;        notifyPropertyChanged(BR.wareHouse);

    }

    /**
     *
     * @return
     * The electricite
     */
    @Bindable  public Boolean getElectricite() {
        return electricite;
    }

    /**
     *
     * @param electricite
     * The electricite
     */
    public void setElectricite(Boolean electricite) {
        this.electricite = electricite;        notifyPropertyChanged(BR.electricite);

    }

    /**
     *
     * @return
     * The water
     */
    @Bindable  public Boolean getWater() {
        return water;
    }

    /**
     *
     * @param water
     * The water
     */
    public void setWater(Boolean water) {
        this.water = water;        notifyPropertyChanged(BR.water);

    }

    /**
     *
     * @return
     * The gas
     */
    @Bindable  public Boolean getGas() {
        return gas;
    }

    /**
     *
     * @param gas
     * The gas
     */
    public void setGas(Boolean gas) {
        this.gas = gas;        notifyPropertyChanged(BR.gas);

    }

    /**
     *
     * @return
     * The sauna
     */
    @Bindable public Boolean getSauna() {
        return sauna;
    }

    /**
     *
     * @param sauna
     * The sauna
     */
    public void setSauna(Boolean sauna) {
        this.sauna = sauna;        notifyPropertyChanged(BR.sauna);

    }

    /**
     *
     * @return
     * The hasKitchen
     */
    @Bindable  public Boolean getHasKitchen() {
        return hasKitchen;
    }

    /**
     *
     * @param hasKitchen
     * The hasKitchen
     */
    public void setHasKitchen(Boolean hasKitchen) {
        this.hasKitchen = hasKitchen;        notifyPropertyChanged(BR.hasKitchen);

    }
}
