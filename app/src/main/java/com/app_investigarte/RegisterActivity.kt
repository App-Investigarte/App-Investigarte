package com.app_investigarte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login2.*

class RegisterActivity : AppCompatActivity() {

    var emptyData: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        controlFlujoedt()

        btn_register.setOnClickListener {
            emptyData = 0
            validacionCamposVacidos()
            //Registro de usuario
            if (emptyData == 0) {
                AlertRegistroexitoso()
                clearDataEdt()
            }
        }
    }


    fun controlFlujoedt() {

        edt_estado_civil.setOnKeyListener(View.OnKeyListener { view, keyCode, keyEvent ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                if (!edt_estado_civil.text.toString().isEmpty()) {
                    edt_telefono.requestFocus()
                }
                return@OnKeyListener true
            }
            false
        })


    }

    fun validacionCamposVacidos() {
        //Validaciones del Correo Electronico
        val correo = edt_correo.text.toString()
        if (correo.isEmpty()) {
            lyt_correo.error = "Por Favor Ingrese el Correo"
            edt_correo.height = 5
            edt_correo.setPaddingRelative(20, 7, 7, -7)
            emptyData++

        } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(correo).matches()) {
            //se verifica qeuse aya escrito un correo electronico valido
            lyt_correo.error = "Por Favor Ingrese un Correo valido"
            edt_correo.height = 5
            edt_correo.setPaddingRelative(20, 7, 7, -7)
            emptyData++
        } else {
            edt_correo.setPaddingRelative(20, 7, 7, 7)
            edt_correo.height = 35
            lyt_correo.error = null
            lyt_correo.isErrorEnabled = false
        }

        //Validaciones del Nombre
        if (edt_name1.text.toString().isEmpty()) {
            lyt_name1.error = "Ingrese el Nombre completo"
            edt_name1.height = 5
            edt_name1.setPaddingRelative(20, 7, 7, -7)
            emptyData++
        } else {
            edt_name1.setPaddingRelative(20, 7, 7, 7)
            edt_name1.height = 35
            lyt_name1.error = null
            lyt_name1.isErrorEnabled = false
        }
/*
        //Validaciones del Apellido
        if (edt_apellido.text.toString().isEmpty()) {
            lyt_apellido.error = "Ingrese el Apellido completo"
            edt_apellido.height = 5
            edt_apellido.setPaddingRelative(20, 7, 7, -7)
            emptyData++
        } else {
            edt_apellido.setPaddingRelative(20, 7, 7, 7)
            edt_apellido.height = 35
            lyt_apellido.error = null
            lyt_apellido.isErrorEnabled = false
        }
*/
    }

    fun clearDataEdt() {
        edt_correo.setText("")
        edt_name1.setText("")
       // edt_apellido.setText("")
        edt_estado_civil.setText("")
        edt_direccion.setText("")
        edt_telefono.text?.clear()
    }

    fun AlertRegistroexitoso() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Felicidades")
            .setMessage("El registro del nuevo Cliente a sido exitoso.")
            .setPositiveButton("Aceptar") { dialog, which -> }
            .show()
    }

}