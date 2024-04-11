package vn.phamthang.day09.objects;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("1h")
    @Expose
    private Double _1h;

    public Double get1h() {
        return _1h;
    }

    public void set1h(Double _1h) {
        this._1h = _1h;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "_1h=" + _1h +
                '}';
    }
}
