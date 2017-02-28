package com.ex.droidlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyViewPager extends Fragment {

    ViewPager vp_pager;
    PagerTabStrip pagerTab;

    public static Fragment newInstance(MainActivity context, String Message) {
        Bundle b = new Bundle();

        b.putString("Message", Message);

        return Fragment.instantiate(context, MyViewPager.class.getName(), b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater
                .inflate(R.layout.viewpager1_frag, container, false);

        vp_pager = (ViewPager) view.findViewById(R.id.vp_pager);
        pagerTab = (PagerTabStrip) view.findViewById(R.id.pagerTab);

        pagerTab.setVisibility(View.GONE);

        vp_pager.setAdapter(new MyPageAdapter());

//		vp_pager.setPageTransformer(true, new ZoomOutPageTransformer());

        return view;
    }

    public class ZoomOutPageTransformer implements PageTransformer {
        private static final float MIN_SCALE = 0.85f;

        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as
                // well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
                        / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    class MyPageAdapter extends PagerAdapter {

        int NumberOfPages = 5;
        TextView tv_test;

        int[] backgroundcolor = {0xFF101010, 0xFF202020, 0xFF303030,
                0xFF404040, 0xFF505050};

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
