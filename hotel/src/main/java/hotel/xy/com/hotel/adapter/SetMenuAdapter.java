package hotel.xy.com.hotel.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import hotel.xy.com.hotel.R;
import hotel.xy.com.hotel.bean.SetMenu;

public class SetMenuAdapter extends BaseQuickAdapter<SetMenu, BaseViewHolder> {
    public SetMenuAdapter(int layoutResId, @Nullable List<SetMenu> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SetMenu item) {
        helper.setText(R.id.content, item.getTxt());
        helper.setImageResource(R.id.img, item.getImg());
        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.content);
    }

}
