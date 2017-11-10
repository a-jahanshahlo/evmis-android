package ir.jahanshahloo.evmis.Service.Provider;

import android.app.Application;
import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;

import ir.jahanshahloo.evmis.Service.Contract.IRegisterService;
import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.config.ClientConfigs;
import ir.jahanshahloo.evmis.localdata.AppPreference;
import ir.jahanshahloo.evmis.model.AccessTokenModel;
import ir.jahanshahloo.evmis.model.RefreshTokenRequestModel;
import okhttp3.Authenticator;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by Ali on 7/28/2016.
 */
public class RefreshTokenAuthenticator implements Authenticator {

    AppPreference appPreference;

    public RefreshTokenAuthenticator(Application application,AppPreference appPreference) {

       this. appPreference=    appPreference;

    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        if (!appPreference.isTokenValid()) {
            Log.i("ali","Token is Expire");
            //make the refresh token request model
            RefreshTokenRequestModel requestModel = new RefreshTokenRequestModel();
            requestModel.refresh_token = appPreference.getRefreshToken();

            RequestBody formBody = new FormBody.Builder()
                    .add("grant_type", requestModel.grant_type)
                    .add("refresh_token", requestModel.refresh_token)
                    .build();
            //make call
            Request newRequest = response.request().newBuilder()
                    .url(ClientConfigs.REST_API_BASE_URL+"api/v1/login")
                    .post(formBody)
                    .build();

            OkHttpClient client = new OkHttpClient();

            okhttp3.Call call = client.newCall(newRequest);//iRegisterService.sendRefreshToken(requestModel.grant_type, requestModel.refresh_token);
            Response execute = call.execute();

            if ( execute.isSuccessful()) {
                Log.i("ali","Change Token success");

                //  appPreference.saveTokenModel(tokenModelResponse.body());
                return response.request().newBuilder()
                        .removeHeader("Authorization")
                        .addHeader("Authorization", "bearer " + appPreference.getAccessToken())
                        .build();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}