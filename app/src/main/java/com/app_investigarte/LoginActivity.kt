package com.app_investigarte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login_2.setOnClickListener {
            startActivity(Intent(this,LoginActivity2::class.java))
        }

        btn_login.setOnClickListener {
            var username: String = et1.text.toString()
            var intent: Intent? = null
            intent = Intent(this,WelcomeActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
            super.finish()
        }


    }
}