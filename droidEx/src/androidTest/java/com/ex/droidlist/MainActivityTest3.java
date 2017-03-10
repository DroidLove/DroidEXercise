package com.ex.droidlist;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest3 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest3() {
        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Open"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        imageButton.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(android.R.id.text1), withText("RecyclerView"),
                        childAtPosition(
                                allOf(withId(R.id.left_drawer),
                                        withParent(withId(R.id.drawer_layout))),
                                10),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Open"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        imageButton2.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(android.R.id.text1), withText("ListView with Images"),
                        childAtPosition(
                                allOf(withId(R.id.left_drawer),
                                        withParent(withId(R.id.drawer_layout))),
                                13),
                        isDisplayed()));
        appCompatTextView2.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
