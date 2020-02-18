package com.mistpaag.pairgame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.databinding.ActivityRankingBinding
import com.mistpaag.pairgame.viewmodel.RankingVM

class RankingActivity : AppCompatActivity() {

    lateinit var binding : ActivityRankingBinding
    lateinit var viewModel : RankingVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(RankingVM::class.java)
    }
}
