package vn.phamthang.day09.presenter;

import vn.phamthang.day09.interactors.WeatherInteractor;
import vn.phamthang.day09.interfacee.IWeatherPresenter;
import vn.phamthang.day09.interfacee.IWeatherView;
import vn.phamthang.day09.objects.WeatherRespone;

public class WeatherPresenter implements IWeatherPresenter {

    private IWeatherView mIWeatherView;
    private WeatherInteractor mWeatherInteractor;

    public WeatherPresenter(IWeatherView iWeatherView) {
        this.mIWeatherView = iWeatherView;
        mWeatherInteractor =new WeatherInteractor(this);
    }
    public void getWeather(Double lat, Double lon){
        mWeatherInteractor.getWeather(lat,lon);
    }
    @Override
    public void getWeatherSucces(WeatherRespone respone) {
        if(mIWeatherView !=null){
            mIWeatherView.getWeatherSucces(respone);
        }
    }

    @Override
    public void getWeatherError(String error) {
        if(mIWeatherView !=null){
            mIWeatherView.getWeatherError(error);
        }
    }
}
