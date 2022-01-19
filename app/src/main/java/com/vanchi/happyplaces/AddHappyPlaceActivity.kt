package com.vanchi.happyplaces

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vanchi.happyplaces.databinding.ActivityAddHappyPlaceBinding
import java.text.SimpleDateFormat
import java.util.*

class AddHappyPlaceActivity : AppCompatActivity(), View.OnClickListener {
    var binding: ActivityAddHappyPlaceBinding? = null
    private var calendar = Calendar.getInstance()
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener
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
        dateSetListener = DatePickerDialog.OnDateSetListener{
            view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }
        binding?.etDate?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding?.etDate?.id -> {
                DatePickerDialog(this,
                    dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
    }

    private fun updateDateInView(){
        val dateFormat = "MM/DD/yyyy"
        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
        binding?.etDate?.setText(simpleDateFormat.format(calendar.time).toString())
    }
}