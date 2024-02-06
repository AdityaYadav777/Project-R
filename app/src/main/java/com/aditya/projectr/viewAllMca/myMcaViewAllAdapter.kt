package com.aditya.projectr.viewAllMca

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aditya.projectr.MainActivity
import com.aditya.projectr.R
import com.aditya.projectr.models.myData
import com.aditya.projectr.viewAllMcaAct


class myMcaViewAllAdapter(val viewAllMcaAct: viewAllMcaAct, val listOfViewAll: ArrayList<myData>) :RecyclerView.Adapter<myMcaViewAllAdapter.adiViewHolder>() {
    class adiViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val title=itemView.findViewById<TextView>(R.id.myTitle)
        val desc=itemView.findViewById<TextView>(R.id.myDesc)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adiViewHolder {
        return adiViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_all_item_view_for_mca,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return listOfViewAll.size
    }

    override fun onBindViewHolder(holder: adiViewHolder, position: Int) {
     holder.title.text=listOfViewAll[position].title
        holder.desc.text=listOfViewAll[position].desc

        holder.itemView.setOnClickListener {
            val i=Intent(viewAllMcaAct,MainActivity::class.java)
            i.putExtra("link",listOfViewAll[position].link)
            viewAllMcaAct.startActivity(i)
        }
    }


}