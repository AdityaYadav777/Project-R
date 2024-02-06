package com.aditya.projectr.search

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aditya.projectr.MainActivity
import com.aditya.projectr.R

class mySearchAdapter(val requireContext: Context,val listOfSearch: ArrayList<DataSearch>) :RecyclerView.Adapter<mySearchAdapter.myViewHolder>() {

    inner class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
val title=itemView.findViewById<TextView>(R.id.titileLoad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return listOfSearch.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
       holder.title.text=listOfSearch[position].title
        holder.itemView.setOnClickListener {
            val i=Intent(requireContext,MainActivity::class.java)
            i.putExtra("link",listOfSearch[position].link)
            requireContext.startActivity(i)
        }
    }
}