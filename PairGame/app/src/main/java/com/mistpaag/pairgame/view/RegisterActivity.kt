package com.mistpaag.pairgame.view

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.databinding.ActivityRegisterBinding
import com.mistpaag.pairgame.utils.toGray
import com.mistpaag.pairgame.utils.toInte

import com.mistpaag.pairgame.utils.toNormal
import com.mistpaag.pairgame.viewmodel.RegisterVM


class RegisterActivity : AppCompatActivity() {

    lateinit var registerVM: RegisterVM
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        registerVM = ViewModelProviders.of(this).get(RegisterVM::class.java)

        binding.imgAvatar.setOnClickListener {
            showDialog()
        }

        binding.imgRankAvatar.setOnClickListener {
            showDialog()
        }
    }

    fun register(){
        val lol = "lol"
    }


    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.avatar_dialog)
        val ava1 = dialog.findViewById(R.id.avatar1_ima) as ImageView
        val ava2 = dialog.findViewById(R.id.avatar2_ima) as ImageView
        val ava3 = dialog.findViewById(R.id.avatar3_ima) as ImageView
        val ava4 = dialog.findViewById(R.id.avatar4_ima) as ImageView
        val imgs = listOf(ava1, ava2, ava3, ava4)
        var lastTag = binding.imgRankAvatar.tag.toString().toInte()


        for ((i,avatar) in imgs.withIndex()){
            Log.d("lol","${binding.imgRankAvatar.tag}, $i")
            if (i == lastTag ){
                avatar.toNormal()
                lastTag = i
            }else{
                avatar.toGray()
            }
        }

        val yesBtn = dialog .findViewById(R.id.select_btn) as Button
        ava1.setOnClickListener {drawImage(ava1, imgs[lastTag])}
        ava2.setOnClickListener {drawImage(ava2, imgs[lastTag])}
        ava3.setOnClickListener {drawImage(ava3, imgs[lastTag])}
        ava4.setOnClickListener {drawImage(ava4, imgs[lastTag])}
        yesBtn.setOnClickListener {
            with(binding.imgRankAvatar){
                this.setImageDrawable(imgs[this.tag.toInte()].drawable)
                dialog .dismiss()
            }

        }
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.getWindow()?.getAttributes())
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        dialog.window?.attributes =  lp
        dialog.show()

    }

    private fun drawImage(avatar: ImageView, imageView: ImageView) {
        imageView.toGray()
        avatar.toNormal()
        binding.imgRankAvatar.tag = avatar.tag.toInte()
    }
}
