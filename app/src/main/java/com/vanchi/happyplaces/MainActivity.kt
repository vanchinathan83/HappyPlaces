package com.vanchi.happyplaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vanchi.happyplaces.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.fabAddHappyPlace?.setOnClickListener{
            val addPlaceIntent = Intent(this,  AddHappyPlaceActivity::class.java)
            startActivity(addPlaceIntent)
        }
    }
}