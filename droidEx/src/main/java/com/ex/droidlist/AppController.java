package com.ex.droidlist;

import android.app.Application;

import com.ex.droidlist.di.ApplicationComponent;
import com.ex.droidlist.di.ApplicationModule;
import com.ex.droidlist.di.DaggerApplicationComponent;

/**
 * Created by itrs-203 on 11/13/17.
 */

public class AppController extends Application {
    private static volatile ApplicationComponent component;

    public static synchronized ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }
}
