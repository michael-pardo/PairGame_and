package com.mistpaag.pairgame.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.databinding.ActivityRegisterBinding
import com.mistpaag.pairgame.utils.*

import com.mistpaag.pairgame.viewmodel.RegisterVM


class RegisterActivity : AppCompatActivity() {

    lateinit var viewModel: RegisterVM
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProviders.of(this).get(RegisterVM::class.java)
        binding.viewModel = viewModel

        with(binding){

            imgAvatar.setOnClickListener {
                showDialog()
            }

            imgRankAvatar.setOnClickListener {
                showDialog()
            }

            registerBtn.setOnClickListener {
                register()
            }

        }

        viewModel.response.observe(this, Observer {
            if (it.admit){
                val intent = Intent(this, LevelActivity::class.java)
                startActivity(intent)
            }else errorToast(it.objec)
        })


    }

    fun register(){
        with(binding){
            if (nameInput.isVoid() || emailInput.isVoid()  || passwdInput.isVoid() ){
                errorToast("Fill all inputs.")
            }else{
                viewModel?.register(nameInput.getTxt(), emailInput.getTxt(), passwdInput.getTxt(), lastTag)
            }
        }
    }


    var lastTag = 0
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
        lastTag = binding.imgRankAvatar.tag.toString().toInte()


        for ((i,avatar) in imgs.withIndex()){
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
                this.tag = lastTag
                this.setImageDrawable(imgs[lastTag].drawable)
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
        lastTag = avatar.tag.toInte()

    }

    private fun errorToast(mssg:Any){
        Toast.makeText(this, mssg.toString(), Toast.LENGTH_LONG ).show()
    }
}
