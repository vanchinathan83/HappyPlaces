package com.vanchi.happyplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vanchi.happyplaces.databinding.ActivityAddHappyPlaceBinding

class AddHappyPlaceActivity : AppCompatActivity() {
    var binding: ActivityAddHappyPlaceBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddHappyPlaceBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarAddPlace)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarAddPlace?.setNavigationOnClickListener{
            onBackPressed()
        }
    }
}