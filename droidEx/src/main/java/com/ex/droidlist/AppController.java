package com.ex.droidlist;

import android.app.Application;

import com.ex.droidlist.di.ApplicationComponent;
import com.ex.droidlist.di.ApplicationModule;
import com.ex.droidlist.di.DaggerApplicationComponent;
import com.squareup.leakcanary.LeakCanary;

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
        initLeakCanary();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
