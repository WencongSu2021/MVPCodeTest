package com.wencong.mvpcode.view.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wencong.mvpcode.R
import com.wencong.mvpcode.adapter.DataAdapter
import com.wencong.mvpcode.adapter.ListData
import com.wencong.mvpcode.base.BaseFragment
import com.wencong.mvpcode.databinding.FragmentListBinding
import com.wencong.mvpcode.util.RequestData


class ListFragment : BaseFragment<ListPresenter>(),ListContract.IListView {
    private lateinit var dataBinding: FragmentListBinding
    private var resultData:ResultData = ResultData()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        dataBinding.rvMainList.layoutManager = LinearLayoutManager(context)
        val dataAdapter = DataAdapter()
        dataBinding.rvMainList.adapter = dataAdapter

//        resultData.data = RequestData().loadMainData(0).toMutableList()
        mPresenter?.loadData(0)

        dataBinding.srlMainList.setOnRefreshListener {
            mPresenter?.loadData(0)
            dataBinding.srlMainList.isRefreshing = false
        }

        dataAdapter.loadMoreModule.isAutoLoadMore = false
        dataAdapter.loadMoreModule.enableLoadMoreEndClick = true
        dataAdapter.loadMoreModule.setOnLoadMoreListener {
            mPresenter?.loadData(dataAdapter.itemCount - 1)
            dataAdapter.loadMoreModule.loadMoreComplete()
            dataBinding.invalidateAll()
        }

        dataAdapter.setOnItemClickListener { adapter, _, position ->
            val item:ListData = adapter.getItem(position) as ListData
            Log.i("Adapter click", item.toString())
            item.run {
                val bundle = Bundle()
                bundle.putString("title", item.title)
                bundle.putString("content", item.content)
                NavHostFragment
                    .findNavController(this@ListFragment)
                    .navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }
    }

    override fun initPresenter(): ListPresenter {
        return ListPresenter(this)
    }

    override fun loadDataSuccess(currentIndex:Int,data: ResultData) {
        if (currentIndex == 0){
            resultData = data
        } else {
            data.data?.let {
                resultData.data?.addAll(it)
            }
        }
        if (dataBinding.data == null)
            dataBinding.data = resultData
        dataBinding.invalidateAll()
    }
}