package com.wencong.mvpcode

import android.view.LayoutInflater
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FBSnapShotTest{

    @Test
    fun useAppContext() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.wencong.mvpcodetest", appContext.packageName)

            val view = LayoutInflater.from(appContext).inflate(R.layout.item_data, null, false)
            ViewHelpers.setupView(view)
                .setExactWidthDp(300)
                .layout()
            Screenshot.snap(view)
                .record()
        }
    }
}