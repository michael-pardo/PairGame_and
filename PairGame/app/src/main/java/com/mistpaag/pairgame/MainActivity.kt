package com.mistpaag.pairgame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.mistpaag.pairgame.adapter.LevelAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = LevelAdapter(){
            val intent = Intent(this,GameActivity::class.java)
            /*intent.putExtra("imagen1","imagen1")
            intent.putExtra("imagen2","imagen2")
            intent.putExtra("imagen3","imagen3")*/
            val list = arrayOf("imagen1","imagen2")
            intent.putExtra("lista",list)
            startActivity(intent)
        }
        recycler_level.adapter = adapter


    }


}
