package com.wencong.mvpcode.util

import android.accounts.NetworkErrorException
import com.wencong.mvpcode.ListData
import kotlin.random.Random

/*
    Simulate request data
 */
class RequestData {
    fun loadMainData(currentIndex: Int = 0): List<ListData> {
        val mainData = ArrayList<ListData>().apply {
            for (index in currentIndex..currentIndex + 10) {
                add(
                    ListData(
                        "data$index",
                        "This is simulated data $index, which is displayed and used on the interface"
                    )
                )
            }
        }
        return if (Random.nextBoolean()) mainData else emptyList()
    }
}