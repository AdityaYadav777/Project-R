package com.aditya.projectr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.projectr.databinding.ActivityViewAllMcaBinding
import com.aditya.projectr.fragments.homeFrag
import com.aditya.projectr.models.myData
import com.aditya.projectr.viewAllMca.myMcaViewAllAdapter
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class viewAllMcaAct : AppCompatActivity() {
    lateinit var binding:ActivityViewAllMcaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewAllMcaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener {
            startActivity(Intent(this, homeFrag::class.java))
        }

        val getKey=intent.getStringExtra("key")
        val title=intent.getStringExtra("title")


      val db=Firebase.firestore

        if(getKey=="1") {
 binding.getMyTitle.text=title
            db.collection("Books").addSnapshotListener { value, error ->

                val listOfViewAll = arrayListOf<myData>()
                val data = value?.toObjects(myData::class.java)
                listOfViewAll.addAll(data!!)
                binding.mcaViewAllRec.layoutManager = LinearLayoutManager(this)
                binding.mcaViewAllRec.adapter = myMcaViewAllAdapter(this, listOfViewAll)
            }
        }
 if(getKey=="2") {
     binding.getMyTitle.text=title
    db.collection("MBA").addSnapshotListener { value, error ->

        val listOfViewAll = arrayListOf<myData>()
        val data = value?.toObjects(myData::class.java)
        listOfViewAll.addAll(data!!)
        binding.mcaViewAllRec.layoutManager = LinearLayoutManager(this)
        binding.mcaViewAllRec.adapter = myMcaViewAllAdapter(this, listOfViewAll)
    }
}




    }
}