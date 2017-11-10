package ir.jahanshahloo.evmis.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
//this model should be same data strcuture return from login server
public class AccessTokenModel {

    public String access_token;
    public String token_type;
    public Long expires_in;
    public String refresh_token;



}

