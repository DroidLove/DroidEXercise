package com.ex.droidlist;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by itrs-203 on 12/13/17.
 */

public class BindServiceFragment extends Fragment {

    Button buttonStart, buttonStop;
    MyBindService myService;
    boolean mIsBound = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_myservice, container, false);

        buttonStart = (Button) view.findViewById(R.id.buttonStart);
        buttonStop = (Button) view.findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mIsBound = true;
                getActivity().bindService(new Intent(getActivity(), MyBindService.class), mConnection, Context.BIND_AUTO_CREATE); //Binding to the service!
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsBound) {
                    getActivity().unbindService(mConnection);
                    mIsBound = false;
                }
            }
        });

        return view;
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            Toast.makeText(getActivity(), "onServiceConnected called", Toast.LENGTH_SHORT).show();
            // We've binded to LocalService, cast the IBinder and get LocalService instance
            MyBindService.LocalBinder binder = (MyBindService.LocalBinder) service;
            myService = binder.getServiceInstance(); //Get instance of your service!
            myService.startCounter();
//            myService.registerClient(getActivity()); //Activity register in the service as client for callabcks!
//            tvServiceState.setText("Connected to service...");
//            tbStartTask.setEnabled(true);
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            Toast.makeText(getActivity(), "onServiceDisconnected called", Toast.LENGTH_SHORT).show();
//            tvServiceState.setText("Service disconnected");
//            tbStartTask.setEnabled(false);
        }
    };
}
