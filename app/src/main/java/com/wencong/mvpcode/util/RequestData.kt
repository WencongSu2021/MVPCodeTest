package com.wencong.mvpcode.util

import com.wencong.mvpcode.adapter.ListData

/*
    Simulate request data
 */
class RequestData {
    fun loadMainData(currentIndex: Int = 0): List<ListData> {
        return ArrayList<ListData>().apply {
            for (index in currentIndex until currentIndex + 10) {
                add(
                    ListData(
                        "data${index + 1}",
                        "This is simulated data ${index + 1}, which is displayed and used on the interface"
                    )
                )
            }
        }
    }
}