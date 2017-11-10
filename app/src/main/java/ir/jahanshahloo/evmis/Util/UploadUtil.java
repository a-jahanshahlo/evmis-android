package ir.jahanshahloo.evmis.Util;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

import ir.jahanshahloo.evmis.Service.Contract.IUploadService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class UploadUtil {
    public Call<ResponseBody> UploadProfilePhoto(final Context context, Uri uri, IUploadService iUploadService) {
        final String profilePhotoUrl = "";

        // use the FileUtils to get the actual file by uri
        File file =new File("");// FileUtils.getFile(context, uri);
        if (file == null) {
            Log.i("ali", "Profile image is null");
        }
        // create RequestBody instance from file
       // RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        RequestBody fbody = RequestBody.create(MediaType.parse("image/*"), file);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body = MultipartBody.Part.createFormData("picture", file.getName(), fbody);

        Call<ResponseBody> call = iUploadService.postProfileImage(body);
        return call;

    }

    public Call<ResponseBody> UploadProfilePhoto(final Context context, File file, IUploadService iUploadService) {
        final String profilePhotoUrl = "";


        // create RequestBody instance from file
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);

        Call<ResponseBody> call = iUploadService.postProfileImage(body);
        return call;
    }

}