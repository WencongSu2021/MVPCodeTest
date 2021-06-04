package com.wencong.mvpcode.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wencong.mvpcode.R

/**
 * 适配器
 */
class DataAdapter : BaseQuickAdapter<ListData, BaseViewHolder>(R.layout.item_data),LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: ListData) {
        holder.setText(R.id.tvTitle, item.title)
        holder.setText(R.id.tvContent, item.content)
    }
}