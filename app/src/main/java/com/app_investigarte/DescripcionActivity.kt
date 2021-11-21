package com.app_investigarte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.app_investigarte.ListadoArtefactos.ConvertirIMGBase64
import com.app_investigarte.database.DatabaseAccess
import kotlinx.android.synthetic.main.activity_descripcion.*

class DescripcionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion)

        val parametros = this.intent.extras
        val id: Int = parametros?.getInt("id") ?: 1

        val databaseAccess = DatabaseAccess.getInstance(applicationContext)
        databaseAccess.open()
        val informacionArtefacto = databaseAccess.getDescription(id);
        databaseAccess.close()

        val imgartefactodescripcion =findViewById<ImageView>(R.id.img_artefacto_description)


        txt_name_artefact.setText(informacionArtefacto[1])
        if(informacionArtefacto[2] == null){
            img_artefacto_description.setImageResource(R.drawable.sombrero);
        }else{
            img_artefacto_description.setImageBitmap (
                ConvertirIMGBase64.convertirAimagen(
                    informacionArtefacto[2]
                )
            );
        }
        txt_description_artifact.setText(informacionArtefacto[3]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1]+"/n"+informacionArtefacto[1])
        txt_municipio_artifact.setText(informacionArtefacto[4])
        txt_sup_reguion_artifact.setText(informacionArtefacto[5])
        txt_departamento_artifact.setText(informacionArtefacto[6])

    }
}

