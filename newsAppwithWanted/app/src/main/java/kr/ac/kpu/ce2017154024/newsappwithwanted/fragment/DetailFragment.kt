package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.HeaderType
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentDetailBinding
import java.text.SimpleDateFormat


class DetailFragment : Fragment(),View.OnClickListener{
    private lateinit var binding: FragmentDetailBinding
    private lateinit var article: Article
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        binding.fragmentTopHeader.type=HeaderType.extend
        binding.fragmentTopHeader.headerExtendBack.setOnClickListener(this)
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
            fragmentTopHeader.headerExtendTitle.text = data.title

        }

    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.fragmentTopHeader.headerExtendBack ->{
                findNavController().popBackStack()
            }
        }
    }


}