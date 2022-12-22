package kr.ac.kpu.ce2017154024.newsappwithwanted.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideAPIService(): retrofitInterface{
        return retrofitInterface.create()
    }

}