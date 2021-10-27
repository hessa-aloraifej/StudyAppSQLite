package com.example.studyapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(private val activity:Activity, private val study: ArrayList<Lessons>):RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
           val data=study[position]
        holder.itemView.apply {
            textView2.text=data.name
            textView3.text=data.description
            cardview.setOnClickListener { dialogAlert(activity,data.name , "details here")
            }
            delbtn.setOnClickListener(){
               activity

            }
            editbtn.setOnClickListener {
//                activity.customAlert(data.name)
            }
        }
    }

    override fun getItemCount() = study.size

}



