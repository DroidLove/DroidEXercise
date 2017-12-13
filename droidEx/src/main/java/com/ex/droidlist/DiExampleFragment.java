package com.ex.droidlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.droidlist.di.DaggerFragmentComponent;
import com.ex.droidlist.di.FragmentComponent;
import com.ex.droidlist.di.FragmentModule;

import javax.inject.Inject;

/**
 * Created by itrs-203 on 11/13/17.
 */

public class DiExampleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frament_di_example, container, false);


        return view;
    }

    @Inject
    public DiExampleFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initInjector();
    }

    private void initInjector() {
        FragmentComponent component = DaggerFragmentComponent.builder().applicationComponent(AppController.getComponent()).fragmentModule(new FragmentModule(this)).build();
        component.inject(this);
    }
}
