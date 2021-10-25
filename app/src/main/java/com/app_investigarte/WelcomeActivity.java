package com.app_investigarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    public Button btnStart;
    public Intent intent;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        /* SharedPreferences preferencia =
                getSharedPreferences("PREFERENS_USER", Context.MODE_PRIVATE);


        Bundle username = this.getIntent().getExtras();
        String objetointent = username.getString("username");
        preferencia.edit().putString("NAME_USER",objetointent).apply();

         */


       /* TextView user = findViewById(R.id.txtusername);
        user.setText(objetointent);
        */

        //pasar de activity al precionar el boton.
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(view -> {
            intent = new Intent(this, NavDrawerActivity.class);
            startActivity(intent);
            finish();
            //intent.putExtra("user",MainActivity.this.getUser());
            //Toast.makeText(MainActivity.this,"Bienvenido"+inputUser,Toast.LENGTH_LONG).show();
        });

/*
        //Si el boton no es precionado esta activity automaticamete pasara a la sigiente
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(this, MapActivity.class));
        */


    }


}