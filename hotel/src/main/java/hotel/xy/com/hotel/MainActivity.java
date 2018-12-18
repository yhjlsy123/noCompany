package hotel.xy.com.hotel;

import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import hotel.xy.com.hotel.at.BaseActivity;
import hotel.xy.com.hotel.bean.Test;
import hotel.xy.com.hotel.utils.ToastUtils;
import hotel.xy.com.hotel.utils.calander.CalendarUtil;
import hotel.xy.com.hotel.utils.calander.DateInfo;
import hotel.xy.com.hotel.utils.calander.DatePopupWindow;
import hotel.xy.com.hotel.utils.http.OkHttpUtils;
import hotel.xy.com.hotel.view.TitleView;
import okhttp3.Call;

public class MainActivity extends BaseActivity {
    @BindView(R.id.title_main)
    TitleView titleMain;
    private String mServiceDate = "2018-04-03";
    private int startGroup = -1;
    private int endGroup = -1;
    private int startchild = -1;
    private int endchild = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Map<String, Object> pram = new HashMap<>();
        OkHttpUtils.post().url("http://api.map.baidu.com/telematics/v3/weather?location=%E5%98%89%E5%85%B4&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ").tag("dddd").restult(Test.class).params(pram).build().execute(this);
        DatePopupWindow popupWindow = new DatePopupWindow(MainActivity.this, mServiceDate);
        //根据4个参数初始化
        if (startchild != -1 && startGroup != -1 && endGroup != -1 && endchild != -1) {
            popupWindow.setInit(startGroup, startchild, endGroup, endchild);
        } else {
            //设置根据mServiceDate设定今天和明天日期
            popupWindow.setDefaultSelect();
        }
        popupWindow.setDateOnClickListener(new DatePopupWindow.DateOnClickListener() {
            @Override
            public void getDate(List<DateInfo> list, int startGroupPosition, int startChildPosition, int endGroupPosition, int endChildPosition) {
                startGroup = startGroupPosition;
                startchild = startChildPosition;
                endGroup = endGroupPosition;
                endchild = endChildPosition;
                String mStartTime = CalendarUtil.FormatDate(list.get(startGroupPosition).getList().get(startChildPosition).getDate());

                String mEndTime = CalendarUtil.FormatDate(list.get(endGroupPosition).getList().get(endChildPosition).getDate());

            }
        });
//        popupWindow.create(view);


    }


    @Override
    public void onSuccess(Object response, int id, String tag) {
        ToastUtils.show(tag + "成功");
    }

}
