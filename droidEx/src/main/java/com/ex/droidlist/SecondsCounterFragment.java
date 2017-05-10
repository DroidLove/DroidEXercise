package com.ex.droidlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.droidlist.databinding.FragmentSecondsCounterBinding;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by itrs-676 on 10/05/17.
 */

public class SecondsCounterFragment extends Fragment {

    FragmentSecondsCounterBinding fragmentSecondsCounterBinding;
    Timer timer;
    int count = 0;
    TimerTask timerTask;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentSecondsCounterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_seconds_counter, container, false);
        timer = new Timer();

        fragmentSecondsCounterBinding.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timerTask == null) {
                    count = 0;
                    timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // changes
                                    if (count > 1) {
                                        fragmentSecondsCounterBinding.textViewSeconds.setText(count + " Seconds");
                                    } else if (count == 1) {
                                        fragmentSecondsCounterBinding.textViewSeconds.setText(count + " Second");
                                    }
                                    count++;
                                }
                            });
                        }
                    };
                    timer.scheduleAtFixedRate(timerTask, 1000, 1000);
                }

            }
        });

        fragmentSecondsCounterBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerTask != null) {
                    timerTask.cancel();
                    timerTask = null;
                    fragmentSecondsCounterBinding.textViewSeconds.setText("");
                }
            }
        });

        return fragmentSecondsCounterBinding.getRoot();
    }
}
