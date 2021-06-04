package com.wencong.mvpcode.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wencong.mvpcode.DataAdapter
import com.wencong.mvpcode.ListData

/**
 * 绑定adapter的item数据
 */
@BindingAdapter("adapterItems")
fun setItems(listView: RecyclerView, items: List<ListData>) {
    items.let {
        (listView.adapter as DataAdapter).dataSet = it
    }
}