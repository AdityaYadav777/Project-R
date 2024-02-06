package com.aditya.projectr.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aditya.projectr.databinding.FragmentFollowsBinding

class followsFrag : Fragment() {

    lateinit var binding:FragmentFollowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       binding=FragmentFollowsBinding.inflate(layoutInflater,container, false)


        return binding.root
    }




}