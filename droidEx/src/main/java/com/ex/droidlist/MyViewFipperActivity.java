package com.ex.droidlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MyViewFipperActivity extends Activity {

	ViewFlipper viewFlipper1;
	TextView tv_windows, tv_ubuntu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewfilper_frag);

		overridePendingTransition(R.anim.slide_in_from_right,
				R.anim.slide_out_to_left);

		viewFlipper1 = (ViewFlipper) findViewById(R.id.viewFlipper1);
		tv_windows = (TextView) findViewById(R.id.tv_windows);
		tv_ubuntu = (TextView) findViewById(R.id.tv_ubuntu);

		tv_windows.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				viewFlipper1.setInAnimation(MyViewFipperActivity.this,
						R.anim.slide_in_from_right);
				viewFlipper1.setOutAnimation(MyViewFipperActivity.this,
						R.anim.slide_out_to_left);
				viewFlipper1.showNext();
			}
		});

		tv_ubuntu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				viewFlipper1.setInAnimation(MyViewFipperActivity.this,
						R.anim.slide_in_from_left);
				viewFlipper1.setOutAnimation(MyViewFipperActivity.this,
						R.anim.slide_out_to_right);
				viewFlipper1.showPrevious();
				;
			}
		});

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.slide_in_from_left,
				R.anim.slide_out_to_right);

	}

}
