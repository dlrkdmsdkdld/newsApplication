package kr.ac.kpu.ce2017154024.newsappwithwanted.repository

import android.util.Log
import kotlinx.coroutines.*
import kr.ac.kpu.ce2017154024.newsappwithwanted.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.Articles
import kr.ac.kpu.ce2017154024.newsappwithwanted.hilt.retrofitInterface
import kr.ac.kpu.ce2017154024.newsappwithwanted.util
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import retrofit2.Call
import retrofit2.Response
import retrofit2.await
import retrofit2.awaitResponse
import retrofit2.http.GET
import javax.inject.Inject
import javax.security.auth.callback.Callback

class TopNewsRepository @Inject constructor(private val apimodule: retrofitInterface) {
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

        return res.await()
        //return null
    }
}