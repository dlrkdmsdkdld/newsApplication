package kr.ac.kpu.ce2017154024.newsappwithwanted.hilt

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.ac.kpu.ce2017154024.newsappwithwanted.room.MainRoomDatabase
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):MainRoomDatabase{
        return Room.databaseBuilder(context,MainRoomDatabase::class.java,"myroom.db").build()
    }

}