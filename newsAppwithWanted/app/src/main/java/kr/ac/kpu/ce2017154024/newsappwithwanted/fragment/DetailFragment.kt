package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.Article
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.HeaderType
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentDetailBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG
import kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel.DetailViewmodel
import kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel.TopNewsViewmodel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class DetailFragment : Fragment(),View.OnClickListener{
    private lateinit var binding: FragmentDetailBinding
    private lateinit var article: Article
    private val myviewmodel: DetailViewmodel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        binding.fragmentTopHeader.type=HeaderType.extend
        binding.fragmentTopHeader.headerExtendBack.setOnClickListener(this)
        binding.detailStar.setOnClickListener(this)
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

            if (data.title.length>35){
                val tmp ="${data.title.substring(0,35)}..."
                fragmentTopHeader.headerExtendTitle.text=tmp
            }
            else fragmentTopHeader.headerExtendTitle.text = data.title
               // Log.d(TAG," 타임 ; ${data.publishedAt.substring(0,10)}")
            checkStar(data.title)


        }

    }
    private fun checkStar(title:String){
        CoroutineScope(Dispatchers.Main).launch {
            val check = myviewmodel.check(title)
            if (check) binding.detailStar.setBackgroundResource(R.drawable.ic_baseline_star_24)
            else binding.detailStar.setBackgroundResource(R.drawable.ic_baseline_star_outline_24)
        }

    }
    override fun onClick(p0: View?) {
        when(p0){
            binding.fragmentTopHeader.headerExtendBack ->{
                findNavController().popBackStack()
            }
            binding.detailStar ->{
                binding.detailStar.setBackgroundResource(R.drawable.ic_baseline_star_24)
                myviewmodel.insert(article)
            }
        }
    }


}