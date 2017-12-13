package com.ex.droidlist.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by itrs-203 on 11/13/17.
 */

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    void inject(Application application);

}