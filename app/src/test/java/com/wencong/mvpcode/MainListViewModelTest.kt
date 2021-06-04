package com.wencong.mvpcode

import com.wencong.mvpcode.adapter.ListData
import org.hamcrest.CoreMatchers.hasItems
import org.hamcrest.MatcherAssert
import org.junit.Assert.*
import org.junit.Test

class MainListViewModelTest{
    @Test
    fun testLoadData(){
        val viewModel = MainListViewModel()
        viewModel.loadData()
        assertTrue(viewModel.items.isNotEmpty())
    }

    @Test
    fun testEmptyData(){
        val viewModel = MainListViewModel()
        assertTrue(viewModel.items.isEmpty())
    }

    @Test
    fun testOutIndex(){
        val viewModel = MainListViewModel()
        viewModel.loadData()
        assertThrows(IndexOutOfBoundsException::class.java) {
            viewModel.items[10]
        }
    }

    @Test
    fun testLoadMore(){
        val viewModel = MainListViewModel()
        viewModel.loadData()
        viewModel.loadData(true)
        val listData = ListData(
            "data20",
            "This is simulated data 20, which is displayed and used on the interface"
        )
        MatcherAssert.assertThat(viewModel.items,hasItems(listData))
    }
}