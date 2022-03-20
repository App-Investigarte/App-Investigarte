package com.app_investigarte

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.app_investigarte.databinding.ActivityLogin2Binding
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_login2.*

class LoginActivity2 : AppCompatActivity() {

    /*private lateinit var binding:ActivityLogin2Binding*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        //DropdownMenu
/*        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dias = resources.getStringArray(R.array.dias)
        val adapter = ArrayAdapter(this,R.layout.dropdownmenu_dias,dias)

        with(binding.autocompletetxtdias){
            setAdapter(adapter)
        }*/

        btn_back.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Seleccionar fecha")
                .build()
        btn_date.setOnClickListener {
            datePicker.show(supportFragmentManager, "tag");
        }
        datePicker.addOnPositiveButtonClickListener {
            var date = datePicker.selection.toString()
            txt_date.setText(date)
            // Respond to positive button click.
        }


    }
}