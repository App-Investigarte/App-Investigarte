package com.app_investigarte

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_register.*
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {
    var emptyData: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val today = MaterialDatePicker.todayInUtcMilliseconds()
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecionar fecha")
                .setSelection(today)
                .build()

        btn_date.setOnClickListener {showDatePicker(datePicker)}

        controlFlujoEdt()

        datePicker.addOnPositiveButtonClickListener {
            val formatter = SimpleDateFormat("dd/MM/yyyy")
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = (datePicker.selection?.plus(100000000)!!)
            txt_date.setText(formatter.format(calendar.timeInMillis))
        }
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

    private fun controlFlujoEdt() {
        //ocular el teclado cunado se precione enter
        edt_name1.setOnKeyListener(View.OnKeyListener { view, keyCode, keyEvent ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                if(!edt_name1.text?.isEmpty()!!){
                    view.hideKeyboard()
                }
                return@OnKeyListener true
            }
            false
        })
    }

    fun View.hideKeyboard() {
        val inputManager = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }



    fun showDatePicker(datePicker: MaterialDatePicker<Long>) {
        datePicker.show(supportFragmentManager, "tag")
    }

    fun validacionCamposVacidos() {

        //validacion de la identificacion
        if(edt_id.text.toString().isEmpty()){
            lyt_id.error = getString(R.string.edt_id_error)
            edt_id.height = 5
            edt_id.setPaddingRelative(20, 7, 7, -7)
            emptyData++
        }else{
            edt_id.setPaddingRelative(20, 7, 7, 7)
            edt_id.height = 35
            lyt_id.error = null
            lyt_id.isErrorEnabled = false
        }

        //Validaciones del Correo Electronico
        if (edt_correo.text.toString().isEmpty()) {
            lyt_correo.error = "Por Favor Ingrese el Correo"
            edt_correo.height = 5
            edt_correo.setPaddingRelative(20, 7, 7, -7)
            emptyData++

        } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(edt_correo.text.toString()).matches()) {
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
        //edt_avatar.setText("")
        edt_id.setText("")
        edt_telefono.text?.clear()
    }

    fun AlertRegistroexitoso() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Felicidades")
            .setMessage("El registro del nuevo jugador a sido exitoso.")
            .setPositiveButton("Aceptar") { dialog, which -> }
            .show()
    }

}