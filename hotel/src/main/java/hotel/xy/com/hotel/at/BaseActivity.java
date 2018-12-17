package hotel.xy.com.hotel.at;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import hotel.xy.com.hotel.R;
import hotel.xy.com.hotel.utils.StatusBarUtil;
import hotel.xy.com.hotel.utils.http.OnRequest;
import okhttp3.Call;

public class BaseActivity extends AppCompatActivity implements OnRequest {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
    }

    @Override
    public void onSuccess(Object response, int id, String tag) {


    }

    @Override
    public void onFail(Call call, Exception e, int id) {
        Toast.makeText(this, "失败", Toast.LENGTH_LONG).show();
    }

    @Override
    public void inProgress(float progress, long total, int id) {

    }
}
