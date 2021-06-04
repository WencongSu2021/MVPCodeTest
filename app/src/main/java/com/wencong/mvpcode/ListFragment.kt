package com.wencong.mvpcode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wencong.mvpcode.adapter.DataAdapter
import com.wencong.mvpcode.adapter.ListData
import com.wencong.mvpcode.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private val viewModel = MainListViewModel()
    private lateinit var dataBinding: FragmentListBinding

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
        viewModel.loadData()
    }

    private fun init() {
        dataBinding.model = viewModel
        dataBinding.rvMainList.layoutManager = LinearLayoutManager(context)
        val dataAdapter = DataAdapter()
        dataBinding.rvMainList.adapter = dataAdapter

        dataBinding.srlMainList.setOnRefreshListener {
            viewModel.loadData()
            dataBinding.srlMainList.isRefreshing = false
            dataBinding.invalidateAll()
        }

        dataAdapter.loadMoreModule.isAutoLoadMore = false
        dataAdapter.loadMoreModule.enableLoadMoreEndClick = true
        dataAdapter.loadMoreModule.setOnLoadMoreListener {
            viewModel.loadData(true)
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
                    .navigate(R.id.action_listFragment_to_detailFragment,bundle)
            }
        }
    }
}