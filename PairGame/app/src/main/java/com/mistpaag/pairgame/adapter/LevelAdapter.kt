package com.mistpaag.pairgame.adapter

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mistpaag.pairgame.R
import com.mistpaag.pairgame.model.Level
import com.mistpaag.pairgame.utils.inflate
import kotlinx.android.synthetic.main.item_level.view.*

class LevelAdapter(val itemClick:(Level)-> Unit): RecyclerView.Adapter<LevelAdapter.LevelFolder>() {


    val list = listOf("Holla","Hola")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelFolder {
        val view = parent.inflate(R.layout.item_level)
        return LevelFolder(view,itemClick)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: LevelFolder, position: Int) {
        holder.bindView(list[position],position)
    }

    class LevelFolder(itemView: View, val itemClick: (Level) -> Unit):RecyclerView.ViewHolder(itemView) {
        fun bindView(level: String, position: Int){
            with(level){
                itemView.btn_world.text = "World ${position + 1}"
            }
            itemView.btn_world.setOnClickListener { itemClick(Level(level="Hola$position")) }
        }

    }

}