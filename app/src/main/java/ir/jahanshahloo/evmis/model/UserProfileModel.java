package ir.jahanshahloo.evmis.model;

import com.google.gson.annotations.SerializedName;

public class UserProfileModel {
    public String id;
    public String email;
    public String name;
    @SerializedName("image")
    public String imageUrl;
}
