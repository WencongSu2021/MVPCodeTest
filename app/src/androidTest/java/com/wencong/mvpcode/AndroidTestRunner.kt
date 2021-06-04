package com.wencong.mvpcode

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.facebook.litho.config.ComponentsConfiguration
import com.facebook.testing.screenshot.ScreenshotRunner
import com.facebook.testing.screenshot.layouthierarchy.LayoutHierarchyDumper
import com.facebook.testing.screenshot.layouthierarchy.common.TextViewAttributePlugin
import com.facebook.testing.screenshot.layouthierarchy.litho.LithoAttributePlugin
import com.facebook.testing.screenshot.layouthierarchy.litho.LithoHierarchyPlugin

class AndroidTestRunner : AndroidJUnitRunner() {
    companion object {
        init {
            LayoutHierarchyDumper.addGlobalAttributePlugin(TextViewAttributePlugin.getInstance())
            ComponentsConfiguration.isDebugModeEnabled = true
            LayoutHierarchyDumper.addGlobalHierarchyPlugin(LithoHierarchyPlugin.getInstance())
            LayoutHierarchyDumper.addGlobalAttributePlugin(LithoAttributePlugin.getInstance())
        }
    }
    override fun onCreate(args: Bundle?) {
        ScreenshotRunner.onCreate(this, args)
        super.onCreate(args)
    }

    override fun finish(resultCode: Int, results: Bundle?) {
        ScreenshotRunner.onDestroy()
        super.finish(resultCode, results)
    }
}