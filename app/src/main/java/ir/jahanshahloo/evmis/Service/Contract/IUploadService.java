package ir.jahanshahloo.evmis.Service.Contract;

import java.util.List;

import ir.jahanshahloo.evmis.model.HouseModel;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface IUploadService {
    @Multipart
    @POST("api/v1/Profile/UploadProfile")

/*    @Headers({
            "Content-Type: multipart/form-data"
    })*/
    Call<ResponseBody> postProfileImage(@Part MultipartBody.Part file);

    @Multipart
    @POST("api/v1/Profile/UploadProfile")
    Call<ResponseBody> postNewGallery(@Part MultipartBody.Part file,@Part String galleryId);

    @Multipart
    @POST("api/v1/Photo/UploadPhoto")
    Call<ResponseBody> postNewPhoto(@Part MultipartBody.Part file,@Part String galleryId);
}
