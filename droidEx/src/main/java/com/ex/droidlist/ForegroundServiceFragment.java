package com.ex.droidlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Jitesh on 13/4/16.
 */
public class ForegroundServiceFragment extends Fragment {

    Button button1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_foregroundservice, container, false);

        button1 = (Button) view.findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent service = new Intent(getActivity(), ForegroundService.class);
                if (!ForegroundService.IS_SERVICE_RUNNING) {
                    service.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                    ForegroundService.IS_SERVICE_RUNNING = true;
                    button1.setText("Stop Service");
                } else {
                    service.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
                    ForegroundService.IS_SERVICE_RUNNING = false;
                    button1.setText("Start Service");

                }
                getActivity().startService(service);
            }
        });

        return view;
    }

}
