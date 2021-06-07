package com.wencong.mvpcode.view.list

import com.wencong.mvpcode.base.Contract

interface ListContract {
    interface IListView:Contract.BaseView {
        // 显示信息
        fun loadDataSuccess(currentIndex: Int,data: ResultData)
    }

    interface IListModel:Contract.BaseModel {
        // 登录接口
        fun loadData(currentIndex: Int): ResultData
    }
}