package vn.phamthang.day09.interactors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.phamthang.day09.api.ApiUltis;
import vn.phamthang.day09.api.services.IOpenWeatherMapServices;
import vn.phamthang.day09.interfacee.IWeatherPresenter;
import vn.phamthang.day09.objects.WeatherRespone;
import vn.phamthang.day09.utils.Constant;

public class WeatherInteractor {
    private static IWeatherPresenter mIWeatherPresenter;
    private IOpenWeatherMapServices mOpenWeatherMapServices;

    public WeatherInteractor(IWeatherPresenter mIWeatherPresenter) {
        this.mIWeatherPresenter = mIWeatherPresenter;
        mOpenWeatherMapServices = ApiUltis.iOpenWeatherMap();
    }
    public void getWeather(Double lat, Double lon){
        mOpenWeatherMapServices.getWeather(lat,lon, Constant.KEY_API).enqueue(callback);
    }
    public static Callback<WeatherRespone> callback = new Callback<WeatherRespone>() {
        @Override
        public void onResponse(Call<WeatherRespone> call, Response<WeatherRespone> response) {
            mIWeatherPresenter.getWeatherSucces(response.body());
        }

        @Override
        public void onFailure(Call<WeatherRespone> call, Throwable throwable) {
            mIWeatherPresenter.getWeatherError(throwable.getMessage());
        }
    };
}
