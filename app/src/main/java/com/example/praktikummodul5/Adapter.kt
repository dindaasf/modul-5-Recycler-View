package com.example.praktikummodul5

import android.annotation.SuppressLint
import android.content.Context
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*
import java.text.FieldPosition

class Adapter (private val list:ArrayList<User>) : RecyclerView.Adapter<Adapter.Holder>(){
    var context: Context?=null
    var clickListener : OnClickListener? =null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list,parent, false))
    }
    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: Holder, position: Int){
        holder.view.textView.text = list.get(position).name
        holder.view.halo.setText("Halo")
        holder.view.setOnClickListener({v -> clickListener?.onClick(position)})
    }
    fun setOnClickListener (listener : (Int)-> Unit) {
        this.clickListener = object : OnClickListener {
            override fun onClick(position: Int) {
                listener(position)
            }
        }
    }
    class Holder(val view: View) : RecyclerView.ViewHolder(view)

    interface OnClickListener{
        fun onClick(position: Int)
    }
    }

