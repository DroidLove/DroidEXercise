package com.ex.droidlist;

/**
 * Created by jitesh on 2/3/17.
 */

public interface MainActivityContract {

    public interface Presenter {
        void onShowData(TemperatureData temperatureData);
    }

    public interface View {
        void showData(TemperatureData temperatureData);
    }


}
