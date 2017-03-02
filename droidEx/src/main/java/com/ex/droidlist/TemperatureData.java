package com.ex.droidlist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by jitesh on 2/3/17.
 */

public class TemperatureData extends BaseObservable {

    private String celsius;

    public TemperatureData(String celsius) {
        this.celsius = celsius;
    }

    private String fahrenheit;

    @Bindable
    public String getCelsius() {
        return celsius;
    }


    public void setCelsius(String celsius) {

        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }


}
