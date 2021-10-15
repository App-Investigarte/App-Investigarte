package com.app_investigarte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app_investigarte.database.DatabaseAccess

class DescripcionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion)


        val databaseAccess = DatabaseAccess.getInstance(applicationContext)
        databaseAccess.open()
        val informacionArtefacto = databaseAccess.getDescription(1);
        databaseAccess.close()


    }
}