package com.aditya.projectr.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aditya.projectr.MainActivity
import com.aditya.projectr.R
import com.aditya.projectr.models.myData

class myAdapter(val requireContext: Context,val  listOfBooks: ArrayList<myData>) :RecyclerView.Adapter<myAdapter.myViewHolder>() {

    inner class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val myTitle=itemView.findViewById<TextView>(R.id.titileLoad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return listOfBooks.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
       holder.myTitle.text=listOfBooks[position].title

        holder.itemView.setOnClickListener {
            val i=Intent(requireContext, MainActivity::class.java)
            i.putExtra("link",listOfBooks[position].link)
            requireContext.startActivity(i)
        }
    }
}