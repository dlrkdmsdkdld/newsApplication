package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.HeaderType
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentTopNewsBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.ITopRecyclerView
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.LoadStateViewAdapter
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.PagingAdapter
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.TopRecylcerViewAdapter
import kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel.TopNewsViewmodel

@AndroidEntryPoint
class TopNewsFragment : Fragment(),ITopRecyclerView {
    private lateinit var topNewsBinding: FragmentTopNewsBinding
    private val topNewsViewmodel:TopNewsViewmodel by viewModels()
   // private lateinit var topnewsRecylcerViewAdapter: TopRecylcerViewAdapter
    private  val topnewsPagingRecylcerViewAdapter: PagingAdapter by lazy { PagingAdapter(this,false) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        topNewsBinding = FragmentTopNewsBinding.inflate(inflater,container,false)

        //topNewsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_top_news,container,false)
        topNewsBinding.fragmentTopHeader.type = HeaderType.basic
//        topNewsViewmodel.getarticles.observe(viewLifecycleOwner, Observer {
//            it.forEach {
//                Log.d(TAG,"기사 : $it")
//            }
//            topnewsRecylcerViewAdapter=TopRecylcerViewAdapter(it,this,false)
//            topNewsBinding.fragmentTopRecylcer.apply {
//                adapter=topnewsRecylcerViewAdapter
//                layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
//
//            }
//        })



//        topnewsPagingRecylcerViewAdapter = PagingAdapter(this,false)
//        viewLifecycleOwner.lifecycleScope.launch {
//            topNewsViewmodel.articlePagingLiveData
//        }


        setUpRecyclerView()
        ObservePaging()
        return topNewsBinding.root

    }
    private fun setUpRecyclerView(){
//        topnewsPagingRecylcerViewAdapter.withLoadStateHeader(LoadStateViewAdapter{//retry 원하면 코드 삽입하면됨
//             })
        topNewsBinding.fragmentTopRecylcer.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = topnewsPagingRecylcerViewAdapter.withLoadStateFooter(LoadStateViewAdapter{})
        }
    }

    private fun ObservePaging(){

        topNewsViewmodel.articlePagingLiveData.observe(viewLifecycleOwner){pagingdata ->
            viewLifecycleOwner.lifecycleScope.launch {
                topnewsPagingRecylcerViewAdapter.submitData(pagingdata)
            }
        }
    }

    override fun onSearchItemClicked(data: Article) {
        Log.d(TAG,"data = $data")
        Log.d(TAG,"데이터있음")
        var postbundle = Bundle()
        
        postbundle.putSerializable("data",data)
        postbundle.putBoolean("save",false)
        findNavController().navigate(R.id.action_topNewsFragment_to_detailFragment,postbundle)


     }


}