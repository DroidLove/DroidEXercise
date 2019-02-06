package com.ex.droidlist;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class CustomTabsActivity extends AppCompatActivity implements
		FragmentClickListener {

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	View[] home_Tabs = new View[4];
	ImageView img_inbox, img_chat, img_inbox1, img_chat1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_tabs);

		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager1);

		home_Tabs[0] = getLayoutInflater().inflate(R.layout.tab_item_layout,
				null);
		home_Tabs[1] = getLayoutInflater().inflate(R.layout.tab_item_layout,
				null);
		home_Tabs[2] = getLayoutInflater().inflate(R.layout.tab_item_layout,
				null);
		home_Tabs[3] = getLayoutInflater().inflate(R.layout.tab_item_layout,
				null);

		img_inbox = (ImageView) home_Tabs[0].findViewById(R.id.img_indicatior);
		img_chat = (ImageView) home_Tabs[1].findViewById(R.id.img_indicatior);
		img_inbox1 = (ImageView) home_Tabs[2].findViewById(R.id.img_indicatior);
		img_chat1 = (ImageView) home_Tabs[3].findViewById(R.id.img_indicatior);

		img_inbox.setImageResource(R.drawable.ic_navigation);
		img_chat.setImageResource(R.drawable.ic_navigation);

		tabs.setShouldExpand(true);
		tabs.setAllCaps(false);
		tabs.setIndicatorColorResource(android.R.color.transparent);

		tabs.setIndicatorHeight(4);

		MyPagerAdapter_Notification adapter = new MyPagerAdapter_Notification(
				getSupportFragmentManager(), home_Tabs);

		pager.setAdapter(adapter);

		tabs.setOnPageChangeListener(mTabsOnPageChangeListener);

		tabs.setViewPager(pager);
	}

	private ViewPager.OnPageChangeListener mTabsOnPageChangeListener = new ViewPager.OnPageChangeListener() {

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
		}

		@Override
		public void onPageSelected(final int position) {
			// Utils.position = position;

			switch (position) {
			case 0:
				// txtName_inbox.setTextColor(getResources().getColor(
				// R.color.fb_blue));
				// txtName_chat.setTextColor(getResources().getColor(
				// R.color.text_darkgray));
				img_inbox.setImageResource(R.drawable.ic_launcher);
				img_chat.setImageResource(R.drawable.ic_navigation);
				img_inbox1.setImageResource(R.drawable.ic_navigation);
				img_chat1.setImageResource(R.drawable.ic_navigation);

				// rl_feeds_selected.setVisibility(View.GONE);
				break;
			case 1:
				// txtName_chat.setTextColor(getResources().getColor(
				// R.color.fb_blue));
				// txtName_inbox.setTextColor(getResources().getColor(
				// R.color.text_darkgray));
				img_inbox.setImageResource(R.drawable.ic_navigation);
				img_chat.setImageResource(R.drawable.ic_launcher);
				img_inbox1.setImageResource(R.drawable.ic_navigation);
				img_chat1.setImageResource(R.drawable.ic_navigation);
				// rl_feeds_selected.setVisibility(View.GONE);
				break;
			case 2:
				img_inbox.setImageResource(R.drawable.ic_navigation);
				img_chat.setImageResource(R.drawable.ic_navigation);
				img_inbox1.setImageResource(R.drawable.ic_launcher);
				img_chat1.setImageResource(R.drawable.ic_navigation);
				break;
			case 3:
				img_inbox.setImageResource(R.drawable.ic_navigation);
				img_chat.setImageResource(R.drawable.ic_navigation);
				img_inbox1.setImageResource(R.drawable.ic_navigation);
				img_chat1.setImageResource(R.drawable.ic_launcher);
				break;
			default:
				break;
			}

		}

		@Override
		public void onPageScrollStateChanged(int state) {

		}
	};

	public class MyPagerAdapter_Notification extends FragmentPagerAdapter
			implements PagerSlidingTabStrip.ViewTabProvider {

		private View[] TABS;

		// private final int[] ICONS = { R.drawable.ic_launcher,
		// R.drawable.ic_launcher, R.drawable.ic_launcher,
		// R.drawable.ic_launcher };

		public MyPagerAdapter_Notification(FragmentManager fm, View[] tabs) {
			super(fm);

			TABS = tabs;
		}

		@Override
		public int getCount() {
			return TABS.length;
		}

		@Override
		public Fragment getItem(int index) {
			switch (index) {

			case 0:
				// Top Rated fragment activity
				return new MyListview1Fragment();

			case 1:
				// Top Rated fragment activity
				return new MyListView2Fragment();

			case 2:
				// Top Rated fragment activity
				return new MyListView3Fragment();

			case 3:
				// Top Rated fragment activity
				return new MyViewPagerFrag();

			}
			return null;
		}

		public View getPageView(int position) {
			return TABS[position];
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
		}

		// @Override
		// public int getPageIconResId(int position) {
		// // TODO Auto-generated method stub
		// return ICONS[position];
		// }
	}

	@Override
	public void onFragmentSelected(int position) {
		// TODO Auto-generated method stub
		
	}

}
