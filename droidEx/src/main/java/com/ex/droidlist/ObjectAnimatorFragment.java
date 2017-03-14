package com.ex.droidlist;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ex.droidlist.helper.FlipAnimator;

/**
 * Created by jitesh on 14/3/17.
 */

public class ObjectAnimatorFragment extends Fragment {

    Button button_animate;
    RelativeLayout icon_back, icon_front;
    boolean clickboolean = false;
    ImageView icon_profile;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_object_animator, container, false);

        button_animate = (Button) view.findViewById(R.id.button_animate);
        icon_back = (RelativeLayout) view.findViewById(R.id.icon_back);
        icon_front = (RelativeLayout) view.findViewById(R.id.icon_front);
        icon_profile = (ImageView) view.findViewById(R.id.icon_profile);

        button_animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickboolean) {
                    clickboolean = false;
                    icon_front.setVisibility(View.GONE);
                    icon_back.setVisibility(View.VISIBLE);
                    icon_back.setAlpha(1);
                    FlipAnimator.flipView(getActivity(), icon_back, icon_front, true);
                } else {
                    clickboolean = true;
                    icon_back.setVisibility(View.GONE);
                    icon_front.setVisibility(View.VISIBLE);
                    icon_profile.setImageResource(R.drawable.bg_circle);
                    icon_profile.setColorFilter(getRandomMaterialColor("400"));
                    icon_front.setAlpha(1);
                    FlipAnimator.flipView(getActivity(), icon_back, icon_front, false);

                }
            }
        });


        return view;

    }

    private int getRandomMaterialColor(String typeColor) {
        int returnColor = Color.GRAY;
        int arrayId = getResources().getIdentifier("mdcolor_" + typeColor, "array", getActivity().getPackageName());

        if (arrayId != 0) {
            TypedArray colors = getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }
}
