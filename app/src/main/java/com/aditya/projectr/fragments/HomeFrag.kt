package com.aditya.projectr.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.projectr.adapter.myAdapter
import com.aditya.projectr.bannerAdapter.myBannerAdapter
import com.aditya.projectr.bannerAdapter.myBannerData
import com.aditya.projectr.databinding.FragmentHomeBinding
import com.aditya.projectr.models.myData
import com.aditya.projectr.search.DataSearch
import com.aditya.projectr.search.mySearchAdapter
import com.aditya.projectr.viewAllMcaAct
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class homeFrag : Fragment() {

    lateinit var binding:FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)


        var   db = Firebase.firestore


        db.collection("Banners").addSnapshotListener { value, error ->
            val listOfBanners = arrayListOf<myBannerData>()
            val dataBanners = value?.toObjects(myBannerData::class.java)
            listOfBanners.addAll(dataBanners!!)
            if (isAdded){
                binding.bannerRec.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                binding.bannerRec.adapter= myBannerAdapter(requireContext(),listOfBanners)
            }
        }

        db.collection("Books").addSnapshotListener { value, error ->
         val   listOfBooks=arrayListOf<myData>()
            val data=value?.toObjects(myData::class.java)
            listOfBooks.addAll(data!!)
if (isAdded){
    binding.myRec.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    binding.myRec.adapter= myAdapter(requireContext(),listOfBooks)
 }

        }


binding.viewAllList.setOnClickListener {

    startActivity(Intent(requireContext(),viewAllMcaAct::class.java))
}



        return binding.root
    }


    }
