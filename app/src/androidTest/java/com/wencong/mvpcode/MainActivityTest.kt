@file:Suppress("DEPRECATION")

package com.wencong.mvpcode


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wencong.mvpcode.adapter.DataAdapter
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewExist() {
        val frameLayout = onView(withId(R.id.rvMainList))
        frameLayout.check(matches(isDisplayed()))
    }

    @Test
    fun testDataExist() {
        onView(withId(R.id.rvMainList))
            .check(matches(withAdaptedData(equalTo("data1"))))
    }

    @Test
    fun testEndDataExist() {
        onView(withId(R.id.rvMainList))
            .check(matches(withAdaptedData(equalTo("data10"))))
    }

    @Test
    fun testDataWithout() {
        onView(withId(R.id.rvMainList))
            .check(matches(not(withAdaptedData(equalTo("data11")))))
    }

    @Test
    fun testLoadMore() {
        onView(withId(R.id.rvMainList))
            .perform(
                RecyclerViewActions.actionOnItem<BaseViewHolder>(
                    hasDescendant(withText("Click to load more")), click()
                )
            ).check(matches(withAdaptedData(equalTo("data14"))))
    }

    @Test
    fun testLoadMoreSecond(){
        onView(withId(R.id.rvMainList))
            .perform(
                RecyclerViewActions.actionOnItem<BaseViewHolder>(
                    hasDescendant(withText("Click to load more")), click()
                )
            ).perform(
                RecyclerViewActions.actionOnItem<BaseViewHolder>(
                    hasDescendant(withText("Click to load more")), click()
                )
            ).check(matches(withAdaptedData(equalTo("data25"))))
    }

    @Test
    fun scrollTest() {
        onView(withId(R.id.rvMainList))
            .perform(
                scrollTo<BaseViewHolder>(
                    hasDescendant(withText("data9"))
                )
            )
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
                val dataSet = (adapter as DataAdapter).data
                val count =
                    adapter.itemCount - adapter.footerLayoutCount - adapter.headerLayoutCount - if (adapter.loadMoreModule.isEnableLoadMore) 1 else 0
                for (i in 0 until count) {
                    if (dataMatcher.matches(dataSet[i].title)) {
                        return true
                    }
                }
                return false
            }
        }
    }
}
