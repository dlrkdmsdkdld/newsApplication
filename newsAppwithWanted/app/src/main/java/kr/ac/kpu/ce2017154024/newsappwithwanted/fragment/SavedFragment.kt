package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.HeaderType
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Source
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentSavedBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.room.DBArticle
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.ITopRecyclerView
import kr.ac.kpu.ce2017154024.newsappwithwanted.view.TopRecylcerViewAdapter
import kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel.DetailViewmodel

@AndroidEntryPoint
class SavedFragment : Fragment(), ITopRecyclerView {
    private lateinit var binding: FragmentSavedBinding
    private val myviewmodel: DetailViewmodel by viewModels()
    private lateinit var myadapter: TopRecylcerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSavedBinding.inflate(inflater,container,false)
        binding.saveHead.type=HeaderType.basic
        binding.saveHead.headerBasicTitle.text ="Saved"
        initview()


        return binding.root
    }
    private fun initview(){
        CoroutineScope(Dispatchers.Main).launch {
            val tmp = myviewmodel.getArticles()
            initadapter(tmp)
        }

    }
    private fun initadapter(data:List<DBArticle>){
        var myList= mutableListOf<Article>()
        data.forEach {
            val tmp = Article(
            title = it.title,
            urlToImage = it.urlToImage,
            publishedAt = it.publishedAt,
            author = it.author,
            content = it.content, source = Source(null,null)
            )
            myList.add(tmp)
        }
        Log.d(TAG,"저장된 데이터  = ${myList}")
        myadapter=TopRecylcerViewAdapter(myList,this,true)
        binding.saveRecycler.apply {
            adapter = myadapter
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        }
    }

    override fun onSearchItemClicked(data: Article) {
        var postbundle = Bundle()
        postbundle.putSerializable("data",data)
        postbundle.putBoolean("save",true)
        findNavController().navigate(R.id.action_savedFragment_to_detailFragment,postbundle)

    }


}