package com.mistpaag.pairgame.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.adapter.LevelAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, LevelActivity::class.java)
        startActivity(intent)




    }


}
