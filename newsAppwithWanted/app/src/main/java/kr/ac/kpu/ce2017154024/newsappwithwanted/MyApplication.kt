package kr.ac.kpu.ce2017154024.newsappwithwanted

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication  : Application() {
//    companion object{
//        lateinit var instance:MyApplication
//            private set
//    }

    override fun onCreate() {
        // instance=this
        super.onCreate()
    }
}