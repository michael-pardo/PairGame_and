package com.mistpaag.pairgame.adapter

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.model.Level
import com.mistpaag.pairgame.utils.Const
import com.mistpaag.pairgame.utils.inflate
import kotlinx.android.synthetic.main.item_game.view.*


class GameAdapter(val itemClick:(Level)-> Unit): RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    lateinit var viewHolder: ViewHolder

    val list = listOf("Holla","Hola","Holla","Hola","Holla","Hola","Holla","Hola","Holla","Hola","Holla","Hola")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Const.ultima = 10
        val view = parent.inflate(R.layout.item_game)
        val height = parent.getMeasuredHeight() / 3
        view.minimumHeight = height

        val lp = view.getLayoutParams() as GridLayoutManager.LayoutParams
        lp.height = height
        view.setLayoutParams(lp)
        return ViewHolder(view, itemClick)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        viewHolder = holder
        holder.bindView(list[position],position)
    }



    override fun getItemCount() = 8


    class ViewHolder(itemView: View, val itemClick: (Level) -> Unit):RecyclerView.ViewHolder(itemView) {

        fun bindView(level: String, position: Int){
            with(level){
                itemView.cons_image.layoutParams.height = itemView.layoutParams.height
                itemView.img_card.layoutParams.height = itemView.cons_image.layoutParams.height

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
                    itemView.img_card.load(R.drawable.cover_image) {
                        crossfade(true)
                    }
                    oa2.start()
                }
            })
            oa1.start()
        }

    }
}