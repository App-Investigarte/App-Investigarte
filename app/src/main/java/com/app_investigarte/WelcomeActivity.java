package com.app_investigarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity
{
    public Button btnStart;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //pasar de activity al precionar el boton.
        btnStart=findViewById(R.id.btnStart);
        btnStart.setOnClickListener(view -> {
            intent=new Intent(this,NavDrawerActivity.class);
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