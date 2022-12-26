package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kr.ac.kpu.ce2017154024.newsappwithwanted.MainActivity
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.data.HeaderType
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment(),View.OnClickListener {

    private lateinit var binding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCategoriesBinding.inflate(inflater,container,false)

        initview()
        return binding.root
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.categoriesBusiness ->{
                next("business")
            }
            binding.categoriesGeneral -> next("general")
            binding.categoriesEntertainment -> next("entertainment")
            binding.categoriesHealth -> next("health")
            binding.categoriesScience ->next("science")
            binding.categoriesSport -> next("sports")
            binding.categoriesTech -> next("technology")

        }
    }
    private fun next(des:String){
        val bundle = bundleOf("amount" to des)
        findNavController().navigate(R.id.action_categoriesFragment_to_categoryDetailFragment,bundle )
    }
    private fun initview(){
        binding.categoriesHeader.type=HeaderType.basic
        binding.categoriesHeader.headerBasicTitle.text = "Category"
        binding.categoriesBusiness.setOnClickListener(this)
        binding.categoriesGeneral.setOnClickListener(this)
        binding.categoriesEntertainment.setOnClickListener(this)
        binding.categoriesHealth.setOnClickListener(this)
        binding.categoriesScience.setOnClickListener(this)
        binding.categoriesSport.setOnClickListener(this)
        binding.categoriesTech.setOnClickListener(this)
    }


}