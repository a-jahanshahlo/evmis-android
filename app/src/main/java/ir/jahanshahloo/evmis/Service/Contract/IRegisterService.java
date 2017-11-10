package ir.jahanshahloo.evmis.Service.Contract;

import android.support.annotation.RawRes;

import java.util.List;

import ir.jahanshahloo.evmis.model.AccessTokenModel;
import ir.jahanshahloo.evmis.model.GetRegisterModel;
import ir.jahanshahloo.evmis.model.HouseModel;
import ir.jahanshahloo.evmis.model.RefreshTokenRequestModel;
import ir.jahanshahloo.evmis.model.RegisterModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Alireza on 6/30/2016.
 */
public interface IRegisterService {
    //first user must send own number
    @POST("api/v1/RegisterByMobile/PostSendPhoneNumber")
    @Headers({
            "Content-Type: application/json"
    })

    Call<GetRegisterModel> sendPhoneNumber(@Body RegisterModel registerModel);

    //second user must send number to validate
    @FormUrlEncoded
    @Headers({
            "Accept: application/json"
    })
    @POST("api/v1/login")
    Call<AccessTokenModel> sendLogin(@Field("grant_type") String grantType,
                                     @Field("mobileNumber") String mobileNumber);

    @FormUrlEncoded
    @Headers({
            "Accept: application/json"
    })
    Call<AccessTokenModel> sendRefreshToken(@Field("grant_type") String grantType,
                                            @Field("refresh_token") String refreshToken);

}

