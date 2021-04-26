package com.example.cherryblossomweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.cherryblossomweather.R;
import com.example.cherryblossomweather.bean.CityResponse;

import java.util.List;

/**
 * 省列表适配器
 *
 * @author
 */
public class ProvinceAdapter extends BaseQuickAdapter<CityResponse, BaseViewHolder> {
    public ProvinceAdapter(int layoutResId, @Nullable List<CityResponse> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CityResponse item) {
        //省名称
        helper.setText(R.id.tv_city, item.getName());
        //点击之后进入市级列表
        helper.addOnClickListener(R.id.item_city);
    }
}
