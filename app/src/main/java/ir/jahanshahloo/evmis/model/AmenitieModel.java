package ir.jahanshahloo.evmis.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ali on 10/29/16.
 */
public class AmenitieModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("titleFa")
    @Expose
    private String titleFa;


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
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitleFa() {
        return titleFa;
    }
    public void setTitleFa(String title) {
        this.titleFa = title;
    }

    public String toString() {
        return titleFa;
    }
}
