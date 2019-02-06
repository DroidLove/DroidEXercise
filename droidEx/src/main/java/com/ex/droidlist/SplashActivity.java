package com.ex.droidlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();

        if (appLinkData != null) {
            Log.e("appLinkData", appLinkData.toString());
            Log.e("appLinkData Path", appLinkData.getPath());
            if (appLinkData.getLastPathSegment() != null)
                Log.e("appLinkData LastPath", appLinkData.getLastPathSegment());

        }
    }
}
