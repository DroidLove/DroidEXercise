package com.ex.droidlist;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.TimerTask;

/**
 * Created by Jitesh on 3/10/16.
 */

public class AnimationListFragment extends Fragment {

    ImageView splash_image_heart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_splash, container, false);

        splash_image_heart = (ImageView) view.findViewById(R.id.splash_image_heart);
        splash_image_heart.setBackgroundResource(R.drawable.animation_splash_heart);

//        MyAnimationRoutine mar = new MyAnimationRoutine(view);
//
//        Timer t = new Timer(false);
////        t.schedule(mar, 100);
//        t.schedule(mar, 0, 100);

        AnimationDrawable frameAnimation = (AnimationDrawable) splash_image_heart.getBackground();

        // Start the animation (looped playback by default).
        frameAnimation.start();

//        ScheduledExecutorService scheduler =
//                Executors.newSingleThreadScheduledExecutor();
//
//        scheduler.scheduleAtFixedRate
//                (new Runnable() {
//                    public void run() {
//                        // call service
//
//
//                        // Start the animation (looped playback by default).
//                        frameAnimation.start();
//                    }
//                }, 0, 1100, TimeUnit.MILLISECONDS);

        return view;
    }

    class MyAnimationRoutine extends TimerTask {

        View view;

        MyAnimationRoutine(View view) {
            this.view = view;
        }

        public void run() {
            ImageView img = (ImageView) view.findViewById(R.id.splash_image_heart);
            // Get the background, which has been compiled to an AnimationDrawable object.
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

            // Start the animation (looped playback by default).
            frameAnimation.start();
        }
    }
}
