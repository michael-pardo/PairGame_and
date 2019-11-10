package com.mistpaag.pairgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.mistpaag.pairgame.adapter.GameAdapter
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    lateinit var adapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val imagen1 = intent.getStringArrayExtra("lista")
        for (i in imagen1) Log.d("lol",i.toString())

        adapter = GameAdapter(){
            Log.d("lol",it.level)
        }
        recycle_game.layoutManager = GridLayoutManager(this,3)
        recycle_game.adapter = adapter
    }
}
