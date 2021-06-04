package com.wencong.mvpcode


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.not
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val frameLayout = onView(withId(R.id.rvMainList))
        frameLayout.check(matches(isDisplayed()))
        //onView(withText("data1")).check(matches(isDisplayed()))
//        onView(allOf(withId(R.id.tvTitle), withText("data9")))
//        onView(allOf(withText("data1"), hasSibling(withText("This is simulated data 1, which is displayed and used on the interface"))))
//            .perform(click())
        onView(withId(R.id.rvMainList))
            .check(matches(withAdaptedData(equalTo("data1"))))
        onView(withId(R.id.rvMainList))
            .check(matches(withAdaptedData(equalTo("data10"))))
        onView(withId(R.id.rvMainList))
            .check(matches(not(withAdaptedData(equalTo("data11")))))
    }

    private fun withAdaptedData(dataMatcher: Matcher<Any>): Matcher<View> {
        return object : TypeSafeMatcher<View>() {

            override fun describeTo(description: Description) {
                description.appendText("with text: ")
                dataMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                if (view !is RecyclerView) {
                    return false
                }
                val adapter = view.adapter
                val dataSet = (adapter as DataAdapter).dataSet
                for (i in 0 until adapter.itemCount) {
                    if (dataMatcher.matches(dataSet[i].title)) {
                        return true
                    }
                }
                return false
            }
        }
    }
}
