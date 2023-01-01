package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.HeaderType
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.ActivityMainBinding.inflate
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentCategoryDetailBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.ITopRecyclerView
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.TopRecylcerViewAdapter
import kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel.CategoryDetailViewmodel
import kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel.TopNewsViewmodel

@AndroidEntryPoint
class CategoryDetailFragment : Fragment(),View.OnClickListener, ITopRecyclerView {
    private lateinit var categoryDetailBinding: FragmentCategoryDetailBinding
    private val myViewmodel: CategoryDetailViewmodel by viewModels()
    private lateinit var RecylcerViewAdapter: TopRecylcerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoryDetailBinding=FragmentCategoryDetailBinding.inflate(inflater,container,false)
        categoryDetailBinding.categoryDetailHead.type= HeaderType.extend
        val category = arguments?.getString("amount")
        category?.let{      initview(it) }
        Log.d(TAG,"cat = $category")
        myViewmodel.getarticles.observe(viewLifecycleOwner, Observer {
            RecylcerViewAdapter=TopRecylcerViewAdapter(it,this,false)
            categoryDetailBinding.fragmentTopRecylcer.apply {
                adapter=RecylcerViewAdapter
                layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            }
        })

        return categoryDetailBinding.root
    }
    private fun initview(category:String){
        myViewmodel.setcategory(category)
        categoryDetailBinding.categoryDetailHead.headerExtendTitle.text = "Category - ${category}"
        categoryDetailBinding.categoryDetailHead.headerExtendBack.setOnClickListener(this)

    }
    override fun onClick(p0: View?) {
        when(p0){
            categoryDetailBinding.categoryDetailHead.headerExtendBack -> findNavController().popBackStack()
        }
    }

    override fun onSearchItemClicked(data: Article) {
        var postbundle = Bundle()
        postbundle.putSerializable("data",data)
        Log.d(TAG,"선택 : $data")
        postbundle.putBoolean("save",false)
        findNavController().navigate(R.id.action_categoryDetailFragment_to_detailFragment,postbundle)

    }


}