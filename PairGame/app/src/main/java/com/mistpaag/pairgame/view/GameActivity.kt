package com.mistpaag.pairgame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil‰
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.adapter.GameAdapter
import com.mistpaag.pairgame.databinding.ActivityGameBinding
import com.mistpaag.pairgame.viewmodel.GameVM
import com.mistpaag.pairgame.viewmodel.GameVMFactory

class GameActivity : AppCompatActivity() {

    lateinit var gameVM: GameVM
    lateinit var gameVMFactory: GameVMFactory
    lateinit var adapter: GameAdapter
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)
        gameVMFactory = GameVMFactory(intent.getStringArrayExtra("lista"))
        gameVM = ViewModelProviders.of(this).get(GameVM::class.java)

        val imagen1 = intent.getStringArrayExtra("lista")
        for (i in imagen1) Log.d("lol",i.toString())

        adapter = GameAdapter(){
            Log.d("lol",it.level)
        }
        binding.recycleGame.layoutManager = GridLayoutManager(this,3)
        binding.recycleGame.adapter = adapter
    }
}
