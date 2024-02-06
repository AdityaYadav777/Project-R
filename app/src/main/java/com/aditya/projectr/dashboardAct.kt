package com.aditya.projectr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.aditya.projectr.databinding.ActivityDashboardBinding
import com.aditya.projectr.fragments.bookFrag
import com.aditya.projectr.fragments.followsFrag
import com.aditya.projectr.fragments.homeFrag

class dashboardAct : AppCompatActivity() {
    lateinit var binding:ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


swapFragment(homeFrag())
        binding.myNav.setOnItemSelectedListener {

          when(it.itemId){
         R.id.myHome->swapFragment(homeFrag())
         R.id.myBookmarks->swapFragment(bookFrag())
         R.id.myFollow->swapFragment(followsFrag())

              else->{

              }

          }
            true



        }

    }
    fun swapFragment(fragment: Fragment){

        val fragmentManager=supportFragmentManager
        val manager=fragmentManager.beginTransaction()
        manager.replace(R.id.myFrame,fragment)

        manager.commit()


    }

    override fun onBackPressed() {
        super.onBackPressed()
  Toast.makeText(this,"Exits",Toast.LENGTH_SHORT).show()

    }
}