package com.ex.droidlist;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ex.droidlist.databinding.ActivityLauchModePlayBinding;

public class LaunchModePlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLauchModePlayBinding dataBindingActivity = DataBindingUtil.setContentView(this, R.layout.activity_lauch_mode_play);

        dataBindingActivity.buttonStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchModePlayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        dataBindingActivity.buttonSingleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchModePlayActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        dataBindingActivity.buttonSingleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchModePlayActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        dataBindingActivity.buttonSingleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchModePlayActivity.this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_);
                startActivity(intent);
            }
        });
    }
}
