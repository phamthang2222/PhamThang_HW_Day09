package vn.phamthang.day09.api;

import com.chuckerteam.chucker.api.ChuckerInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.phamthang.day09.MyApplication;
import vn.phamthang.day09.utils.Constant;

public class RetrofitClient {
    private static Retrofit intance;

    public static Retrofit getIntances() {
        if (intance == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new ChuckerInterceptor(MyApplication.getInstance().getApplicationContext()))
                    .build();
            intance = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return  intance;
    }
}
