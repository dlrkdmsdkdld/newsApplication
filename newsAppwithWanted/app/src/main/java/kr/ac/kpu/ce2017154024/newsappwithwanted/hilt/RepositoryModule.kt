package kr.ac.kpu.ce2017154024.newsappwithwanted.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ac.kpu.ce2017154024.newsappwithwanted.repository.TopNewsRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTopNewsRepository(apimodule: retrofitInterface): TopNewsRepository {
        return TopNewsRepository(apimodule)
    }


}