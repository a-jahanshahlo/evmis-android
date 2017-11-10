package ir.jahanshahloo.evmis.Service.Contract;

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
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IHouseService {

    @GET("api/v1/House")
    Call<List<HouseModel>> getHouse(@Query("skip") int skip, @Query("take") int take);
}
