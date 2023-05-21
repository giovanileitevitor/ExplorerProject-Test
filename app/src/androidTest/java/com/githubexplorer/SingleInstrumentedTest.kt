package com.githubexplorer

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.githubexplorer.features.projectlist.ui.activity.ProjectListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SingleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(ProjectListActivity::class.java)

    @Test
    fun openAppTest(){
        Espresso.onView(ViewMatchers.withId(R.id.action_repository))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
    }

}