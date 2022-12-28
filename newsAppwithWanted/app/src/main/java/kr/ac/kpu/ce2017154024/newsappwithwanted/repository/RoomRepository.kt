package kr.ac.kpu.ce2017154024.newsappwithwanted.repository

import kr.ac.kpu.ce2017154024.newsappwithwanted.hilt.RoomModule
import kr.ac.kpu.ce2017154024.newsappwithwanted.hilt.retrofitInterface
import kr.ac.kpu.ce2017154024.newsappwithwanted.room.DBArticle
import kr.ac.kpu.ce2017154024.newsappwithwanted.room.MainRoomDatabase
import javax.inject.Inject

class RoomRepository@Inject constructor(private val roomModule: MainRoomDatabase) {

    fun insertArticle(data:DBArticle){
        roomModule.getDao().insertArticle(data)
    }
    fun checkArticle(title:String):DBArticle{
        return roomModule.getDao().checkArticle(title)
    }

    fun deleteArticle(data: DBArticle){
        roomModule.getDao().deleteArticle(data)

    }
    fun getArticles():List<DBArticle>{
        return roomModule.getDao().getArticles()
    }
}