package com.app_investigarte

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.app_investigarte.database.DatabaseAccess
import com.app_investigarte.databinding.ActivityDescripcionBinding
import com.app_investigarte.databinding.ShowImgDialogBinding


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
            } else {
                val img = resources.getIdentifier(
                    "@drawable/art_${informacionArtefacto[2]}",
                    "drawable",
                    packageName
                )
                imgArtefactoDescription.setImageResource(img)
                imgArtefactoDescription.scaleType = ImageView.ScaleType.CENTER_CROP


                binding.imgArtefactoDescription.setOnClickListener {
                    showImgDialog(img)
                }

            }

            txtMunicipioArtifact.text = informacionArtefacto[4]
            txtSupReguionArtifact.text = informacionArtefacto[5]
            txtDepartamentoArtifact.text = (informacionArtefacto[6])
            txtCommunityArtifact!!.text = informacionArtefacto[8]
            txtArtisanClassificationArtifact!!.text = informacionArtefacto[9]
            txtClothingCategoryArtifact!!.text = informacionArtefacto[10]
            txtPatrimonialCategoryArtifact!!.text = informacionArtefacto[11]
            txtDescriptionArtifact.text = informacionArtefacto[3]
        }
    }

    private fun showImgDialog(img_art: Int) {

        //reproducimos el sonido de Pop
        val POP = MediaPlayer.create(this, R.raw.pop)
        POP.start()

        val binding2: ShowImgDialogBinding = ShowImgDialogBinding.inflate(layoutInflater)

        binding2.imgArt.setImageResource(img_art)

        val dialog: Dialog = Dialog(this)
        dialog.setContentView(binding2.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setWindowAnimations(R.style.AnimationsForDialog)
        dialog.show()

      //  imgArtefactoDescription.scaleType = ImageView.ScaleType.CENTER_CROP

        binding2.imgArt.setOnClickListener{
            //para cerrar el dialogo
            dialog.dismiss()
        }
    }
}

