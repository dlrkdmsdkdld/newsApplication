package kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.repository.RoomRepository
import kr.ac.kpu.ce2017154024.newsappwithwanted.room.DBArticle
import javax.inject.Inject


@HiltViewModel
class DetailViewmodel @Inject constructor(private val repository: RoomRepository):ViewModel() {

     fun insert(data:Article) {
        CoroutineScope(Dispatchers.IO).launch {
            val tmp = DBArticle(
                title = data.title,
                urlToImage = data.urlToImage,
                publishedAt = data.publishedAt.substring(0, 10),
                author = data.author,
                content = data.content
            )
            repository.insertArticle(tmp)

        }
    }
    suspend fun check(title:String):Boolean{
        val result = CompletableDeferred<Boolean>()
        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.checkArticle(title)
            if (data ==null) result.complete(false)
            else result.complete(true )
//            repository.checkArticle(title)?.let {
//                result.complete(true)
//            }
        }
        return result.await()
    }

}