package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kr.ac.kpu.ce2017154024.newsappwithwanted.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.data
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentDetailBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentTopNewsBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import java.text.SimpleDateFormat


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var article: Article
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        article = arguments?.getSerializable("data") as Article
        initView(article)


        return binding.root
    }
    private fun initView(data: Article){
        binding.apply {
            Glide.with(requireContext()).load(data.urlToImage).into(binding.detailImage)
            detailTitle.text = data.title
            detailContent.text = data.content
            detailAuthor.text= data.author
            val hour = data.publishedAt.substring(11 until 13).toInt()
            val tmp = System.currentTimeMillis()
            val formatter = SimpleDateFormat("HH")
            val parseData=formatter.format(tmp).toInt()
            detailTime.text = "${parseData - hour} hours ago"

        }
    }


}