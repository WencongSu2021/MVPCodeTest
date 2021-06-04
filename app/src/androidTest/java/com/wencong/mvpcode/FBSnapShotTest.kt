@file:Suppress("DEPRECATION")

package com.wencong.mvpcode

import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
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
        compareScreenshot(activity)
    }
}