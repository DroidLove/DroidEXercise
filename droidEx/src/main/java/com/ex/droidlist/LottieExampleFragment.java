package com.ex.droidlist;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;

public class LottieExampleFragment extends Fragment {

  LottieAnimationView animation_view;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View view  = inflater.inflate(R.layout.fragment_lottie_example, container, false);

    animation_view = (LottieAnimationView) view.findViewById(R.id.animation_view);
//    animation_view.setScale(2);

    return view;
  }
}
