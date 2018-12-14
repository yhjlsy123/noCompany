package hotel.xy.com.hotel;

import android.app.Application;


import java.util.concurrent.TimeUnit;

import hotel.xy.com.hotel.utils.http.CookieJarImpl;
import hotel.xy.com.hotel.utils.http.OkHttpUtils;
import hotel.xy.com.hotel.utils.http.PersistentCookieStore;
import okhttp3.OkHttpClient;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS) //链接超时
                .readTimeout(10000L, TimeUnit.MILLISECONDS) //读取超时
                .cookieJar(new CookieJarImpl(new PersistentCookieStore(getApplicationContext())))
                .build(); //其他配置

        OkHttpUtils.initClient(okHttpClient);
    }

}
