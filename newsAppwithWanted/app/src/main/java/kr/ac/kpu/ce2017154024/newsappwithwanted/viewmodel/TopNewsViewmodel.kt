package kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.repository.TopNewsRepository
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import javax.inject.Inject

@HiltViewModel
class TopNewsViewmodel @Inject constructor(private val repository: TopNewsRepository) :ViewModel() {
    private val articles = MutableLiveData<List<Article>>()
    val getarticles : LiveData<List<Article>>
        get() = articles
    fun setarticles(data:List<Article>?){
        data?.let {  articles.value =it}
    }
    private val selectarticle = MutableLiveData<Article>()
    val getselectarticle : LiveData<Article>
        get() = selectarticle
    fun setselectarticle(data: Article?){
        data?.let {  selectarticle.value =it}
    }

    val articlePagingLiveData=repository.getNewsList().asLiveData().cachedIn(viewModelScope)
    // top news
//    private var _topNewsList: MutableLiveData<PagingData<Article>> =
//        MutableLiveData(PagingData.empty())
//    val topNewsList: LiveData<PagingData<Article>>
//        get() = _topNewsList
//
//    fun getTopnewsPaging(){
//        viewModelScope.launch {
//            val data = repository.getNewsList().asLiveData().cachedIn(viewModelScope)
//            _topNewsList.value = data.value
//        }
//    }

    init {
//        viewModelScope.launch {
//             repository.gettag()?.let {
//                setarticles(it)
//                Log.d(TAG,"받아옴")
//            }
//        }
    }


}