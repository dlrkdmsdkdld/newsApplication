package kr.ac.kpu.ce2017154024.newsappwithwanted.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Articles
import kr.ac.kpu.ce2017154024.newsappwithwanted.hilt.retrofitInterface

class PagingSource(private val retrofitInterface: retrofitInterface):PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?:state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val curKey = params.key ?: 1
            if (curKey != 1) delay(1_000L)

            val response = retrofitInterface.requestTopHeadline(page = curKey).articles ?:listOf()

            LoadResult.Page(data=response ,
            prevKey = if(curKey == 1) null else curKey -1,
                nextKey = if (response.isEmpty()) null else curKey + 1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }


    }
}