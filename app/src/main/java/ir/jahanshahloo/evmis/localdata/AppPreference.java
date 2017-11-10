package ir.jahanshahloo.evmis.localdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.util.AttributeSet;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Util.AndroidUtility;
import ir.jahanshahloo.evmis.model.AccessTokenModel;
import ir.jahanshahloo.evmis.model.AuthenticationResponseModel;
import ir.jahanshahloo.evmis.model.UserProfileModel;

/**
 * Created by Alireza on 6/30/2016.
 */
public class AppPreference  {

    private SharedPreferences mPreference;
    private Context mContext;
    public static final String STRING_PREF_UNAVAILABLE = "string preference unavailable";

    public AppPreference(Context context) {
        this.mContext = context;
        this.mPreference = context.getSharedPreferences("app_preference", Context.MODE_PRIVATE);
    }

    /**
     * save the user authentication model to pref at sing up || sign in
     *
     * @param authModel
     */
    public void saveUserAuthenticationInfo(AuthenticationResponseModel authModel) {
        mPreference.edit()
                .putString(this.mContext.getString(R.string.pref_access_token), authModel.token.access_token )
                .putLong(this.mContext.getString(R.string.pref_expire_in), authModel.token.expires_in)
                .putString(this.mContext.getString(R.string.pref_refresh_token), authModel.token.refresh_token)
                .putString(this.mContext.getString(R.string.pref_token_tpe), authModel.token.token_type)
               // .putString(this.mContext.getString(R.string.pref_app_id), authModel.token.app_id)
               // .putString(this.mContext.getString(R.string.pref_user_id), authModel.user_profile.id)
               // .putString(this.mContext.getString(R.string.pref_user_email), authModel.user_profile.email)
               // .putString(this.mContext.getString(R.string.pref_user_name), authModel.user_profile.name)
               // .putString(this.mContext.getString(R.string.pref_user_image_url), authModel.user_profile.imageUrl)
                .apply();
    }

    /**
     * save the user model when user profile updated
     *
     * @param userModel
     */
    public void saveUserModel(UserProfileModel userModel) {
        mPreference.edit()
                .putString(this.mContext.getString(R.string.pref_user_id), userModel.id)
                .putString(this.mContext.getString(R.string.pref_user_email), userModel.email)
                .putString(this.mContext.getString(R.string.pref_user_name), userModel.name)
                .putString(this.mContext.getString(R.string.pref_user_image_url), userModel.imageUrl)
                .apply();
    }

    /**
     * save token model used in refresh token
     * @param tokenModel
     */
    public void saveTokenModel(AccessTokenModel tokenModel) {
        mPreference.edit()
                .putString(this.mContext.getString(R.string.pref_access_token), tokenModel.access_token )
                .putString(this.mContext.getString(R.string.pref_expire_in),AndroidUtility.getExpireTokenTime( tokenModel.expires_in))
                .putString(this.mContext.getString(R.string.pref_token_tpe), tokenModel.token_type)
                .putString(this.mContext.getString(R.string.pref_refresh_token),  tokenModel.refresh_token )
               // .putString(this.mContext.getString(R.string.pref_app_id), tokenModel.app_id)
                .apply();
    }

    /**
     * get access token
     *
     * @return
     */
    public String getAccessToken() {
        return mPreference.getString(this.mContext.getString(R.string.pref_access_token), STRING_PREF_UNAVAILABLE);
    }

    /**
     * detect is user sign in
     *
     * @return
     */
    public boolean isAuthorized() {
        return !getAccessToken().equals(STRING_PREF_UNAVAILABLE) ;
    }
    /**
     * detect is user sign in
     *
     * @return
     */
    public boolean isTokenValid() {
        return AndroidUtility.isTokenValid(getExpireTime());
    }
public String getExpireTime(){
    return mPreference.getString(this.mContext.getString(R.string.pref_expire_in), STRING_PREF_UNAVAILABLE/*"Default value if not exist"*/);

}
    /**
     * get user name
     *
     * @return
     */
    public String getUserName() {
        return mPreference.getString(this.mContext.getString(R.string.pref_user_name), STRING_PREF_UNAVAILABLE/*"Default value if not exist"*/);
    }

    public String getImageProfileUrl() {
        return mPreference.getString(this.mContext.getString(R.string.pref_user_image_url), STRING_PREF_UNAVAILABLE/*"Default value if not exist"*/);
    }

    public String getUserId() {
        return mPreference.getString(this.mContext.getString(R.string.pref_user_id), STRING_PREF_UNAVAILABLE/*"Default value if not exist"*/);
    }

    /**
     * get refresh token
     *
     * @return
     */
    public String getRefreshToken() {
        return mPreference.getString(this.mContext.getString(R.string.pref_refresh_token), STRING_PREF_UNAVAILABLE/*"Default value if not exist"*/);
    }

    /**
     * remove all prefs in logout
     */
    public void removeAllPrefs() {
        mPreference.edit().clear().apply();
    }
}
