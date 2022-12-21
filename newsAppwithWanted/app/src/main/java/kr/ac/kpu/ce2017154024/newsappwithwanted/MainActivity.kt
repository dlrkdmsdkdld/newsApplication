package kr.ac.kpu.ce2017154024.newsappwithwanted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.ActivityMainBinding
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        //네비게이션 컨트롤러 가져옴
        val navController = navHostFragment.navController
        //바텀네비게이션뷰와 네비게이션을 묶어준다
        NavigationUI.setupWithNavController(mainBinding.mainBottom , navController)



    }
}