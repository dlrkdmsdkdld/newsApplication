package kr.ac.kpu.ce2017154024.newsappwithwanted.hilt

import com.google.gson.JsonElement
import kr.ac.kpu.ce2017154024.newsappwithwanted.Articles
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface retrofitInterface {

    @GET("top-headlines?country=kr")
    fun requestTopHeadline(): Call<Articles>

    companion object {
            private const val BASE_URL =
                "https://newsapi.org/v2/"

            fun create(): retrofitInterface {
                val logger = HttpLoggingInterceptor().apply {
                    level =
                        HttpLoggingInterceptor.Level.BASIC
                }
                val interceptor = Interceptor { chain ->
                    with(chain) {
                        val newRequest = request().newBuilder()
                            .addHeader("X-Api-Key",  "6348acb2f43d4ab7a420ba98f67d6a08")
                            .build()
                        proceed(newRequest)
                    }
                }
                val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .addInterceptor(interceptor)
                    .build()

                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(retrofitInterface::class.java)
            }
    }
}