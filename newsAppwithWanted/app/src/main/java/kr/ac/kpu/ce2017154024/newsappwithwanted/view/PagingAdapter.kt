package kr.ac.kpu.ce2017154024.newsappwithwanted.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article

class PagingAdapter(RecylcerInterface: ITopRecyclerView,isdb:Boolean) :
    PagingDataAdapter<Article, TopRecyclerViewHolder>( object :DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            //같은 객체인지 체크합니다
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            //같은 내용물인지 check 합니다
            return oldItem.title == newItem.title
        }


    }
) {
    val RecylcerInterface = RecylcerInterface
    val isdb = isdb

    override fun onBindViewHolder(holder: TopRecyclerViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(item,this.isdb)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRecyclerViewHolder {
        return TopRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_topheadline,parent,false)
            ,this.RecylcerInterface)
    }
//    val contentsType = 1
//    val loadStateType = 2
//    override fun getItemViewType(position: Int): Int {
//        return if (position == itemCount) {
//            contentsType
//        } else {
//            loadStateType
//        }
//    }

}