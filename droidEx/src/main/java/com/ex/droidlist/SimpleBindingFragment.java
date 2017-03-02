package com.ex.droidlist;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.droidlist.databinding.FragmentSimpleBindingBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleBindingFragment extends Fragment {


    public SimpleBindingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentSimpleBindingBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_simple_binding, container, false);
        User user = new User("Test", "User");
        binding.setUser(user);

        return binding.getRoot();
    }

}
