package vn.phamthang.day09.api;

import vn.phamthang.day09.api.services.IOpenWeatherMapServices;

public class ApiUltis {
    public static IOpenWeatherMapServices iOpenWeatherMap() {
        return RetrofitClient.getIntances().create(IOpenWeatherMapServices.class);
    }
}
