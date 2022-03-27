package com.app_investigarte

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login_2.setOnClickListener {
            startActivity(Intent(this,LoginActivity2::class.java))
        }

        btn_login.setOnClickListener {
            val iduser = edt_user.text.toString()
            if (iduser.isEmpty())
            {
                verificacion()
            }
            else
            {
                var username: String = edt_user.text.toString()
                var intent: Intent? = null
                intent = Intent(this,WelcomeActivity::class.java)
                intent.putExtra("username",username)
                startActivity(intent)
                super.finish()
            }
        }

    }
    fun verificacion() {
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
}