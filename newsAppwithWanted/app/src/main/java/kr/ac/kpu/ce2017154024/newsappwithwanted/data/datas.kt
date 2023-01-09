package kr.ac.kpu.ce2017154024.newsappwithwanted.data

import java.io.Serializable

data class NewsResponse(
    val status: String,
    val totalResults: Int?,
    val articles: List<Article>?,
    val code: String?,
    val message: String?
):Serializable

class Articles(val articles:List<Article>){

}
data class Article(val urlToImage:String, val title:String,
                   val publishedAt:String, val source: Source,
                   val author:String?="", val content:String):Serializable{

}
data class Source(val name:String?="",val id:String?="")
