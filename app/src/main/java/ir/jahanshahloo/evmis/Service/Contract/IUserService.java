package ir.jahanshahloo.evmis.Service.Contract;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IUserService {
    @Multipart
    @POST("api/v1/Profile/UploadProfile")
    Call<ResponseBody> postProfileImage(@Part MultipartBody.Part file);
}
