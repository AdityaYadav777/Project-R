package com.aditya.projectr.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.projectr.databinding.FragmentBookBinding
import com.aditya.projectr.models.myData
import com.aditya.projectr.search.DataSearch
import com.aditya.projectr.search.mySearchAdapter
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class bookFrag : Fragment() {

    lateinit var binding:FragmentBookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBookBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        var   db = Firebase.firestore

        binding.btn.setOnClickListener {
            binding.progressBar2.visibility = View.VISIBLE
            val searchData = binding.mysearch.text.toString().lowercase().trim()
            db.collection("Books")
                .whereEqualTo("desc", searchData).addSnapshotListener { value, error ->
                    val listOfSearch= arrayListOf<DataSearch>()
                    val dataL=value?.toObjects(DataSearch::class.java)
                    listOfSearch.addAll(dataL!!)
                    binding.recSearch.layoutManager= LinearLayoutManager(requireContext())
                    binding.recSearch.adapter= mySearchAdapter(requireContext(),listOfSearch)
                    binding.progressBar2.visibility = View.GONE
                    binding.showError.text=""
                 if (value.isEmpty){
                     binding.showError.text="Not Found"
                     Toast.makeText(requireContext(),"Not Found",Toast.LENGTH_SHORT).show()
                 }
if(value.isEmpty){
                    db.collection("MBA")
                        .whereEqualTo("desc", searchData).addSnapshotListener { value, error ->
                            val listOfSearch = arrayListOf<DataSearch>()
                            val dataL = value?.toObjects(DataSearch::class.java)
                            listOfSearch.addAll(dataL!!)
                            binding.recSearch.layoutManager = LinearLayoutManager(requireContext())
                            binding.recSearch.adapter =
                                mySearchAdapter(requireContext(), listOfSearch)
                            binding.progressBar2.visibility = View.GONE
                            binding.showError.text=""
                            if (value.isEmpty) {
                                binding.showError.text="Not Found"
                                Toast.makeText(requireContext(), "Not Found", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }

                        }
                }
        }


        return binding.root
    }


}