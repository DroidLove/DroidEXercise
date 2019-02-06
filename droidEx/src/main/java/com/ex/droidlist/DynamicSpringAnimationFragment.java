package com.ex.droidlist;

import android.os.Bundle;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by itrs-676 on 31/07/17.
 */

public class DynamicSpringAnimationFragment extends Fragment {

    private static final String TAG = DynamicSpringAnimationFragment.class.getSimpleName();

    private SpringAnimation mSpringTranslationXAnimation;
    private SpringAnimation mSpringTranslationYAnimation;

    private ImageView mViewToBeAnimated;
    private float mXDiffInTouchPointAndViewTopLeftCorner;
    private float mYDiffInTouchPointAndViewTopLeftCorner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dynamic_animation, container, false);

        mViewToBeAnimated = (ImageView) view.findViewById(R.id.iv_translate_spring);

        mViewToBeAnimated.setOnTouchListener(onTouchListener);

        // final position provided is 0, because we want to ensure translationX/translationY of view
        // from wherever the view moved due to touch gesture to come back to its initial
        // translationX/translationY position which is 0.
        mSpringTranslationXAnimation = new SpringAnimation(mViewToBeAnimated,
                new FloatPropertyCompat<View>("translationX") {

                    @Override
                    public float getValue(View view) {
                        return view.getTranslationX();
                    }

                    @Override
                    public void setValue(View view, float value) {
                        view.setTranslationX(value);
                    }
                });

        SpringForce springForceX = new SpringForce(0f);
        springForceX.setStiffness(SpringForce.STIFFNESS_MEDIUM);
        springForceX.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        mSpringTranslationXAnimation.setSpring(springForceX);


        mSpringTranslationYAnimation = new SpringAnimation(mViewToBeAnimated,
                new FloatPropertyCompat<View>("translationY") {

                    @Override
                    public float getValue(View view) {
                        return view.getTranslationY();
                    }

                    @Override
                    public void setValue(View view, float value) {
                        view.setTranslationY(value);
                    }
                });

        SpringForce springForceY = new SpringForce(0f);
        springForceY.setStiffness(SpringForce.STIFFNESS_MEDIUM);
        springForceY.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        mSpringTranslationYAnimation.setSpring(springForceY);

        return view;
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // calculate the difference between touch point(event.getRawX()) on view & view's top left corner(v.getX())
                    mXDiffInTouchPointAndViewTopLeftCorner = event.getRawX() - v.getX();
                    mYDiffInTouchPointAndViewTopLeftCorner = event.getRawY() - v.getY();
                    // cancel spring animations
                    mSpringTranslationXAnimation.cancel();
                    mSpringTranslationYAnimation.cancel();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float newTopLeftX = event.getRawX() - mXDiffInTouchPointAndViewTopLeftCorner;
                    float newTopLeftY = event.getRawY() - mYDiffInTouchPointAndViewTopLeftCorner;
                    mViewToBeAnimated.setX(newTopLeftX);
                    mViewToBeAnimated.setY(newTopLeftY);
                    break;
                case MotionEvent.ACTION_UP:
                    mSpringTranslationXAnimation.start();
                    mSpringTranslationYAnimation.start();
                    break;
            }
            return true;
        }
    };
}
