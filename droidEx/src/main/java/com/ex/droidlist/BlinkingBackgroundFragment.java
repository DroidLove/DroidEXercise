package com.ex.droidlist;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * Created by itrs-676 on 01/07/17.
 */

public class BlinkingBackgroundFragment extends Fragment {

    RelativeLayout relative_blinking;
    Handler mHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blinking_demo, container, false);

        relative_blinking = (RelativeLayout) view.findViewById(R.id.relative_blinking);
        mHandler = new Handler();

        runnable.run();

        return view;
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            mHandler.postDelayed(runnable, 1000);
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//            relative_blinking.setBackgroundColor(color);
            changeStatusBarColor(color);
        }
    };

    private void changeStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(color);
            getMainActivity().changeToolbarBackground(color);
        }
    }


    protected MainActivity getMainActivity() {
        if (MainActivity.sWeakActivity == null && getActivity() != null)
            MainActivity.sWeakActivity = new WeakReference<>((MainActivity) getActivity());
        return MainActivity.sWeakActivity.get();
    }
}
