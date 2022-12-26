package kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.repository.TopNewsRepository
import kr.ac.kpu.ce2017154024.newsappwithwanted.util
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewmodel @Inject constructor(private val repository: TopNewsRepository) :
    ViewModel(){
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
    private val category = MutableLiveData<String>()
    val getcategory: LiveData<String>
        get() = category
    fun setcategory(data: String?){
        data?.let {  category.value =it
            getarticles(it)
        }
    }

    fun getarticles(data: String){
        viewModelScope.launch {
            repository.getCategoryAriticle(data)?.let {
                setarticles(it)
                Log.d(util.TAG,"받아옴")
            }
        }
    }

}