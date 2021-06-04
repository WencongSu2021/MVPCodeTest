package com.wencong.mvpcode.util

import com.wencong.mvpcode.adapter.ListData
import org.hamcrest.CoreMatchers.hasItems
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RequestDataTest {
    @Test
    fun testLoadData() {
        assertData(0, 10)
    }

    @Test
    fun testLoadMoreData() {
        assertData(10, 20)
    }

    @Test
    fun testWithoutData() {
        assertData(1,11,false)
    }

    private fun assertData(index: Int, hasItem: Int, assertType: Boolean = true) {
        val loadMainData = RequestData().loadMainData(index)
        val listData = ListData(
            "data$hasItem",
            "This is simulated data $hasItem, which is displayed and used on the interface"
        )
        if (assertType) {
            assertThat(loadMainData, hasItems(listData))
        } else {
            assertThat(loadMainData, not(hasItems(listData)))
        }
    }
}