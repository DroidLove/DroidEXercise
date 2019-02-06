package com.ex.droidlist;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by itrs-676 on 23/05/17.
 */

public class ArrowAnimationListFragment extends Fragment {

    ImageView splash_image_arrow;
    AnimationDrawable frameAnimation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_arrow_animate, container, false);

        splash_image_arrow = (ImageView) view.findViewById(R.id.splash_image_arrow);
        splash_image_arrow.setImageResource(R.drawable.animation_list_doted_arrows_improved);

        frameAnimation = (AnimationDrawable) splash_image_arrow.getDrawable();

        // Start the animation (looped playback by default).
//        Log.e("FPS :", String.valueOf(frameAnimation.getNumberOfFrames()));

        frameAnimation.start();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                frameAnimation.stop();
                splash_image_arrow.setVisibility(View.GONE);
            }
        }, 5600);

        return view;
    }

}
