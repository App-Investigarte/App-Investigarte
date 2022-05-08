package com.app_investigarte

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
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

        //ago una intacion del sonido pop.mp3
        val pop = MediaPlayer.create(this, R.raw.pop)

        //se recuperan los datos de usuario logeado
        val pref = getSharedPreferences(getString(R.string.PREFERENS), MODE_PRIVATE)
        val email = pref.getString("email","")
        val name = pref.getString("name", "")
        val provider = pref.getString("provider", "")

        if (provider != null) {
            if(provider.equals(ProviderType.GOOGLE.toString())){
                binding.txtusername.text = email
            }else{
                binding.txtusername.text = name
            }
        }



        //pasar de activity al precionar el boton.
        binding.btnStart.setOnClickListener { view: View? ->
            pop.start()
            startActivity(Intent(this, NavDrawerActivity::class.java))
            overridePendingTransition(R.anim.slide_in,R.anim.slide_out)
            super.finishAffinity()
        }
    }
}