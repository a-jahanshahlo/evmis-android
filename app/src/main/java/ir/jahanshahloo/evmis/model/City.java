package ir.jahanshahloo.evmis.model;

/**
 * Created by Ali on 8/8/2016.
 */


import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class City {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("province")
    @Expose
    private Province province;

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
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The province
     */
    public Province getProvince() {
        return province;
    }

    /**
     *
     * @param province
     * The province
     */
    public void setProvince(Province province) {
        this.province = province;
    }
    public String toString() {
        return title;
    }
}

