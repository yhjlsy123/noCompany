package hotel.xy.com.hotel.at;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hotel.xy.com.hotel.R;
import hotel.xy.com.hotel.utils.StatusBarUtil;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, R.color.colorPrimary, 0);
    }
}
