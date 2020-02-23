package com.mistpaag.pairgame.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.databinding.ActivityMainBinding
import com.mistpaag.pairgame.model.Response
import com.mistpaag.pairgame.viewmodel.MainVM
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainVM
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainVM::class.java)
        FirebaseApp.initializeApp(this)

        binding.bntLogin.setOnClickListener {
//            mainVM.login(binding.u`ser)
//
            viewModel.login()

        }

        binding.txtRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.viewModel = viewModel

        viewModel.response.observe(this, Observer {
            if (it.admit){
                val intent = Intent(this, LevelActivity::class.java)
                startActivity(intent)
            }else Toast.makeText(this, it.objec.toString(), Toast.LENGTH_LONG).show()
        })










    }




}
