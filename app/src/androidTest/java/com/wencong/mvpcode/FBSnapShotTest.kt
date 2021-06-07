@file:Suppress("DEPRECATION")

package com.wencong.mvpcode

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test

class FBSnapShotTest : SnapshotTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @get:Rule
    var permissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun snapShotTest() {
        val activity = activityRule.launchActivity(null)
        onView(withId(R.id.rvMainList))
            .perform(
                RecyclerViewActions.actionOnItem<BaseViewHolder>(
                    ViewMatchers.hasDescendant(ViewMatchers.withText("Click to load more")),
                    ViewActions.click()
                )
            ).check(ViewAssertions.matches(withAdaptedData(CoreMatchers.equalTo("data20"))))
        compareScreenshot(activity)
    }
}