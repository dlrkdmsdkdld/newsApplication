package kr.ac.kpu.ce2017154024.newsappwithwanted.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.ac.kpu.ce2017154024.newsappwithwanted.R
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.FragmentSavedBinding


class SavedFragment : Fragment() {
    private lateinit var binding: FragmentSavedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSavedBinding.inflate(inflater,container,false)
        return binding.root
    }


}