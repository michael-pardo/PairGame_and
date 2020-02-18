package com.mistpaag.pairgame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.databinding.ActivityRegisterBinding
import com.mistpaag.pairgame.viewmodel.MainVM
import com.mistpaag.pairgame.viewmodel.RegisterVM

class RegisterActivity : AppCompatActivity() {

    lateinit var registerVM: RegisterVM
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        registerVM = ViewModelProviders.of(this).get(RegisterVM::class.java)
    }
    fun register(){

    }
}
