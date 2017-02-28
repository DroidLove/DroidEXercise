package com.ex.droidlist;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

public class MyViewPagerAuto extends Fragment {

	ViewPager vp_pager;
	PagerTabStrip pagerTab;

	Timer timer;
	int page = 1;

	public android.view.View onCreateView(android.view.LayoutInflater inflater,
			android.view.ViewGroup container,
			android.os.Bundle savedInstanceState) {

		View view = inflater
				.inflate(R.layout.viewpager1_frag, container, false);

		vp_pager = (ViewPager) view.findViewById(R.id.vp_pager);
		pagerTab = (PagerTabStrip) view.findViewById(R.id.pagerTab);

		pagerTab.setVisibility(View.GONE);

		vp_pager.setAdapter(new MyPageAdapter());

		pageSwitcher(5);

		try {
			Field mScroller;
			mScroller = ViewPager.class.getDeclaredField("mScroller");
			mScroller.setAccessible(true);
			FixedSpeedScroller scroller = new FixedSpeedScroller(
					vp_pager.getContext(), new AccelerateInterpolator());
			// scroller.setFixedDuration(5000);
			mScroller.set(vp_pager, scroller);
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}

		return view;

	};

	public class HesitateInterpolator implements Interpolator {
		public HesitateInterpolator() {
		}

		public float getInterpolation(float t) {
			float x = 2.0f * t - 1.0f;
			return 0.5f * (x * x * x + 1.0f);
		}
	}

	public void pageSwitcher(int seconds) {
		timer = new Timer(); // At this line a new Thread will be created
		timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
																		// in
		// milliseconds
	}

	// this is an inner class...
	class RemindTask extends TimerTask {

		@Override
		public void run() {

			// As the TimerTask run on a seprate thread from UI thread we have
			// to call runOnUiThread to do work on UI thread.
			getActivity().runOnUiThread(new Runnable() {
				public void run() {

					if (page > 4) { // In my case the number of pages are 5
						timer.cancel();
						// Showing a toast for just testing purpose
						// Toast.makeText(getActivity(), "Timer stoped",
						// Toast.LENGTH_LONG).show();
						page = 1;
						pageSwitcher(3);

					} else {
						vp_pager.setCurrentItem(page++);
					}
				}
			});

		}
	}

	public class FixedSpeedScroller extends Scroller {

		private int mDuration = 1500;

		public FixedSpeedScroller(Context context) {
			super(context);
		}

		public FixedSpeedScroller(Context context, Interpolator interpolator) {
			super(context, interpolator);
		}

		public FixedSpeedScroller(Context context, Interpolator interpolator,
				boolean flywheel) {
			super(context, interpolator, flywheel);
		}

		@Override
		public void startScroll(int startX, int startY, int dx, int dy,
				int duration) {
			// Ignore received duration, use fixed one instead
			super.startScroll(startX, startY, dx, dy, mDuration);
		}

		@Override
		public void startScroll(int startX, int startY, int dx, int dy) {
			// Ignore received duration, use fixed one instead
			super.startScroll(startX, startY, dx, dy, mDuration);
		}
	}

	class MyPageAdapter extends PagerAdapter {

		int NumberOfPages = 5;
		TextView tv_test;

		int[] backgroundcolor = { 0xFF101010, 0xFF202020, 0xFF303030,
				0xFF404040, 0xFF505050 };

		@Override
		public int getCount() {
			return NumberOfPages;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			View view = getActivity().getLayoutInflater().inflate(
					R.layout.pager_item, container, false);

			tv_test = (TextView) view.findViewById(R.id.tv_test);

			tv_test.setText("Pager No. " + position);

			tv_test.setBackgroundColor(backgroundcolor[position]);

			container.addView(view);

			return view;

		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((RelativeLayout) object);
		}

		// @Override
		// public void destroyItem(ViewGroup container, int position, Object
		// object) {
		// container.removeView((LinearLayout) object);
		// }

	}

}
