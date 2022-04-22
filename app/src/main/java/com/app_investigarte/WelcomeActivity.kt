package com.app_investigarte

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app_investigarte.databinding.ActivityWelcomeBinding


class WelcomeActivity : AppCompatActivity() {


    //implementar ViewBinding en activity
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pref = getSharedPreferences(getString(R.string.PREFERENS), MODE_PRIVATE)
        val email = pref.getString("email","")
        val name = pref.getString("name", "")

        binding.txtusername.text = name


        //pasar de activity al precionar el boton.
        binding.btnStart.setOnClickListener { view: View? ->
            startActivity(Intent(this, NavDrawerActivity::class.java))
            super.finishAffinity()
        }
    }
}