package kr.ac.kpu.ce2017154024.newsappwithwanted.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [DBArticle::class], version = 1)
abstract class MainRoomDatabase:RoomDatabase() {
    abstract fun getDao():MainDao

}