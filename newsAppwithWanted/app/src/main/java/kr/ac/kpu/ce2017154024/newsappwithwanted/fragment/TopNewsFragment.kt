package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentTopNewsBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel.TopNewsViewmodel

@AndroidEntryPoint
class TopNewsFragment : Fragment() {
    private lateinit var topNewsBinding: FragmentTopNewsBinding
    private val topNewsViewmodel:TopNewsViewmodel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        topNewsBinding = FragmentTopNewsBinding.inflate(inflater,container,false)
        topNewsViewmodel.getarticles.observe(viewLifecycleOwner, Observer {
            Log.d(TAG,"기사들 - > $")
            it.forEach {
                Log.d(TAG,"기사 : $it")
            }
        })
        return topNewsBinding.root

    }


}