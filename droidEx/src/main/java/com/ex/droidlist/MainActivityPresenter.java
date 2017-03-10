package com.ex.droidlist;

/**
 * Created by jitesh on 2/3/17.
 */

public class MainActivityPresenter {

    private MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {

        this.view = view;
    }
    public void onShowData(TemperatureData temperatureData) {
        view.showData(temperatureData);
    }

}
