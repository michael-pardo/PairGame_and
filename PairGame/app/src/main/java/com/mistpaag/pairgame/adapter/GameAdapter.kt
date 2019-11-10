package com.mistpaag.pairgame.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.model.Level
import com.mistpaag.pairgame.utils.inflate
import kotlinx.android.synthetic.main.item_game.view.*
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.animation.ObjectAnimator
import com.mistpaag.pairgame.utils.Const


class GameAdapter(val itemClick:(Level)-> Unit): RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    lateinit var viewHolder: ViewHolder

    val list = listOf("Holla","Hola","Holla","Hola","Holla","Hola","Holla","Hola","Holla","Hola","Holla","Hola")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = parent.inflate(R.layout.item_game)
        val height = parent.getMeasuredHeight() / 3

        view.minimumHeight = height
        return ViewHolder(view, itemClick)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        viewHolder = holder
        holder.bindView(list[position],position)
//        holder.itemView.minimumHeight = 300
    }



    override fun getItemCount() = 8


    class ViewHolder(itemView: View, val itemClick: (Level) -> Unit):RecyclerView.ViewHolder(itemView) {

        fun bindView(level: String, position: Int){
            with(level){
                itemView.cons_image.layoutParams.height = itemView.layoutParams.height
                itemView.img_card.layoutParams.height = itemView.cons_image.layoutParams.height
                itemView.img_card.load(R.drawable.ic_launcher_foreground) {
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_background)
                }

            }
            itemView.setOnClickListener {
                itemClick(Level(level="Hola$position"))
                if (Const.ultima == position){

                }else{
                    moverImage()
                    Const.ultima = position
                }




            }
        }

        fun moverImage(){
            val oa1 = ObjectAnimator.ofFloat(itemView.img_card, "scaleX", 1f, 0f)
            val oa2 = ObjectAnimator.ofFloat(itemView.img_card, "scaleX", 0f, 1f)
            oa1.interpolator = DecelerateInterpolator()
            oa2.interpolator = AccelerateDecelerateInterpolator()
            oa1.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    itemView.img_card.load(R.drawable.icon_facebook) {
                        crossfade(true)
                        placeholder(R.drawable.ic_launcher_background)
                    }
                    oa2.start()
                }
            })
            oa1.start()
        }

    }
}