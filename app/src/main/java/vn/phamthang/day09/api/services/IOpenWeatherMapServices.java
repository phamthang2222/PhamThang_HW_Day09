package vn.phamthang.day09.api.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.phamthang.day09.objects.WeatherRespone;

public interface IOpenWeatherMapServices {
    @GET("data/2.5/weather?")
    Call<WeatherRespone> getWeather(@Query("lat") double lat, @Query("lon") double lon, @Query("appid") String api_key);
}
