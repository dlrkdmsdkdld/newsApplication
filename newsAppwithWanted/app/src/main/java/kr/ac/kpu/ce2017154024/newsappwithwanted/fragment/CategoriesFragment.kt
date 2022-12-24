package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.ac.kpu.ce2017154024.newsappwithwanted.MainActivity
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCategoriesBinding.inflate(inflater,container,false)
        val actionbar = (activity as MainActivity).supportActionBar
        actionbar?.title = "NewsApp"

        return binding.root
    }


}