package com.wencong.mvpcode.view.list

import com.wencong.mvpcode.view.list.ListContract.IListModel
import com.wencong.mvpcode.adapter.ListData
import com.wencong.mvpcode.util.RequestData

class ListModel : IListModel {
    private val requestData = RequestData()
    override fun loadData(currentIndex: Int): ResultData {
        return ResultData(requestData.loadMainData(currentIndex).toMutableList())
    }
}