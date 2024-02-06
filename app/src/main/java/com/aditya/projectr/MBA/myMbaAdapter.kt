package com.aditya.projectr.MBA

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

class myMbaAdapter(val requireContext: Context, val listOfMba: ArrayList<myData>) :RecyclerView.Adapter<myMbaAdapter.myViewHolder>() {

    inner class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
     val title=itemView.findViewById<TextView>(R.id.titileLoad)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return listOfMba.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.title.text=listOfMba[position].title
        holder.itemView.setOnClickListener {
            val i=Intent(requireContext,MainActivity::class.java)
            i.putExtra("link",listOfMba[position].link)
            requireContext.startActivity(i)
        }

    }

}