package vn.phamthang.day09.interfacee;

import vn.phamthang.day09.objects.WeatherRespone;

public interface IWeatherView {
    void getWeatherSucces(WeatherRespone respone);
    void getWeatherError(String error);

}
