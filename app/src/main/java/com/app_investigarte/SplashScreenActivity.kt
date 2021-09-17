package com.app_investigarte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //El metodo Thread nos permite utilizar ilos este lo nos permite con el metodo sleep detenernos o detener nuestro porgrama en un punto espesifico por milisegundos.
        //Este puede generar error por lo que lo adecuado es colocarlo dentro de un try catch
        try {
            Thread.sleep(2000) //Para deternerlo durante 2 segundos
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        startActivity(Intent(this, MainActivity::class.java))
        super.finish()//para finalizar la actividad y no quede en segundo plano avierta por detras luego de abrir la otra actividad.
    }
}