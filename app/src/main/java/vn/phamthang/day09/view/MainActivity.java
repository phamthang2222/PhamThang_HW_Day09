package vn.phamthang.day09.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.phamthang.day09.R;
import vn.phamthang.day09.interfacee.IWeatherView;
import vn.phamthang.day09.objects.WeatherRespone;
import vn.phamthang.day09.presenter.WeatherPresenter;

public class MainActivity extends AppCompatActivity implements IWeatherView,View.OnClickListener{
    EditText edtLon, edtLat;
    Button btSearch;
    TextView tvCity,tvCurrentTemp,tvMaxTemp,tvMinTemp,tvWind,tvHumidity,tvStatus;
    private WeatherRespone mWeatherRespone;
    private WeatherPresenter mWeatherPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        mWeatherPresenter = new WeatherPresenter(this);
    }

    private void initView() {
        edtLat = findViewById(R.id.edtLat);
        edtLon = findViewById(R.id.edtLon);
        tvCity = findViewById(R.id.tvCity);
        tvCurrentTemp = findViewById(R.id.tvCurrentTemp);
        tvMaxTemp = findViewById(R.id.maxTempTxt);
        tvMinTemp = findViewById(R.id.minTempTxt);
        tvWind = findViewById(R.id.tvWind);
        tvHumidity = findViewById(R.id.tvHumidity);
        tvStatus = findViewById(R.id.statusTxt);


        btSearch = findViewById(R.id.btnSearch);
        edtLon.setText(21.038710+"");
        edtLat.setText(105.769599+"");

        btSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSearch){
            getWeatherLocation();
        }
    }

    @Override
    public void getWeatherSucces(WeatherRespone respone) {
//        Toast.makeText(this, ""+respone.toString(), Toast.LENGTH_SHORT).show();

        tvCity.setText(respone.getName());
        tvCurrentTemp.setText(convertTemp(respone.getMain().getTemp())+"");
        tvMaxTemp.setText(convertTemp(respone.getMain().getTempMax())+"");
        tvMinTemp.setText(convertTemp(respone.getMain().getTempMin())+"");
        tvWind.setText(respone.getWind().getSpeed()+" km");
        tvHumidity.setText(respone.getMain().getHumidity()+"%");
        tvStatus.setText(respone.getWeather().get(0).getMain());

    }

    @Override
    public void getWeatherError(String error) {

    }
    private void getWeatherLocation(){
        Double lon = Double.valueOf(edtLat.getText().toString());
        Double lat = Double.valueOf(edtLon.getText().toString());
        mWeatherPresenter.getWeather(lat, lon);

    }
    private Integer convertTemp(double fahrenheit){
        return (int) (fahrenheit-273);
    }
}