package com.wencong.mvpcode.view.list

import com.wencong.mvpcode.base.BasePresenter
import com.wencong.mvpcode.view.list.ListContract.IListModel
import com.wencong.mvpcode.view.list.ListContract.IListView

class ListPresenter(view: IListView) : BasePresenter<IListView?, IListModel?>(view) {
    fun loadData(currentIndex: Int) {
        mModel?.loadData(currentIndex)?.let { mView?.loadDataSuccess(currentIndex,it) }
    }

    init {
        val model = ListModel()
        attach(model)
    }
}