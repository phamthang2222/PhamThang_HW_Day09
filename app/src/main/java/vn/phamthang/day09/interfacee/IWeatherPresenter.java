package vn.phamthang.day09.interfacee;

import vn.phamthang.day09.objects.WeatherRespone;

public interface IWeatherPresenter {
    void getWeatherSucces(WeatherRespone respone);
    void getWeatherError(String error);
}
