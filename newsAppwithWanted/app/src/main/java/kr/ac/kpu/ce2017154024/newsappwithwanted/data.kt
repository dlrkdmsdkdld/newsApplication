package kr.ac.kpu.ce2017154024.newsappwithwanted

import java.io.Serializable

class data {
}

class Articles(val articles:List<Article>){

}
data class Article(val urlToImage:String ,val title:String,val publishedAt:String,val source:Source,val author:String,val content:String):Serializable{

}
data class Source(val name:String?,val id:String?)
