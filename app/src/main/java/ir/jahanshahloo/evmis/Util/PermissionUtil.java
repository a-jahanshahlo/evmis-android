package ir.jahanshahloo.evmis.Util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 8/11/2016.
 */
public class PermissionUtil {
    public boolean checkPermission(Activity activity , String[] permissions){

        List<String> permissionNeededList=new ArrayList<>();
        for (String p:permissions){
            int permission = ContextCompat.checkSelfPermission(activity .getBaseContext(), p);
            if (permission!= PackageManager.PERMISSION_GRANTED){
                permissionNeededList.add(p);
            }
        }
        if (!permissionNeededList.isEmpty()){
            ActivityCompat.requestPermissions(activity,permissionNeededList.toArray(new String[permissionNeededList.size()]),10);
            return false;
        }

        return true;
    }
}
