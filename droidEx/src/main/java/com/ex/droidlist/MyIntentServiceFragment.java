package com.ex.droidlist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyIntentServiceFragment extends Fragment {

	TextView result;
	EditText input;
	private ResponseReceiver receiver;
	Button btn_send;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_intentservice,
				container, false);

		IntentFilter filter = new IntentFilter(ResponseReceiver.ACTION_RESP);
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		receiver = new ResponseReceiver();
		getActivity().registerReceiver(receiver, filter);

		result = (TextView) view.findViewById(R.id.tv_output);
		btn_send = (Button) view.findViewById(R.id.btn_send);

		input = (EditText) view.findViewById(R.id.edt_input);

		btn_send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final String strInputMsg = input.getText().toString();
				Intent msgIntent = new Intent(getActivity(),
						ExampleIntentService.class);
				msgIntent.putExtra(ExampleIntentService.PARAM_IN_MSG,
						strInputMsg);
				getActivity().startService(msgIntent);
			}
		});

		return view;
	}

	public class ResponseReceiver extends BroadcastReceiver {
		public static final String ACTION_RESP = "com.mamlambo.intent.action.MESSAGE_PROCESSED";

		@Override
		public void onReceive(Context context, Intent intent) {

			String text = intent
					.getStringExtra(ExampleIntentService.PARAM_OUT_MSG);
			result.setText(text);
		}
	}

}
