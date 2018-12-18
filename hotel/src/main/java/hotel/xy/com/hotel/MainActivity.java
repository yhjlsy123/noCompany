package hotel.xy.com.hotel;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import hotel.xy.com.hotel.adapter.TitleFragmentPagerAdapter;
import hotel.xy.com.hotel.at.BaseActivity;
import hotel.xy.com.hotel.bean.Test;
import hotel.xy.com.hotel.fg.HomeFragment;
import hotel.xy.com.hotel.fg.SetFragment;
import hotel.xy.com.hotel.utils.ComnUtils;
import hotel.xy.com.hotel.utils.ToastUtils;
import hotel.xy.com.hotel.utils.http.FileCallBack;
import hotel.xy.com.hotel.utils.http.OkHttpUtils;
import okhttp3.Response;

public class MainActivity extends BaseActivity {
    @BindView(R.id.three_viewpager)
    ViewPager threeViewpager;
    @BindView(R.id.three_tablayout)
    TabLayout threeTablayout;
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
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(HomeFragment.newInstance("1", "首页"));
        fragments.add(HomeFragment.newInstance("1", "首页"));
        fragments.add(SetFragment.newInstance("2", "设置"));

        String[] titles = new String[]{"首页", "流量", "社区", "关于"};

        //设置适配器
        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles);
        threeViewpager.setAdapter(adapter);
        //绑定
        threeTablayout.setupWithViewPager(threeViewpager);

        for (int i = 0; i < threeTablayout.getTabCount(); i++) {
            TabLayout.Tab tab = threeTablayout.getTabAt(i);
            Drawable d = null;
            switch (i) {
                case 0:
                    d = getResources().getDrawable(R.drawable.tab_home);
                    break;
                case 1:
                    d = getResources().getDrawable(R.drawable.tab_home);
                    break;
                case 2:
                    d = getResources().getDrawable(R.drawable.tab_home);
                    break;
                case 3:
                    d = getResources().getDrawable(R.drawable.tab_home);
                    break;
            }
            tab.setIcon(d);
        }
        OkHttpUtils.get().url("http://vf2.mtime.cn/Video/2017/03/15/mp4/170315222409670447.mp4").build().execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(),
                "okHttp-test.mp4") {

            @Override
            public File saveFile(Response response, int id) {
                File file = super.saveFile(response, id);
                ComnUtils.openFile(file, MainActivity.this);
                return file;
            }

            @Override
            protected void inProgress(float v, long total, int id) {
                Log.e("lsy", "inProgress" + (int) (100 * v));
            }
        });

    }


    @Override
    public void onSuccess(Object response, int id, String tag) {
        ToastUtils.show(tag + "成功");
    }

}
