package ir.jahanshahloo.evmis.Service.Contract;

import java.util.List;

import ir.jahanshahloo.evmis.model.GetRegisterModel;
import ir.jahanshahloo.evmis.model.HouseForRent;
import ir.jahanshahloo.evmis.model.HouseModel;
import ir.jahanshahloo.evmis.model.NewHouseForRent;
import ir.jahanshahloo.evmis.model.RegisterModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IHouseForRentService {

    @GET("api/v1/Rent/GetList")
    Call<List<HouseForRent>> getRent(@Query("skip") int skip, @Query("take") int take);

    @GET("api/v1/Rent/GetList")
    Call<List<HouseForRent>> getSearchRent(@Query("skip") int skip, @Query("take") int take);
    @POST("api/v1/Rent/PostNewRent")
    @Headers({
            "Content-Type: application/json"
    })

    Call<ResponseBody> sendHouseForRent(@Body NewHouseForRent model);

}
