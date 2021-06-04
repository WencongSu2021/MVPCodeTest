package com.wencong.mvpcode

import androidx.lifecycle.ViewModel
import com.wencong.mvpcode.adapter.ListData
import com.wencong.mvpcode.util.RequestData

class MainListViewModel : ViewModel() {

    private val dataRequest: RequestData = RequestData()

    var items: ArrayList<ListData> = ArrayList()

    fun loadData(isLoadMore:Boolean = false) {
        if (!isLoadMore){
            items.clear()
        }
        items.addAll(dataRequest.loadMainData(items.size))
    }
}