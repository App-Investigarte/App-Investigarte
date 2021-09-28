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






        btnStart=findViewById(R.id.btnStart);

        btnStart.setOnClickListener(view -> {


            intent=new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
            //intent.putExtra("user",MainActivity.this.getUser());
            //Toast.makeText(MainActivity.this,"Bienvenido"+inputUser,Toast.LENGTH_LONG).show();


        });

    }




}