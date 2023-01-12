package kr.ac.kpu.ce2017154024.newsappwithwanted.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Articles
import kr.ac.kpu.ce2017154024.newsappwithwanted.hilt.retrofitInterface
import kr.ac.kpu.ce2017154024.newsappwithwanted.paging.PagingSource
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class TopNewsRepository @Inject constructor(private val apimodule: retrofitInterface) {

     fun getNewsList(): Flow<PagingData<Article>> {
        return Pager(PagingConfig(pageSize = 10)){
            PagingSource(apimodule)
        }.flow
    }


     suspend fun getCategoryAriticle(category:String):List<Article>?{
        val data = apimodule.requestTopHeadlineCategory(category).articles

        return data
    }
/*
    suspend fun gettag(): List<Article>? {
        val res = CompletableDeferred<List<Article>?>()
        apimodule.requestTopHeadline().enqueue(object : retrofit2.Callback<Articles> {
            override fun onFailure(call: Call<Articles>, t: Throwable) {
                Log.d(TAG,"실패")
                res.complete(null)

            }

            override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                response.body()?.let {
                    Log.d(TAG,"it - > ${it.articles}")
                    res.complete(it.articles)
                    Log.d(TAG,"성공")

                }
            }

        })

        return data
        //return null
    }
*/
}
