package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.kpu.ce2017154024.newsappwithwanted.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentTopNewsBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.ITopRecyclerView
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.TopRecylcerViewAdapter
import kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel.TopNewsViewmodel

@AndroidEntryPoint
class TopNewsFragment : Fragment(),ITopRecyclerView {
    private lateinit var topNewsBinding: FragmentTopNewsBinding
    private val topNewsViewmodel:TopNewsViewmodel by viewModels()
    private lateinit var topnewsRecylcerViewAdapter: TopRecylcerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        topNewsBinding = FragmentTopNewsBinding.inflate(inflater,container,false)
        topNewsViewmodel.getarticles.observe(viewLifecycleOwner, Observer {
            it.forEach {
                Log.d(TAG,"기사 : $it")
            }
            topnewsRecylcerViewAdapter=TopRecylcerViewAdapter(it,this)
            topNewsBinding.fragmentTopRecylcer.apply {
                adapter=topnewsRecylcerViewAdapter
                layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

            }
        })
        return topNewsBinding.root

    }

    override fun onSearchItemClicked(data: Article) {
        Log.d(TAG,"data = $data")
        topNewsViewmodel.setselectarticle(data)
        var bundle = Bundle()
        bundle.putSerializable("data",data)
        findNavController().navigate(R.id.action_topNewsFragment_to_detailFragment,bundle)
    }


}