package ir.jahanshahloo.evmis.Util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ir.jahanshahloo.evmis.R;
import permissions.dispatcher.PermissionRequest;

/**
 * Created by Alireza on 6/30/2016.
 */
public class AndroidUtility {
    private final static String defaultSimpleDateFormat = "yyyy-MM-dd HH:mm:ss";


    //check the internet is avilable
    public static boolean isConnectToInternet(Context baseContext) {

        ConnectivityManager connectivityManager = (ConnectivityManager) baseContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }

        return false;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();

        return dateFormat.format(date);
    }

    //time should be like this: 2016-12-05 13:02:55
    public static boolean isTokenValid(String expireTokenTime) {
        SimpleDateFormat formatter = new SimpleDateFormat(defaultSimpleDateFormat);
        String now = AndroidUtility.getdefaultSimpleDateFormat().format(new Date());
        Log.i("ali", "Current time:" + now);
        Log.i("ali", "Expire time:" + expireTokenTime);

        try {
            Date expireTime = formatter.parse(expireTokenTime);
            Date currentTime = formatter.parse(now);

            if (expireTime.compareTo(currentTime) < 0) {
                Log.i("ali", "currentTime is Greater than my expireTime");
                return false;
            }
            Log.i("ali", "expireTime is Greater than my currentTime");

            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static SimpleDateFormat getdefaultSimpleDateFormat() {
        return new SimpleDateFormat(defaultSimpleDateFormat);
    }

    public static String getExpireTokenTime(Long TimeInSecond) {
        //1000 milisecond = 1 second
        // 60 second = 1 min

        //convert time from min to MilliSecond
        long TimeInMilliSecond = (TimeInSecond  * 1000);
        Date d = new Date();
        long l = d.getTime() + TimeInMilliSecond;
        String dateString = new SimpleDateFormat(defaultSimpleDateFormat).format(new Date(l));
        return dateString;
    }
    public static int convertDpToPixels(float dp, Context context){
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics()
        );
    }

    public static void setHeight(final GridView gridView, int heightDp){
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        layoutParams.height = heightDp; //this is in pixels
        gridView.setLayoutParams(layoutParams);
    }
    public static void refreshGridViewHeight(final GridView gridView, int itemHeight){
        ListAdapter adapter = gridView.getAdapter();
        if (adapter!=null){
            int height;
            int numColumns = gridView.getNumColumns();
            int count = adapter.getCount();

            if ( count > numColumns){
                int extra=count % numColumns;
                if (extra>0){
                   int h  = (count -extra) * itemHeight;
                    height=h/numColumns;
                    height +=itemHeight;
                }else{
                    int h = count  * itemHeight;
                    height=h/numColumns;
                }

            }else {
                height=itemHeight;
            }
            int heightPx =  convertDpToPixels(Float.parseFloat(String.valueOf(height)), gridView.getContext());
            setHeight(gridView, heightPx);
            // int realHeight = heightInOneRow % numColumns;

        }

    }

    public static void showRationaleDialog(@StringRes int messageResId, final PermissionRequest request, Context context) {
        new AlertDialog.Builder(context)
                .setPositiveButton(R.string.button_allow, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton(R.string.button_deny, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage(messageResId)
                .show();
    }

}
