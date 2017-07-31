package com.ex.droidlist;

import android.os.Build;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by itrs-676 on 31/07/17.
 */

public class DynamicFlingAnimationFragment extends Fragment {

    private ImageView mViewTobeFlung;
    private TextView mTvFlingDistance;
    private RelativeLayout mMainLayout;
    private int maxTranslationX;
    private int maxTranslationY;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dynamic_fling_animation, container, false);

        mViewTobeFlung = (ImageView) view.findViewById(R.id.iv_translate_fling);
        mTvFlingDistance = (TextView) view.findViewById(R.id.tv_fling_distance);
        mMainLayout = (RelativeLayout) view.findViewById(R.id.main_layout);

        final GestureDetector gestureDetector = new GestureDetector(getActivity(), mGestureListener);

        mViewTobeFlung.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });


        mMainLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                maxTranslationX = mMainLayout.getWidth() - mViewTobeFlung.getWidth();
                maxTranslationY = mMainLayout.getHeight() - mViewTobeFlung.getHeight();
                //As only wanted the first call back, so now remove the listener
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                    mMainLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                else
                    mMainLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        return view;
    }

    private GestureDetector.OnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {

        //Constants
        private static final int MIN_DISTANCE_MOVED = 50;
        private static final float MIN_TRANSLATION = 0;
        private static final float FRICTION = 1.1f;

        @Override
        public boolean onDown(MotionEvent arg0) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
            //downEvent : when user puts his finger down on the view
            //moveEvent : when user lifts his finger at the end of the movement
            float distanceInX = Math.abs(moveEvent.getRawX() - downEvent.getRawX());
            float distanceInY = Math.abs(moveEvent.getRawY() - downEvent.getRawY());

            mTvFlingDistance.setText("distanceInX : " + distanceInX + "\n" + "distanceInY : " + distanceInY);

            if (distanceInX > MIN_DISTANCE_MOVED) {
                //Fling Right/Left
                FlingAnimation flingX = new FlingAnimation(mViewTobeFlung, DynamicAnimation.TRANSLATION_X);
                flingX.setStartVelocity(velocityX)
                        .setMinValue(MIN_TRANSLATION) // minimum translationX property
                        .setMaxValue(maxTranslationX)  // maximum translationX property
                        .setFriction(FRICTION)
                        .start();
            } else if (distanceInY > MIN_DISTANCE_MOVED) {
                //Fling Down/Up
                FlingAnimation flingY = new FlingAnimation(mViewTobeFlung, DynamicAnimation.TRANSLATION_Y);
                flingY.setStartVelocity(velocityY)
                        .setMinValue(MIN_TRANSLATION)  // minimum translationY property
                        .setMaxValue(maxTranslationY) // maximum translationY property
                        .setFriction(FRICTION)
                        .start();
            }

            return true;
        }
    };

}
