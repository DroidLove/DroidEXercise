package com.ex.droidlist;

import com.ex.droidlist.MyIntentServiceFragment.ResponseReceiver;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.text.format.DateFormat;

public class ExampleIntentService extends IntentService {

    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_OUT_MSG = "omsg";

    public ExampleIntentService() {
        super("ExampleIntentService");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // TODO Auto-generated method stub
        String msg = intent.getStringExtra(PARAM_IN_MSG);
        SystemClock.sleep(3000); // 30 seconds
        String resultTxt = msg
                + " "
                + DateFormat.format("MM/dd/yy h:mmaa",
                System.currentTimeMillis());

        // processing done here….
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(ResponseReceiver.ACTION_RESP);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        broadcastIntent.putExtra(PARAM_OUT_MSG, resultTxt);
        sendBroadcast(broadcastIntent);
    }

}
