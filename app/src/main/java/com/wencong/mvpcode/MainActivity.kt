package com.wencong.mvpcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.wencong.mvpcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private val viewModel = MainListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        dataBinding.model = viewModel
        dataBinding.rvMainList.layoutManager = LinearLayoutManager(this)
        dataBinding.rvMainList.adapter = DataAdapter()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }
}