package com.example.cherryblossomweather.contract;

import com.example.cherryblossomweather.api.ApiService;
import com.example.cherryblossomweather.bean.AirNowResponse;
import com.example.cherryblossomweather.bean.DailyResponse;
import com.example.cherryblossomweather.bean.EpidemicDataResponse;
import com.example.cherryblossomweather.bean.HourlyResponse;
import com.example.cherryblossomweather.bean.LifestyleResponse;
import com.example.cherryblossomweather.bean.MinutePrecResponse;
import com.example.cherryblossomweather.bean.NewSearchCityResponse;
import com.example.cherryblossomweather.bean.NowResponse;
import com.example.cherryblossomweather.bean.WarningResponse;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.base.BaseView;
import com.example.mvplibrary.net.NetCallBack;
import com.example.mvplibrary.net.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Response;

/**
 * 天气订阅器
 *
 * @author example
 */
public class WeatherContract {

    public static class WeatherPresenter extends BasePresenter<IWeatherView> {


        /*

         */
/**
 * 当日天气
 * @param context
 * @param location  区/县
 *//*

        public void todayWeather(final Context context, String location) {
            //得到构建之后的网络请求服务，这里的地址已经拼接完成，只差一个location了
            ApiService service = ServiceGenerator.createService(ApiService.class);
            //设置请求回调  NetCallBack是重写请求回调
            service.getTodayWeather(location).enqueue(new NetCallBack<TodayResponse>() {
                //成功回调
                @Override
                public void onSuccess(Call<TodayResponse> call, Response<TodayResponse> response) {
                    if (getView() != null) {//当视图不会空时返回请求数据
                        getView().getTodayWeatherResult(response);
                    }
                }

                //失败回调
                @Override
                public void onFailed() {
                    if (getView() != null) {//当视图不会空时获取错误信息
                        getView().getDataFailed();
                    }
                }
            });
        }

*/

        /**
         * 天气预报  3-7天(白嫖的就只能看到3天)
         * @param context
         * @param location
         */
        /*public void weatherForecast(final Context context,String location){
            ApiService service = ServiceGenerator.createService(ApiService.class);
            service.getWeatherForecast(location).enqueue(new NetCallBack<WeatherForecastResponse>() {
                @Override
                public void onSuccess(Call<WeatherForecastResponse> call, Response<WeatherForecastResponse> response) {
                    if(getView() != null){
                        getView().getWeatherForecastResult(response);
                    }
                }

                @Override
                public void onFailed() {
                    if(getView() != null){
                        getView().getDataFailed();
                    }
                }
            });
        }
    }*/


        /***************** 以下为使用V7版本而新增的接口方法，后期将都会使用这些方法，请注意 ****************/

        /**
         * 搜索城市  V7版本中  需要把定位城市的id查询出来，然后通过这个id来查询详细的数据
         *
         * @param location 城市名
         */
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
                        getView().getDataFailed();
                    }
                }
            });
        }


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

        /**
         * 天气预报  V7版本   7d 表示天气的数据 为了和之前看上去差别小一些，这里先用七天的
         *
         * @param location 城市名
         */
        public void dailyWeather(String location) {//这个3 表示使用新的V7API访问地址
            ApiService service = ServiceGenerator.createService(ApiService.class, 3);
            service.dailyWeather("7d", location).enqueue(new NetCallBack<DailyResponse>() {
                @Override
                public void onSuccess(Call<DailyResponse> call, Response<DailyResponse> response) {
                    if (getView() != null) {
                        getView().getDailyResult(response);
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

        /**
         * 逐小时预报（未来24小时）
         *
         * @param location 城市名
         */
        public void hourlyWeather(String location) {
            ApiService service = ServiceGenerator.createService(ApiService.class, 3);
            service.hourlyWeather(location).enqueue(new NetCallBack<HourlyResponse>() {
                @Override
                public void onSuccess(Call<HourlyResponse> call, Response<HourlyResponse> response) {
                    if (getView() != null) {
                        getView().getHourlyResult(response);
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

        /**
         * 当天空气质量
         *
         * @param location 城市名
         */
        public void airNowWeather(String location) {
            ApiService service = ServiceGenerator.createService(ApiService.class, 3);
            service.airNowWeather(location).enqueue(new NetCallBack<AirNowResponse>() {
                @Override
                public void onSuccess(Call<AirNowResponse> call, Response<AirNowResponse> response) {
                    if (getView() != null) {
                        getView().getAirNowResult(response);
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

        /**
         * 生活指数
         *
         * @param location 城市名  type中的"1,2,3,5,6,8,9,10"，表示只获取这8种类型的指数信息，同样是为了对应之前的界面UI
         */
        public void lifestyle(String location) {
            ApiService service = ServiceGenerator.createService(ApiService.class, 3);
            service.lifestyle("1,2,3,5,6,8,9,10", location).enqueue(new NetCallBack<LifestyleResponse>() {
                @Override
                public void onSuccess(Call<LifestyleResponse> call, Response<LifestyleResponse> response) {
                    if (getView() != null) {
                        getView().getLifestyleResult(response);
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

        /**
         * 城市灾害预警
         *
         * @param location 城市id
         */
        public void nowWarn(String location) {
            ApiService service = ServiceGenerator.createService(ApiService.class, 3);
            service.nowWarn(location).enqueue(new NetCallBack<WarningResponse>() {
                @Override
                public void onSuccess(Call<WarningResponse> call, Response<WarningResponse> response) {
                    if (getView() != null) {
                        getView().getNowWarnResult(response);
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

        /**
         * 分钟级降水
         *
         * @param location 经纬度拼接字符串，使用英文逗号分隔,经度在前纬度在后
         */
        public void getMinutePrec(String location) {
            ApiService service = ServiceGenerator.createService(ApiService.class, 3);
            service.getMinutePrec(location).enqueue(new NetCallBack<MinutePrecResponse>() {
                @Override
                public void onSuccess(Call<MinutePrecResponse> call, Response<MinutePrecResponse> response) {
                    if (getView() != null) {
                        getView().getMinutePrecResult(response);
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
        /**
         * 获取
         */
        public void epidemic(String location) {
            ApiService service = ServiceGenerator.createService(ApiService.class, 7);
            service.epidemicData(location).enqueue(new NetCallBack<EpidemicDataResponse>() {
                @Override
                public void onSuccess(Call<EpidemicDataResponse> call, Response<EpidemicDataResponse> response) {
                    if (getView() != null) {
                        getView().getEpidemicResult(response);
                    }
                }

                @Override
                public void onFailed() {
                    if (getView() != null) {
                        getView().getDataFailed();
                    }
                }
            });
        }

    }

    public interface IWeatherView extends BaseView {

        //查询当天天气的数据返回
        //void getTodayWeatherResult(Response<TodayResponse> response);
        //查询天气预报的数据返回
        //void getWeatherForecastResult(Response<WeatherForecastResponse> response);


        //天气数据获取错误返回
        void getWeatherDataFailed();


        /*                以下为V7版本新增               */

        //搜索城市返回城市id  通过id才能查下面的数据,否则会提示400  V7
        void getNewSearchCityResult(Response<NewSearchCityResponse> response);

        //实况天气
        void getNowResult(Response<NowResponse> response);

        //天气预报  7天
        void getDailyResult(Response<DailyResponse> response);

        //逐小时天气预报
        void getHourlyResult(Response<HourlyResponse> response);

        //空气质量
        void getAirNowResult(Response<AirNowResponse> response);

        //生活指数
        void getLifestyleResult(Response<LifestyleResponse> response);

        //灾害预警
        void getNowWarnResult(Response<WarningResponse> response);

        //分钟级降水
        void getMinutePrecResult(Response<MinutePrecResponse> response);

        void  getEpidemicResult(Response<EpidemicDataResponse> response);
        //错误返回
        void getDataFailed();


    }
}

