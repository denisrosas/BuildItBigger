package com.udacity.gradle.builditbigger;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class CheckJokeIsNotEmpty {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

//    @Before
//    public void RegisterIdlingResource(){
//        IdlingResource mIdlingResource = activityTestRule.getActivity().getIdlingResource();
//        Espresso.registerIdlingResources(mIdlingResource);
//    }
//
//    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
//        return new RecyclerViewMatcher(recyclerViewId);
//    }

    @Test
    public void CheckRecipeNames(){

        onView(withId(R.id.button_tell_joke)).
                perform(ViewActions.click());

        //check if a joke was received
        onView(withId(R.id.textview_joke)).check(matches(not(withText(""))));

    }
}
