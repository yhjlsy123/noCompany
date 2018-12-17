package hotel.xy.com.hotel.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;


/**
 * 单例的吐司
 * Created by and on 2016/11/3.
 */

public class ToastUtils {
    private static Toast mToast = null;
    public static Context context;

    private ToastUtils() {
    }

    /**
     * 弹出单例的吐司
     *
     * @param text
     */
    public static void show(String text) {
        if (mToast == null)
            synchronized (ToastUtils.class) {
                if (mToast == null && null != context)
                    mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
            }
        if (TextUtils.isEmpty(text)) {
            mToast.cancel();
            return;
        }
        mToast.setText(text);
        mToast.show();
    }
}
