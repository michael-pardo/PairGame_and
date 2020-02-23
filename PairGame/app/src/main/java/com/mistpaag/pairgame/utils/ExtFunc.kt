package com.mistpaag.pairgame.utils

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText
import com.mistpaag.pairgame.R

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

fun ImageView.toGray(){
    this.setColorFilter(this.context.resources.getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
}

fun ImageView.toNormal(){
    this.setColorFilter(this.context.resources.getColor(R.color.invisible), PorterDuff.Mode.SRC_ATOP);
}

fun Any.toInte(): Int {
    return this.toString().toInt()
}

fun TextInputEditText.isVoid(): Boolean = this.text?.isEmpty()!!

fun TextInputEditText.getTxt(): String = this.text.toString()