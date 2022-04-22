package com.app_investigarte

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.app_investigarte.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {

    //implementar ViewBinding en activity
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //funcion para logiar al usuario
        //login por medio del correo y la contraseņa
        login()

        //with(){
        binding.imgBtnGoogle?.setOnClickListener {
            loginGoogle()
        }

        binding.btnRegister?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    fun login() {

        with(binding) {

            val email = edtUser?.text.toString()

            btnLogin.setOnClickListener {
                if (TextUtils.isEmpty(email)) {
                    verificacion()
                    //ponemos el foco en el editex de user
                    edtUser?.requestFocus()
                } else {
                    showWelcome(email, ProviderType.BASIC)
                }
            }
        }
    }

    fun loginGoogle() {
        //configuracion
        val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
        val googleClient = GoogleSignIn.getClient(this, googleConf)

        //deslogiamos cualquier cuneta previa que aya podido estar autenticada en ese momento
        googleClient.signOut()

        resultLauncher.launch(googleClient.signInIntent)
    }

    private var resultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(result.data)

                //creamos un try chat para caturar posibles execiones
                try {
                    //recuperamos la cuneta selecionada por el usuario
                    val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)

                    //verificamos que no sea una cuneta nula
                    if (account != null) {
                        //recuperamos la credencial de la cuenta
                        val credential: AuthCredential =
                            GoogleAuthProvider.getCredential(account.idToken, null)

                        //se envia la credencial del correo electronico de google realizando un registro de este correo
                        //si se puede registrar o ya esta registrado el task.isSuccessful retorna true y pasa al welcome,
                        //si no se puede registrar o verificar la cuenta muestra una alerta
                        //de error ya que no se pudo autenticar al usuario.
                        FirebaseAuth.getInstance().signInWithCredential(credential)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    //pasamos el welcome
                                    //showHome(account.email?: " ", ProviderType.GOOGLE)
                                    showWelcome(account.email ?: " ", ProviderType.GOOGLE)
                                } else {
                                    showAlert()
                                }
                            }
                    } else {
                        Toast.makeText(this, "Cuenta Nula", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: ApiException) {
                    e.printStackTrace()
                    showAlert()
                }
            }
        }

    private fun showWelcome(email: String, provider: ProviderType) {

        //Guardado de datos
        val prefs: SharedPreferences.Editor =
            getSharedPreferences(getString(R.string.PREFERENS), Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider.name)
        prefs.apply()

        startActivity(Intent(this, WelcomeActivity::class.java))
        super.finish()
    }

    private fun verificacion() {
        val title = "Advertencia"
        val message = "\nPor favor ingresa tu usuario."
        val btnPositive = "aceptar"
        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                btnPositive
            ) { dialogInterface: DialogInterface?, i: Int -> }
            .show()
    }


    private fun showAlert() {
        val title = "Error"
        val message = "\nSe ha produciodo un error autenticando al usuario"
        val btnPositive = "Aceptar"
        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                btnPositive
            ) { dialogInterface: DialogInterface?, i: Int -> }
            .show()
    }
}