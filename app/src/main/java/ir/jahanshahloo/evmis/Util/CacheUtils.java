package ir.jahanshahloo.evmis.Util;

import android.content.Context;
import android.os.StatFs;

import java.io.File;

/**
 * Created by Ali on 7/30/2016.
 */
public class CacheUtils {
    public static File createDefaultCacheDir(Context context) {
        File cache = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!cache.exists()) {
            //noinspection ResultOfMethodCallIgnored
            cache.mkdirs();
        }
        return cache;
    }

    public static long calculateDiskCacheSize(File dir) {
        long size = 5 * 1024 * 1024;
        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            long available = ((long) statFs.getBlockCount()) * statFs.getBlockSize();
            // Target 2% of the total space.
            size = available / 50;
        } catch (IllegalArgumentException ignored) {
        }
        // Bound inside min/max size for disk cache.
        return Math.max(Math.min(size, 50 * 1024 * 1024), 5 * 1024 * 1024);
    }
}
