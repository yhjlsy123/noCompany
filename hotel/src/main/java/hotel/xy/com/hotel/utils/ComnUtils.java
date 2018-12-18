package hotel.xy.com.hotel.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * 软件安装操作
 */
public class ComnUtils {

    @TargetApi(Build.VERSION_CODES.O)
    public static void openFile(File file, Activity at) {
        File apkFile = file;
        //判读版本是否在8.0以上
        if (Build.VERSION.SDK_INT >= 26) {
            //来判断应用是否有权限安装apk
            boolean installAllowed = at.getPackageManager().canRequestPackageInstalls();
            if (installAllowed) {
                install(apkFile, at);
            }
        } else {
            install(apkFile, at);
        }
    }

    private static void install(File file, Activity at) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= 24) {
            //provider authorities
            Uri apkUri = FileProvider.getUriForFile(at, "hotel.xy.com.hotel.fileprovider", file);
            //Granting Temporary Permissions to a URI
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        at.startActivity(intent);
    }
}
