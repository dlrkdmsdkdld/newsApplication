package kr.ac.kpu.ce2017154024.newsappwithwanted.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_topheadline.view.*
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import java.text.SimpleDateFormat

class TopRecylcerViewAdapter(data:List<Article>, RecylcerInterface: ITopRecyclerView) : RecyclerView.Adapter<TopRecyclerViewHolder>() {
    val data= data
    private val RecylcerInterface = RecylcerInterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRecyclerViewHolder {
        return TopRecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_topheadline,parent,false)
        ,this.RecylcerInterface)
    }

    override fun onBindViewHolder(holder: TopRecyclerViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return this.data.size
    }
}
class TopRecyclerViewHolder(itemView: View,RecylcerInterface :ITopRecyclerView) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
    val imageView = itemView.item_top_imageview
    val title=  itemView.item_top_title
    val author = itemView.item_top_author
    val time = itemView.item_top_time
    val layout = itemView.item_top_layout
    val RecylcerInterface = RecylcerInterface
    lateinit var article: Article
    init {
        layout.setOnClickListener(this)
    }
    fun bind(data : Article){
        title.text=data.title
        //author.text = data.source.name
        author.text=data.author
        this.article=data
        //author.text=data.content
        val hour = data.publishedAt.substring(11 until 13).toInt()
        val tmp = System.currentTimeMillis()
        val formatter = SimpleDateFormat("HH")
        val parseData=formatter.format(tmp).toInt()
        time.text = "${parseData - hour} hours ago"

        Glide.with(itemView).load(data.urlToImage).centerCrop().into(imageView)
    }

    override fun onClick(p0: View?) {
        when(p0){
            layout ->{
                Log.d(TAG,"현재 선택한  기사 : $article")
                this.RecylcerInterface.onSearchItemClicked(this.article)
            }
        }
    }


}