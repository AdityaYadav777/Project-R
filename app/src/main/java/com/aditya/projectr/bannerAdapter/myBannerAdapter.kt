package com.aditya.projectr.bannerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aditya.projectr.R

class myBannerAdapter(val requireContext: Context,val  listOfBanners: ArrayList<myBannerData>) :RecyclerView.Adapter<myBannerAdapter.myViewHolder>() {

    inner class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val imgBanner=itemView.findViewById<ImageView>(R.id.bannerImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       return myViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.item_banner,parent,false)
       )
    }

    override fun getItemCount(): Int {
        return listOfBanners.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
      holder.imgBanner.load(listOfBanners[position].link)
    }
}