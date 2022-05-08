package com.app_investigarte


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref: SharedPreferences = getSharedPreferences(getString(R.string.PREFERENS), Context.MODE_PRIVATE)
        val email = sharedPref.getString("email", null)


        //El metodo Thread nos permite utilizar ilos este lo nos permite con el metodo sleep detenernos o detener nuestro porgrama en un punto espesifico por milisegundos.
        //Este puede generar error por lo que lo adecuado es colocarlo dentro de un try catch
        try {
            Thread.sleep(3000) //Para deternerlo durante 3 segundos
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        if (email != null) {
            startActivity(Intent(this, WelcomeActivity::class.java))
            overridePendingTransition(R.anim.slide_in,R.anim.slide_out)
            super.finish()//para finalizar la actividad y no quede en segundo plano avierta por detras luego de abrir la otra actividad.

        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.slide_in,R.anim.slide_out)
            super.finish()//para finalizar la actividad y no quede en segundo plano avierta por detras luego de abrir la otra actividad.
        }

    }

}