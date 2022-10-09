package com.app_investigarte

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
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
        //se inserta el layout para ser mostrada la vista
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
                imgArtefactoDescription.scaleType = ImageView.ScaleType.FIT_XY


                binding.imgArtefactoDescription.setOnClickListener {
                    showImgDialog(img)
                }

            }

            txtMunicipioArtifact.text = informacionArtefacto[4]



            if (informacionArtefacto[5].equals("Sin definer")) {
                txtSupReguionArtifact.visibility = View.GONE
                txtSupReguion!!.visibility = View.GONE
            }
            txtSupReguionArtifact.text = informacionArtefacto[5]

            txtDepartamentoArtifact.text = (informacionArtefacto[6])


            if (informacionArtefacto[8].equals("Sin definer")) {
                txtCommunityArtifact!!.visibility = View.GONE
                txtCommunity!!.visibility = View.GONE
            }
            txtCommunityArtifact!!.text = informacionArtefacto[8]

            if (informacionArtefacto[9].equals("Sin definer")) {
                txtArtisanClassificationArtifact!!.visibility = View.GONE
                txtArtisanClassification!!.visibility = View.GONE
            }
            txtArtisanClassificationArtifact!!.text = informacionArtefacto[9]

            if (informacionArtefacto[10].equals("Sin definer")) {
                txtClothingCategoryArtifact!!.visibility = View.GONE
                txtClothingCategory!!.visibility = View.GONE
            }
            txtClothingCategoryArtifact!!.text = informacionArtefacto[10]

            if (informacionArtefacto[11].equals("Sin definer")) {
                txtPatrimonialCategoryArtifact!!.visibility = View.GONE
                txtPatrimonialCategory!!.visibility = View.GONE
            }
            txtPatrimonialCategoryArtifact!!.text = informacionArtefacto[11]

            if (informacionArtefacto[12].equals("")) {
                txtMaterialsArtifact!!.visibility = View.GONE
                txtMaterials!!.visibility = View.GONE
            }
            txtMaterialsArtifact!!.text = informacionArtefacto[12]

            if (informacionArtefacto[3].equals("")) {
                txtDescriptionArtifact!!.visibility = View.GONE
                txtDescription!!.visibility = View.GONE
            }
            txtDescriptionArtifact.text = informacionArtefacto[3]
        }
    }

    private fun showImgDialog(img_art: Int) {

        //reproducimos el sonido de Pop
        val POP = MediaPlayer.create(this, R.raw.pop)
        POP.start()

        val binding2: ShowImgDialogBinding = ShowImgDialogBinding.inflate(layoutInflater)

        binding2.imgArt.setImageResource(img_art)
        binding2.imgArt.scaleType = ImageView.ScaleType.FIT_XY
        val dialog: Dialog = Dialog(this)
        dialog.setContentView(binding2.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setWindowAnimations(R.style.AnimationsForDialog)
        dialog.show()

        //  imgArtefactoDescription.scaleType = ImageView.ScaleType.CENTER_CROP

        binding2.imgArt.setOnClickListener {
            //para cerrar el dialogo
            dialog.dismiss()
        }
    }
}

