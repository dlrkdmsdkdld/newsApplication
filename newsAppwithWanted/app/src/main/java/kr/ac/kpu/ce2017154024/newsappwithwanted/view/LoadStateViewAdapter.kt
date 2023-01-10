package kr.ac.kpu.ce2017154024.newsappwithwanted.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.LoadStateViewBinding

class LoadStateViewAdapter(private val retry: () -> Unit) : LoadStateAdapter<LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = LoadStateViewHolder(parent, retry)

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) = holder.bind(loadState)
}
class LoadStateViewHolder(parent: ViewGroup, retry: () -> Unit) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.load_state_view, parent, false)) {
    private val binding = LoadStateViewBinding.bind(itemView)
    private val progressBar: ProgressBar = binding.pagingProgress
//    private val errorMsg: TextView = binding.errorMsg
//    private val retry: Button = binding.retryButton
//        .also {
//            it.setOnClickListener { retry() }
//        }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            //errorMsg.text = loadState.error.localizedMessage
        }

        progressBar.isVisible = loadState is LoadState.Loading
      //  retry.isVisible = loadState is LoadState.Error
       // errorMsg.isVisible = loadState is LoadState.Error
    }
}