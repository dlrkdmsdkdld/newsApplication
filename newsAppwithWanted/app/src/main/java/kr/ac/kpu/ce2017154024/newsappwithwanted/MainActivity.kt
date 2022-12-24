package kr.ac.kpu.ce2017154024.newsappwithwanted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.kpu.ce2017154024.newsappwithwanted.databinding.ActivityMainBinding
import kr.ac.kpu.ce2017154024.newsappwithwanted.util.TAG

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),
    androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
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
        Log.d(TAG,"메인 액티비티 생성")
        setSupportActionBar(mainBinding.toolbar)
        mainBinding.toolbar.setOnMenuItemClickListener(this)


    }
    fun getToolbar(){
        mainBinding.toolbar
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home ->{
                onBackPressed()
                Log.d(TAG,"눌림")
            }
        }
        Log.d(TAG,"실행은됨")

        return true
    }
}