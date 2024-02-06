package com.aditya.projectr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isNotEmpty

import androidx.lifecycle.lifecycleScope
import com.aditya.projectr.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

 val link=intent.getStringExtra("link")

if(link!!.isEmpty()){
    Toast.makeText(this,"Link is not Complete",Toast.LENGTH_SHORT).show()
    startActivity(Intent(this,dashboardAct::class.java))
}else {


    binding.pdfView.initWithUrl(
        url = link.toString(),
        lifecycleCoroutineScope = lifecycleScope,
        lifecycle = lifecycle

    )


}

    }
}