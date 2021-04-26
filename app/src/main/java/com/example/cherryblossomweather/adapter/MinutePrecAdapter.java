package com.example.cherryblossomweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.cherryblossomweather.R;
import com.example.cherryblossomweather.bean.MinutePrecResponse;
import com.example.cherryblossomweather.utils.DateUtils;
import com.example.cherryblossomweather.utils.WeatherUtil;

import java.util.List;

/**
 * 分钟级降水列表适配器
 * @author
 */
public class MinutePrecAdapter extends BaseQuickAdapter<MinutePrecResponse.MinutelyBean, BaseViewHolder> {

    public MinutePrecAdapter(int layoutResId, @Nullable List<MinutePrecResponse.MinutelyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MinutePrecResponse.MinutelyBean item) {
        String time = DateUtils.updateTime(item.getFxTime());
        //时间
        helper.setText(R.id.tv_time, WeatherUtil.showTimeInfo(time) + time);
        String type = null;
        if("rain".equals(item.getType())){
            type = "雨";
        }else if("snow".equals(item.getType())){
            type = "雪";
        }
        helper.setText(R.id.tv_precip_info,item.getPrecip()+"   "+type);
    }
}
