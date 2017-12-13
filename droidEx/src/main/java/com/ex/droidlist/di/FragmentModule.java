package com.ex.droidlist.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by itrs-203 on 11/13/17.
 */

@Module
public class FragmentModule {
    private final Fragment mFragment;

    public FragmentModule(final Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    public Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    @ActivityContext
    public Context provideFragmentContext() {
        return mFragment.getContext();
    }
}