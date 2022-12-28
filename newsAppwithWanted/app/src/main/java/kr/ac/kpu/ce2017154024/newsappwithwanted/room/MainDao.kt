package kr.ac.kpu.ce2017154024.newsappwithwanted.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MainDao {
    @Insert
    fun insertArticle(article: DBArticle)

    @Query("select * from DBArticle")
    fun getArticles(): List<DBArticle>

    @Query("select * from DBArticle where title=:title")
    fun checkArticle(title:String):DBArticle

    @Delete
    fun deleteArticle(article: DBArticle)

}