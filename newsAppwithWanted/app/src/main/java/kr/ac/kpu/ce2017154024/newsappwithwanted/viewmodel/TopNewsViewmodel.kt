package kr.ac.kpu.ce2017154024.newsappwithwanted.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.ac.kpu.ce2017154024.newsappwithwanted.repository.TopNewsRepository
import javax.inject.Inject

@HiltViewModel
class TopNewsViewmodel @Inject constructor(private val repository: TopNewsRepository) :ViewModel() {
    init {
        repository.gettag()
    }

}