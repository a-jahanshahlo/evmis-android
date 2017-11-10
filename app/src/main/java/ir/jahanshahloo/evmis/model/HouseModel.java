package ir.jahanshahloo.evmis.model;

/**
 * Created by Adminstrator on 7/11/2016.
 */
public class HouseModel {

    private Integer id;
    private String houseTypeTitle;
    private String addressTitle;
    private String floorTitle;
    private String provinceTitle;
    private String cityTitle;
    private Integer countLike;

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
     * The houseTypeTitle
     */
    public String getHouseTypeTitle() {
        return houseTypeTitle;
    }

    /**
     *
     * @param houseTypeTitle
     * The houseTypeTitle
     */
    public void setHouseTypeTitle(String houseTypeTitle) {
        this.houseTypeTitle = houseTypeTitle;
    }

    /**
     *
     * @return
     * The addressTitle
     */
    public String getAddressTitle() {
        return addressTitle;
    }

    /**
     *
     * @param addressTitle
     * The addressTitle
     */
    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    /**
     *
     * @return
     * The floorTitle
     */
    public String getFloorTitle() {
        return floorTitle;
    }

    /**
     *
     * @param floorTitle
     * The floorTitle
     */
    public void setFloorTitle(String floorTitle) {
        this.floorTitle = floorTitle;
    }

    /**
     *
     * @return
     * The provinceTitle
     */
    public String getProvinceTitle() {
        return provinceTitle;
    }

    /**
     *
     * @param provinceTitle
     * The provinceTitle
     */
    public void setProvinceTitle(String provinceTitle) {
        this.provinceTitle = provinceTitle;
    }

    /**
     *
     * @return
     * The cityTitle
     */
    public String getCityTitle() {
        return cityTitle;
    }

    /**
     *
     * @param cityTitle
     * The cityTitle
     */
    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    /**
     *
     * @return
     * The countLike
     */
    public Integer getCountLike() {
        return countLike;
    }

    /**
     *
     * @param countLike
     * The countLike
     */
    public void setCountLike(Integer countLike) {
        this.countLike = countLike;
    }
}
