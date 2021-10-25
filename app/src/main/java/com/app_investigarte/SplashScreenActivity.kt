package com.app_investigart

import com.app_investigarte.LoginActivity
import com.app_investigarte.WelcomeActivity


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prefs: SharedPreferences = getSharedPreferences("PREFERENS_USER", 0)
        val nombredevariable = prefs.getString("NAME_USER", "")

        //El metodo Thread nos permite utilizar ilos este lo nos permite con el metodo sleep detenernos o detener nuestro porgrama en un punto espesifico por milisegundos.
        //Este puede generar error por lo que lo adecuado es colocarlo dentro de un try catch
        try {
            Thread.sleep(3000) //Para deternerlo durante 3 segundos
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        if(nombredevariable?.length ?:0>0){

            var username = nombredevariable
            var intent: Intent? = null
            intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
            super.finish()//para finalizar la actividad y no quede en segundo plano avierta por detras luego de abrir la otra actividad.

        }else {
            startActivity(Intent(this, LoginActivity::class.java))
            super.finish()//para finalizar la actividad y no quede en segundo plano avierta por detras luego de abrir la otra actividad.
        }


    }
}