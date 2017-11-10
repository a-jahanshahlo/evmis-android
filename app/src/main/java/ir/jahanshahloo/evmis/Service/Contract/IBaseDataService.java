package ir.jahanshahloo.evmis.Service.Contract;

import java.util.List;

import ir.jahanshahloo.evmis.model.AmenitieModel;
import ir.jahanshahloo.evmis.model.BaseModel;
import ir.jahanshahloo.evmis.model.Cabinet;
import ir.jahanshahloo.evmis.model.City;
import ir.jahanshahloo.evmis.model.FloorCovering;
import ir.jahanshahloo.evmis.model.HouseGeoView;
import ir.jahanshahloo.evmis.model.HouseModel;
import ir.jahanshahloo.evmis.model.HouseType;
import ir.jahanshahloo.evmis.model.HouseView;
import ir.jahanshahloo.evmis.model.LivingState;
import ir.jahanshahloo.evmis.model.ProofOwnership;
import ir.jahanshahloo.evmis.model.Province;
import ir.jahanshahloo.evmis.model.RentAdvertiseType;
import ir.jahanshahloo.evmis.model.RentType;
import ir.jahanshahloo.evmis.model.TimeUnit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IBaseDataService {

    @GET("api/v1/Province")
    Call<List<BaseModel>> getProvince();


    @GET("api/v1/City/GetByProvince")
    Call<List<BaseModel>> getCity(@Query("province") int province);

    @GET("api/v1/RentType")
    Call<List<BaseModel>> getRentType();

    @GET("api/v1/HouseType")
    Call<List<BaseModel>> getHouseType();

    @GET("api/v1/TimeUnit")
    Call<List<BaseModel>> getTimeUnit();

    @GET("api/v1/ProofOwnership")
    Call<List<BaseModel>> getProofOwnership();

    @GET("api/v1/Cabinet")
    Call<List<BaseModel>> getCabinet();


    @GET("api/v1/FloorCovering")
    Call<List<BaseModel>> getFloorCovering();


    @GET("api/v1/HouseGeoView")
    Call<List<BaseModel>> getHouseGeoView();


    @GET("api/v1/HouseView")
    Call<List<BaseModel>> getHouseView();


    @GET("api/v1/LivingState")
    Call<List<BaseModel>> getLivingState();



    @GET("api/v1/RentAdvertiseType")
    Call<List<BaseModel>> getRentAdvertiseType();

    @GET("api/v1/Floor/Get")
    Call<List<BaseModel>> getFloor();

    @GET("api/v1/Amenitie/Get")
    Call<List<AmenitieModel>> getAmenitie();



}
