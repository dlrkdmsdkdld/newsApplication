package kr.ac.kpu.ce2017154024.newsappwithwanted.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DBArticle (  @PrimaryKey val title:String,
                        @ColumnInfo val urlToImage:String,
                        @ColumnInfo val publishedAt:String,
                        @ColumnInfo  val author:String?="",
                        @ColumnInfo val content:String
        )


