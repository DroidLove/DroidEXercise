package com.ex.droidlist;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyAsyncFragment extends Fragment {

	Button btn_show_up;
	TextView tv_update;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.async, container, false);

		btn_show_up = (Button) view.findViewById(R.id.btn_show_up);
		tv_update = (TextView) view.findViewById(R.id.tv_update);

		btn_show_up.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				new MyAsynctasker().execute("");
			}
		});

		return view;
	}

	class MyAsynctasker extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.interrupted();
				}
			}
			return "Executed";
		}

		@Override
		protected void onPostExecute(String result) {
			tv_update.setText("Executed"); // txt.setText(result);
			// might want to change "executed" for the returned string passed
			// into onPostExecute() but that is upto you
		}

	}
}
