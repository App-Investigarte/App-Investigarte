package com.app_investigarte

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_login2.*
import java.util.*

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

        val today = MaterialDatePicker.todayInUtcMilliseconds()

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Seleccionar fecha")
                .setSelection(today)
                .build()
        btn_date.setOnClickListener {
            datePicker.show(supportFragmentManager, "tag");
        }
        datePicker.addOnPositiveButtonClickListener {
            // txt_date.setText(datePicker.headerText)

            val formatter = SimpleDateFormat("dd/MM/yyyy")
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = (datePicker.selection?.plus(100000000)!!)
            txt_date.setText(formatter.format(calendar.timeInMillis))
        }


    }
}