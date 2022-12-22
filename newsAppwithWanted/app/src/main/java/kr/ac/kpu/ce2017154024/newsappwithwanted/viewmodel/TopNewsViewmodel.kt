package kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kr.ac.kpu.ce2017154024.newsappwithwanted.Article
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
    init {
        viewModelScope.launch {
             repository.gettag()?.let {
                setarticles(it)
                Log.d(TAG,"받아옴")
            }
        }
    }


}