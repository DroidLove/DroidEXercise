package com.ex.droidlist;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Jitesh on 15/4/16.
 */
public class MyPagerTransformer extends Fragment {

    ViewPager vp_main;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_viewpager_transform, container, false);

        vp_main = (ViewPager) view.findViewById(R.id.vp_main);

        // Set an Adapter on the ViewPager
        vp_main.setAdapter(new MyAdapter(getChildFragmentManager()));

        // Set a PageTransformer
        vp_main.setPageTransformer(false, new RotationPageTransformer(60));

        return view;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return IntroFragment.newInstance(Color.parseColor("#03A9F4"), position); // blue
                case 1:
                    return IntroFragment.newInstance(Color.parseColor("#03A9F4"), position); // red
                default:
                    return IntroFragment.newInstance(Color.parseColor("#03A9F4"), position); // green
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public class RotationPageTransformer implements ViewPager.PageTransformer {
        private float minAlpha;
        private int degrees;
        private float distanceToCentreFactor;

        /**
         * Creates a RotationPageTransformer
         *
         * @param degrees the inner angle between two edges in the "polygon" that the pages are on.
         *                Note, this will only work with an obtuse angle
         */
        public RotationPageTransformer(int degrees) {
            this(degrees, 0.7f);
        }

        /**
         * Creates a RotationPageTransformer
         *
         * @param degrees  the inner angle between two edges in the "polygon" that the pages are on.
         *                 Note, this will only work with an obtuse angle
         * @param minAlpha the least faded out that the side
         */
        public RotationPageTransformer(int degrees, float minAlpha) {
            this.degrees = degrees;
            distanceToCentreFactor = (float) Math.tan(Math.toRadians(degrees / 2)) / 2;
            this.minAlpha = minAlpha;
        }

        public void transformPage(View view, float position) {

            int pagePosition = (int) view.getTag();

            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            float absPosition = Math.abs(position);

            view.setPivotX((float) pageWidth / 2);
            view.setPivotY((float) (pageHeight + pageWidth * distanceToCentreFactor));

            ImageView ic_tree = (ImageView) view.findViewById(R.id.img_tree);
            ImageView img_bird = (ImageView) view.findViewById(R.id.img_bird);

            ImageView img_cloud1 = (ImageView) view.findViewById(R.id.img_cloud1);
            ImageView img_cloud2 = (ImageView) view.findViewById(R.id.img_cloud2);

            ImageView img_sun = (ImageView) view.findViewById(R.id.img_sun);


//            float width = (float)view.getWidth();
//            float rotation = -15.0F * position;
//            view.setPivotX(width * 0.5F);
//            view.setPivotY(0.0F);
//            view.setTranslationX(0.0F);
//            view.setRotation(rotation);
//
            Log.e("Values", String.valueOf(position));

            if (position < -1) { //[-infinity,1)
                //off to the left by a lot
//                ic_tree.setRotation(0);
//                ic_tree.setAlpha(0);
            } else if (position <= 1) { //[-1,1]

                if (pagePosition == 1) {

                    img_sun.setVisibility(View.VISIBLE);
                    img_sun.setTranslationX((-position) * pageWidth);
                    img_sun.setRotation(position * (degrees - 90)); //rotate it

                    img_cloud1.setVisibility(View.VISIBLE);
                    img_cloud2.setVisibility(View.VISIBLE);
                    img_cloud1.setTranslationX((-position) * pageWidth);
                    img_cloud2.setTranslationX((-position) * pageWidth);

//                    img_cloud1.setAlpha(1.0f - absPosition);
//                    img_cloud2.setAlpha(1.0f - absPosition);

                    ic_tree.setVisibility(View.VISIBLE);
                    ic_tree.setTranslationX((-position) * pageWidth); //shift the view over

                    img_bird.setImageResource(R.drawable.ic_bird);
                    img_bird.setTranslationX((-position) * pageWidth); //shift the view over
                    img_bird.setTranslationY((-position) * pageWidth); //shift the view over

                    img_bird.setRotation(position * (90 - degrees)); //rotate it
                    // Fade the page relative to its distance from the center

                    img_bird.setAlpha(Math.max(minAlpha, 1 - Math.abs(position) / 3));
                } else if (pagePosition == 0) {

                    img_cloud1.setVisibility(View.VISIBLE);
                    img_cloud2.setVisibility(View.VISIBLE);
                    img_cloud1.setTranslationX((-position) * pageWidth);
                    img_cloud2.setTranslationX((-position) * pageWidth);

//                    img_cloud1.setAlpha(1.0f - absPosition);
//                    img_cloud2.setAlpha(1.0f - absPosition);

                    ic_tree.setVisibility(View.VISIBLE);
                    ic_tree.setTranslationX((-position) * pageWidth); //shift the view over
                    img_bird.setVisibility(View.GONE);

                } else if (pagePosition == 2) {

                    img_sun.setVisibility(View.VISIBLE);
                    img_sun.setTranslationX((-position) * pageWidth);
                    img_sun.setRotation(position * (degrees - 90)); //rotate it

                    img_cloud1.setVisibility(View.VISIBLE);
                    img_cloud2.setVisibility(View.VISIBLE);
                    img_cloud1.setTranslationX((-position) * pageWidth);
                    img_cloud2.setTranslationX((-position) * pageWidth);

//                    img_cloud1.setAlpha(1.0f - absPosition);
//                    img_cloud2.setAlpha(1.0f - absPosition);

                    ic_tree.setVisibility(View.VISIBLE);
                    ic_tree.setTranslationX((-position) * pageWidth); //shift the view over

                }
            } else { //(1, +infinity]
                //off to the right by a lot
//                ic_tree.setRotation(0);
//                ic_tree.setAlpha(0);
            }
        }
    }

    public class IntroPageTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View page, float position) {

            // Get the page index from the tag. This makes
            // it possible to know which page index you're
            // currently transforming - and that can be used
            // to make some important performance improvements.
            int pagePosition = (int) page.getTag();

            // Here you can do all kinds of stuff, like get the
            // width of the page and perform calculations based
            // on how far the user has swiped the page.
            int pageWidth = page.getWidth();
            float pageWidthTimesPosition = pageWidth * position;
            float absPosition = Math.abs(position);

            // Now it's time for the effects
            if (position <= -1.0f || position >= 1.0f) {

                // The page is not visible. This is a good place to stop
                // any potential work / animations you may have running.

            } else if (position == 0.0f) {

                // The page is selected. This is a good time to reset Views
                // after animations as you can't always count on the PageTransformer
                // callbacks to match up perfectly.

            } else {

                // The page is currently being scrolled / swiped. This is
                // a good place to show animations that react to the user's
                // swiping as it provides a good user experience.

                // Let's start by animating the title.
                // We want it to fade as it scrolls out
                View title = page.findViewById(R.id.title);
                title.setAlpha(1.0f - absPosition);

                // Now the description. We also want this one to
                // fade, but the animation should also slowly move
                // down and out of the screen
                View description = page.findViewById(R.id.description);
                description.setTranslationY(-pageWidthTimesPosition / 2f);
                description.setAlpha(1.0f - absPosition);

                // Now, we want the image to move to the right,
                // i.e. in the opposite direction of the rest of the
                // content while fading out
                View computer = page.findViewById(R.id.img_tree);

                // We're attempting to create an effect for a View
                // specific to one of the pages in our ViewPager.
                // In other words, we need to check that we're on
                // the correct page and that the View in question
                // isn't null.
                if (pagePosition == 0 && computer != null) {
                    computer.setAlpha(1.0f - absPosition);
                    computer.setTranslationX(-pageWidthTimesPosition * 1.5f);
                }

                // Finally, it can be useful to know the direction
                // of the user's swipe - if we're entering or exiting.
                // This is quite simple:
                if (position < 0) {
                    // Create your out animation here
                } else {
                    // Create your in animation here
                }
            }
        }

    }
}
