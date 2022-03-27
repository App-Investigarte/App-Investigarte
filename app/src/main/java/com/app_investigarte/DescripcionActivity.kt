package com.app_investigarte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.app_investigarte.database.DatabaseAccess
import kotlinx.android.synthetic.main.activity_descripcion.*

class DescripcionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion)

        val parametros = this.intent.extras
        //jaghuagaiuvakuava
        val id: Int = parametros?.getInt("id") ?: 1

        val databaseAccess = DatabaseAccess.getInstance(applicationContext)
        databaseAccess.open()
        val informacionArtefacto = databaseAccess.getDescription(id);
        databaseAccess.close()

        val imgartefactodescripcion =findViewById<ImageView>(R.id.img_artefacto_description)


        txt_name_artefact.setText(informacionArtefacto[1])
        if(informacionArtefacto[2].equals("image")){
            img_artefacto_description.setImageResource(R.drawable.ic_sombrero)
            img_artefacto_description.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
        }

        txt_description_artifact.setText(informacionArtefacto[3]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1])
        txt_municipio_artifact.setText(informacionArtefacto[4])
        txt_sup_reguion_artifact.setText(informacionArtefacto[5])
        txt_departamento_artifact.setText(informacionArtefacto[6])

    }
}

