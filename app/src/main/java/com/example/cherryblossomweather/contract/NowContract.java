package com.example.cherryblossomweather.contract;

import com.example.cherryblossomweather.api.ApiService;
import com.example.cherryblossomweather.bean.NewSearchCityResponse;
import com.example.cherryblossomweather.bean.NowResponse;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.base.BaseView;
import com.example.mvplibrary.net.NetCallBack;
import com.example.mvplibrary.net.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Response;

public class NowContract {
    public static class NowPresenter extends BasePresenter<IWeatherView> {


        /**
         * 实况天气  V7版本
         *
         * @param location 城市名
         */
        public void nowWeather(String location) {//这个3 表示使用新的V7API访问地址
            ApiService service = ServiceGenerator.createService(ApiService.class, 3);
            service.nowWeather(location).enqueue(new NetCallBack<NowResponse>() {
                @Override
                public void onSuccess(Call<NowResponse> call, Response<NowResponse> response) {
                    if (getView() != null) {
                        getView().getNowResult(response);
                    }
                }

                @Override
                public void onFailed() {
                    if (getView() != null) {
                        getView().getWeatherDataFailed();
                    }
                }
            });
        }
        public void newSearchCity(String location) {//注意这里的4表示新的搜索城市地址接口
            ApiService service = ServiceGenerator.createService(ApiService.class, 4);//指明访问的地址
            service.newSearchCity(location, "exact").enqueue(new NetCallBack<NewSearchCityResponse>() {
                @Override
                public void onSuccess(Call<NewSearchCityResponse> call, Response<NewSearchCityResponse> response) {
                    if (getView() != null) {
                        getView().getNewSearchCityResult(response);
                    }
                }

                @Override
                public void onFailed() {
                    if (getView() != null) {
                        getView().getWeatherDataFailed();
                    }
                }
            });
        }
    }

    public interface IWeatherView extends BaseView {
        //天气数据获取错误返回
        void getWeatherDataFailed();

        void getNewSearchCityResult(Response<NewSearchCityResponse> response);

        //实况天气
        void getNowResult(Response<NowResponse> response);
    }
}
