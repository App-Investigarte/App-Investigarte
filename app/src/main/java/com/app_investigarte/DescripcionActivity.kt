package com.app_investigarte

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.app_investigarte.database.DatabaseAccess
import com.app_investigarte.databinding.ActivityDescripcionBinding

class DescripcionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescripcionBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescripcionBinding.inflate(layoutInflater)

        val parametros = this.intent.extras
        val id: Int = parametros?.getInt("id") ?: 1

        val databaseAccess = DatabaseAccess.getInstance(applicationContext)
        databaseAccess.open()
        val informacionArtefacto = databaseAccess.getDescription(id)
        databaseAccess.close()

        //Cambio de tema deacuerdo a la subreguion
        SetThemeActivity.setTheme(this, informacionArtefacto[7].toInt())
        //se inserta el layout para se mostrada la vista
        setContentView(binding.root)


        //se ejecuta este bloque de codigo como  binding
        with(binding) {
            //se llenan los campos que descriven el artefacto
            //Nombre artefacto
            txtNameArtefact.text = informacionArtefacto[1]
            //Imagen del artefacto
            if (informacionArtefacto[2].equals("image")) {
                imgArtefactoDescription.setImageResource(R.drawable.ic_sombrero)
                imgArtefactoDescription.scaleType = ImageView.ScaleType.CENTER_INSIDE
                imgArtefactoDescription.setColorFilter(R.color.color_background_dark)
            }

            txtMunicipioArtifact.text = informacionArtefacto[4]
            txtSupReguionArtifact.text = informacionArtefacto[5]
            txtDepartamentoArtifact.text = (informacionArtefacto[6])
            txtDescriptionArtifact.text = (informacionArtefacto[3] + "/n" + informacionArtefacto[1] + "/n" + informacionArtefacto[1])
        }
    }
}

