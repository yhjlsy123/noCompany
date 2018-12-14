package hotel.xy.com.hotel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import hotel.xy.com.hotel.R;

public class MyTitle extends View {
    public MyTitle(Context context) {
        super(context);
    }

    public MyTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.title_view, null);

    }
}
