package com.wencong.mvpcode

import androidx.lifecycle.ViewModel
import com.wencong.mvpcode.util.RequestData

class MainListViewModel : ViewModel() {

    private val dataRequest: RequestData = RequestData()

    var items: List<ListData>

    init {
        items = emptyList()
    }

    fun loadData() {
        items = dataRequest.loadMainData()
    }
}