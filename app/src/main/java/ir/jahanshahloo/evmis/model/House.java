package ir.jahanshahloo.evmis.model;

/**
 * Created by Ali on 8/8/2016.
 */


import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class House {

    private Integer id;
    private Integer dateHouseCreated;
    private String dateHouseCreatedEn;
    private Object hasKitchen;
    private Object hasFloorCovering;
    private Integer area;
    private Integer houseGeoViewId;
    private Integer houseViewId;
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
    private Double geoLatitude;
    private Double geoLongitude;
    private Address address;
    private Integer room;
    private Floor floor;
    private HasNumberFloor hasNumberFloor;
    private HouseType houseType;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The dateHouseCreated
     */
    public Integer getDateHouseCreated() {
        return dateHouseCreated;
    }

    /**
     *
     * @param dateHouseCreated
     * The dateHouseCreated
     */
    public void setDateHouseCreated(Integer dateHouseCreated) {
        this.dateHouseCreated = dateHouseCreated;
    }

    /**
     *
     * @return
     * The dateHouseCreatedEn
     */
    public String getDateHouseCreatedEn() {
        return dateHouseCreatedEn;
    }

    /**
     *
     * @param dateHouseCreatedEn
     * The dateHouseCreatedEn
     */
    public void setDateHouseCreatedEn(String dateHouseCreatedEn) {
        this.dateHouseCreatedEn = dateHouseCreatedEn;
    }

    /**
     *
     * @return
     * The hasKitchen
     */
    public Object getHasKitchen() {
        return hasKitchen;
    }

    /**
     *
     * @param hasKitchen
     * The hasKitchen
     */
    public void setHasKitchen(Object hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

    /**
     *
     * @return
     * The hasFloorCovering
     */
    public Object getHasFloorCovering() {
        return hasFloorCovering;
    }

    /**
     *
     * @param hasFloorCovering
     * The hasFloorCovering
     */
    public void setHasFloorCovering(Object hasFloorCovering) {
        this.hasFloorCovering = hasFloorCovering;
    }

    /**
     *
     * @return
     * The area
     */
    public Integer getArea() {
        return area;
    }

    /**
     *
     * @param area
     * The area
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     *
     * @return
     * The houseGeoViewId
     */
    public Integer getHouseGeoViewId() {
        return houseGeoViewId;
    }

    /**
     *
     * @param houseGeoViewId
     * The houseGeoViewId
     */
    public void setHouseGeoViewId(Integer houseGeoViewId) {
        this.houseGeoViewId = houseGeoViewId;
    }

    /**
     *
     * @return
     * The houseViewId
     */
    public Integer getHouseViewId() {
        return houseViewId;
    }

    /**
     *
     * @param houseViewId
     * The houseViewId
     */
    public void setHouseViewId(Integer houseViewId) {
        this.houseViewId = houseViewId;
    }

    /**
     *
     * @return
     * The cabinetId
     */
    public Integer getCabinetId() {
        return cabinetId;
    }

    /**
     *
     * @param cabinetId
     * The cabinetId
     */
    public void setCabinetId(Integer cabinetId) {
        this.cabinetId = cabinetId;
    }

    /**
     *
     * @return
     * The floorCoveringId
     */
    public Integer getFloorCoveringId() {
        return floorCoveringId;
    }

    /**
     *
     * @param floorCoveringId
     * The floorCoveringId
     */
    public void setFloorCoveringId(Integer floorCoveringId) {
        this.floorCoveringId = floorCoveringId;
    }

    /**
     *
     * @return
     * The proofOwnershipId
     */
    public Integer getProofOwnershipId() {
        return proofOwnershipId;
    }

    /**
     *
     * @param proofOwnershipId
     * The proofOwnershipId
     */
    public void setProofOwnershipId(Integer proofOwnershipId) {
        this.proofOwnershipId = proofOwnershipId;
    }

    /**
     *
     * @return
     * The livingStateId
     */
    public Integer getLivingStateId() {
        return livingStateId;
    }

    /**
     *
     * @param livingStateId
     * The livingStateId
     */
    public void setLivingStateId(Integer livingStateId) {
        this.livingStateId = livingStateId;
    }

    /**
     *
     * @return
     * The numberOfFloors
     */
    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     *
     * @param numberOfFloors
     * The numberOfFloors
     */
    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    /**
     *
     * @return
     * The numberUnitOnFloor
     */
    public Integer getNumberUnitOnFloor() {
        return numberUnitOnFloor;
    }

    /**
     *
     * @param numberUnitOnFloor
     * The numberUnitOnFloor
     */
    public void setNumberUnitOnFloor(Integer numberUnitOnFloor) {
        this.numberUnitOnFloor = numberUnitOnFloor;
    }

    /**
     *
     * @return
     * The toulBar
     */
    public Integer getToulBar() {
        return toulBar;
    }

    /**
     *
     * @param toulBar
     * The toulBar
     */
    public void setToulBar(Integer toulBar) {
        this.toulBar = toulBar;
    }

    /**
     *
     * @return
     * The arzeGozar
     */
    public Integer getArzeGozar() {
        return arzeGozar;
    }

    /**
     *
     * @param arzeGozar
     * The arzeGozar
     */
    public void setArzeGozar(Integer arzeGozar) {
        this.arzeGozar = arzeGozar;
    }

    /**
     *
     * @return
     * The eslahi
     */
    public Integer getEslahi() {
        return eslahi;
    }

    /**
     *
     * @param eslahi
     * The eslahi
     */
    public void setEslahi(Integer eslahi) {
        this.eslahi = eslahi;
    }

    /**
     *
     * @return
     * The ownerPercent
     */
    public Integer getOwnerPercent() {
        return ownerPercent;
    }

    /**
     *
     * @param ownerPercent
     * The ownerPercent
     */
    public void setOwnerPercent(Integer ownerPercent) {
        this.ownerPercent = ownerPercent;
    }

    /**
     *
     * @return
     * The foundation
     */
    public Integer getFoundation() {
        return foundation;
    }

    /**
     *
     * @param foundation
     * The foundation
     */
    public void setFoundation(Integer foundation) {
        this.foundation = foundation;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The isPenthouse
     */
    public Boolean getIsPenthouse() {
        return isPenthouse;
    }

    /**
     *
     * @param isPenthouse
     * The isPenthouse
     */
    public void setIsPenthouse(Boolean isPenthouse) {
        this.isPenthouse = isPenthouse;
    }

    /**
     *
     * @return
     * The isOffice
     */
    public Boolean getIsOffice() {
        return isOffice;
    }

    /**
     *
     * @param isOffice
     * The isOffice
     */
    public void setIsOffice(Boolean isOffice) {
        this.isOffice = isOffice;
    }

    /**
     *
     * @return
     * The dastor
     */
    public Boolean getDastor() {
        return dastor;
    }

    /**
     *
     * @param dastor
     * The dastor
     */
    public void setDastor(Boolean dastor) {
        this.dastor = dastor;
    }

    /**
     *
     * @return
     * The collaborative
     */
    public Boolean getCollaborative() {
        return collaborative;
    }

    /**
     *
     * @param collaborative
     * The collaborative
     */
    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    /**
     *
     * @return
     * The registerDate
     */
    public Integer getRegisterDate() {
        return registerDate;
    }

    /**
     *
     * @param registerDate
     * The registerDate
     */
    public void setRegisterDate(Integer registerDate) {
        this.registerDate = registerDate;
    }

    /**
     *
     * @return
     * The geoLatitude
     */
    public Double getGeoLatitude() {
        return geoLatitude;
    }

    /**
     *
     * @param geoLatitude
     * The geoLatitude
     */
    public void setGeoLatitude(Double geoLatitude) {
        this.geoLatitude = geoLatitude;
    }

    /**
     *
     * @return
     * The geoLongitude
     */
    public Double getGeoLongitude() {
        return geoLongitude;
    }

    /**
     *
     * @param geoLongitude
     * The geoLongitude
     */
    public void setGeoLongitude(Double geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    /**
     *
     * @return
     * The address
     */
    public Address getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The room
     */
    public Integer getRoom() {
        return room;
    }

    /**
     *
     * @param room
     * The room
     */
    public void setRoom(Integer room) {
        this.room = room;
    }

    /**
     *
     * @return
     * The floor
     */
    public Floor getFloor() {
        return floor;
    }

    /**
     *
     * @param floor
     * The floor
     */
    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    /**
     *
     * @return
     * The hasNumberFloor
     */
    public HasNumberFloor getHasNumberFloor() {
        return hasNumberFloor;
    }

    /**
     *
     * @param hasNumberFloor
     * The hasNumberFloor
     */
    public void setHasNumberFloor(HasNumberFloor hasNumberFloor) {
        this.hasNumberFloor = hasNumberFloor;
    }

    /**
     *
     * @return
     * The houseType
     */
    public HouseType getHouseType() {
        return houseType;
    }

    /**
     *
     * @param houseType
     * The houseType
     */
    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

}