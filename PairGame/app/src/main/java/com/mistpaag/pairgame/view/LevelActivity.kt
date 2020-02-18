package com.mistpaag.pairgame.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.adapter.LevelAdapter
import com.mistpaag.pairgame.databinding.ActivityLevelBinding

class LevelActivity : AppCompatActivity() {

    lateinit var binding: ActivityLevelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_level)

        val adapter = LevelAdapter(){
            Log.d("lol",it.toString())
            val intent = Intent(this, GameActivity::class.java)
            /*intent.putExtra("imagen1","imagen1")
            intent.putExtra("imagen2","imagen2")
            intent.putExtra("imagen3","imagen3")*/
            val list = arrayOf("imagen1","imagen2")
            intent.putExtra("lista",list)
            startActivity(intent)
        }
        binding.recyclerLevel.adapter = adapter
        binding.
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}
