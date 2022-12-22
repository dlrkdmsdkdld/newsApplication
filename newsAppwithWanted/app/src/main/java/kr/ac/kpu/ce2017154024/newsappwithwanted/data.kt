package kr.ac.kpu.ce2017154024.newsappwithwanted

class data {
}

class Articles(val articles:List<Article>){

}
data class Article(val urlToImage:String ,val title:String,val publishedAt:String,val source:Source){

}
data class Source(val name:String?,val id:String?)
