package com.mistpaag.pairgame.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.adapter.LevelAdapter
import com.mistpaag.pairgame.databinding.ActivityMainBinding
import com.mistpaag.pairgame.viewmodel.MainVM
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mainVM: MainVM
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val intent = Intent(this, LevelActivity::class.java)
        startActivity(intent)




    }


}
