package com.ex.droidlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyViewPagerFrag extends Fragment {

    ViewPager vp_pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater
                .inflate(R.layout.viewpager1_frag, container, false);

        vp_pager = (ViewPager) view.findViewById(R.id.vp_pager);

        vp_pager.setAdapter(new MyAdapter(getChildFragmentManager()));

        vp_pager.setPageTransformer(true, new ZoomOutPageTransformer());

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

    class MyAdapter extends FragmentPagerAdapter {

        int page_count = 3;

        Fragment[] myFrag = new Fragment[]{new MyListView2Fragment(),
                new MyListView2Fragment(), new MyListView2Fragment()};

        String[] myTitles = new String[]{"One", "Two", "Three"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int arg0) {
            return myFrag[arg0];
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return page_count;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // TODO Auto-generated method stub
            return myTitles[position];
        }

    }

}
