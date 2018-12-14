package hotel.xy.com.hotel;

import android.os.Bundle;
import android.widget.Toast;


import java.util.HashMap;
import java.util.Map;

import hotel.xy.com.hotel.at.BaseActivity;
import hotel.xy.com.hotel.bean.Test;
import hotel.xy.com.hotel.utils.http.OkHttpUtils;
import hotel.xy.com.hotel.utils.http.OnRequest;
import okhttp3.Call;

public class MainActivity extends BaseActivity implements OnRequest {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, Object> pram = new HashMap<>();
        OkHttpUtils.post().url("http://api.map.baidu.com/telematics/v3/weather?location=%E5%98%89%E5%85%B4&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ").tag("dddd").params(pram).build().execute(this, Test.class);
    }


    @Override
    public void onSuccess(Object response, int id, String tag) {
        Toast.makeText(this, "成功", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFail(Call call, Exception e, int id) {

    }

    @Override
    public void inProgress(float progress, long total, int id) {

    }
}
