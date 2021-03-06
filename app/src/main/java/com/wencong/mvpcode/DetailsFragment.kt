package com.wencong.mvpcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.wencong.mvpcode.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var dataBinding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false
        )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            dataBinding.title = getString("title")
            dataBinding.content = getString("content")
        }
        dataBinding.ivBack.setOnClickListener {
            activity?.onBackPressed()
        }
        dataBinding.tvDetailTitle.setOnClickListener {
            Toast.makeText(it.context,dataBinding.title,Toast.LENGTH_SHORT).show()
        }
    }
}