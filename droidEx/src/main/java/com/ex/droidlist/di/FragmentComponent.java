package com.ex.droidlist.di;

import com.ex.droidlist.DiExampleFragment;

import dagger.Component;

/**
 * Created by itrs-203 on 11/13/17.
 */

@FragmentScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = { FragmentModule.class })
public interface FragmentComponent {

//    @ActivityContext
//    Context getContext();

    void inject(DiExampleFragment mainFragment);
}
