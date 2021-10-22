package com.app_investigarte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.app_investigarte.database.DatabaseAccess

class DescripcionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion)


        val databaseAccess = DatabaseAccess.getInstance(applicationContext)
        databaseAccess.open()
        val informacionArtefacto = databaseAccess.getDescription(1);
        databaseAccess.close()

        val txtdescription =findViewById<TextView>(R.id.txtdescription)
        val txtnameartefact =findViewById<TextView>(R.id.txtnameartefact)
        val imgartefactodescripcion =findViewById<ImageView>(R.id.imgartefactodescripcion)

        txtnameartefact.setText(informacionArtefacto[1])
        txtdescription.setText(informacionArtefacto[3])
        //imgartefactodescripcion.setImageDrawable(informacionArtefacto[2])



    }
}