package com.app_investigarte

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import com.app_investigarte.database.DatabaseAccess
import com.app_investigarte.databinding.ActivityRegisterBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {
    var emptyData: Int = 0

    private lateinit var binding: ActivityRegisterBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ago una intacion del sonido pop.mp3
        val pop = MediaPlayer.create(this, R.raw.pop)

        val today = MaterialDatePicker.todayInUtcMilliseconds()
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecionar fecha")
                .setSelection(today)
                .build()

        binding.btnDate.setOnClickListener {
            pop.start();
            showDatePicker(datePicker)
        }

        controlFlujoEdt()

        datePicker.addOnPositiveButtonClickListener {
            val formatter = SimpleDateFormat("dd/MM/yyyy")
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = (datePicker.selection?.plus(100000000)!!)
            binding.txtDate.text = formatter.format(calendar.timeInMillis)
        }
        binding.btnRegister.setOnClickListener {
            pop.start();
            emptyData = 0
            validacionCamposVacidos()
            //Registro de usuario
            if (emptyData == 0) {
                registerUser()
            }
        }
    }

    private fun controlFlujoEdt() {

        //ocular el teclado cunado se precione enter
        with(binding) {
            edtName1.setOnKeyListener(View.OnKeyListener { view, keyCode, keyEvent ->
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (edtName1.text?.isNotEmpty()!!) {
                        view.hideKeyboard()
                    }
                    return@OnKeyListener true
                }
                false
            })
        }
    }

    private fun View.hideKeyboard() {
        val inputManager =
            this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun showDatePicker(datePicker: MaterialDatePicker<Long>) {
        datePicker.show(supportFragmentManager, "tag")
    }

    private fun validacionCamposVacidos() {

        with(binding) {
            //validacion de la identificacion
            if (edtId.text.toString().isEmpty()) {
                lytId.error = getString(R.string.edt_id_error)
                edtId.height = 5
                edtId.setPaddingRelative(20, 7, 7, -7)
                emptyData++
            } else {
                edtId.setPaddingRelative(20, 7, 7, 7)
                edtId.height = 35
                lytId.error = null
                lytId.isErrorEnabled = false
            }

            //Validaciones del Correo Electronico
            if (edtCorreo.text.toString().isEmpty()) {
                lytCorreo.error = "Por Favor Ingrese el Correo"
                edtCorreo.height = 5
                edtCorreo.setPaddingRelative(20, 7, 7, -7)
                emptyData++

            } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(edtCorreo.text.toString())
                    .matches()
            ) {
                //se verifica qeuse aya escrito un correo electronico valido
                lytCorreo.error = "Por Favor Ingrese un Correo valido"
                edtCorreo.height = 5
                edtCorreo.setPaddingRelative(20, 7, 7, -7)
                emptyData++
            } else {
                edtCorreo.setPaddingRelative(20, 7, 7, 7)
                edtCorreo.height = 35
                lytCorreo.error = null
                lytCorreo.isErrorEnabled = false
            }

            //Validaciones del Nombre
            if (edtName1.text.toString().isEmpty()) {
                lytName1.error = "Ingrese el Nombre completo"
                edtName1.height = 5
                edtName1.setPaddingRelative(20, 7, 7, -7)
                emptyData++
            } else {
                edtName1.setPaddingRelative(20, 7, 7, 7)
                edtName1.height = 35
                lytName1.error = null
                lytName1.isErrorEnabled = false
            }
        }
    }

    private fun clearDataEdt() {
        with(binding) {
            edtCorreo.setText("")
            edtName1.setText("")
            edtId.setText("")
            //edtTelefono.text?.clear()
            txtDate.setText("")
        }
    }

    private fun AlertRegistroexitoso(email:String, name:String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Felicidades")
            .setMessage("El registro del nuevo jugador a sido exitoso.")
            .setPositiveButton("Aceptar") { dialog, which -> showWelcome(email,name,ProviderType.BASIC)}
            .show()
    }

    private fun AlertRegistroUserExiste() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage("El Usurio ingresado ya esta registrado.")
            .setPositiveButton("Aceptar") { dialog, which -> }
            .show()
    }

    private fun registerUser() {

        val databaseAcces: DatabaseAccess = DatabaseAccess.getInstance(this)
        databaseAcces.open()
        with(binding) {
            val id: String = edtId.text.toString()
            val email: String = edtCorreo.text.toString()
            val name: String = edtName1.text.toString()
            var phone = "0"
            var date = " "
            /*
            if (edtTelefono.text?.isNotEmpty()!!) {
                phone = edtTelefono.text.toString()
            }*/

            if (txtDate.text.isNotEmpty()) {
                date = txtDate.text.toString()
            }

            val userExiste: Int = databaseAcces.getUserExistencia(id.toLong())
            if (userExiste == 0) {
                val emailexiste = databaseAcces.getUserCorreoExiste(email)
                if (emailexiste[0].toInt() == 0) {
                    databaseAcces.addUser(id, email, name, phone, date)
                    clearDataEdt()
                    AlertRegistroexitoso(email,name)
                } else {
                    //el usuario ya existe en la base de datos
                    AlertRegistroUserExiste()
                    lytCorreo.error = getString(R.string.correo_existe)
                    edtCorreo.setPaddingRelative(20, 7, 7, -7)
                }
            } else {
                //el usuario ya existe en la abse de datos
                AlertRegistroUserExiste()
                lytId.error = getString(R.string.user_existe)
                edtId.setPaddingRelative(20, 7, 7, -7)

            }
        }
        databaseAcces.close()
    }

    private fun showWelcome(email: String, name: String, provider: ProviderType) {
        //Guardado de datos
        val prefs: SharedPreferences.Editor =
            getSharedPreferences(getString(R.string.PREFERENS), Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider.name)
        prefs.putString("name", name)
        prefs.apply()

        startActivity(Intent(this, WelcomeActivity::class.java))
        super.finish()
    }

}