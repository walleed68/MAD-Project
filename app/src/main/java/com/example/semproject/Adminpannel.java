package com.example.semproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Adminpannel extends AppCompatActivity {

    Button btn4;
    Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpannel);
        btn4=(Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainAdminlogin();

            }
        });

        btn5=(Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocalAdminlogin();

            }
        });




    }
    public void openMainAdminlogin() {
        Intent intent  =new Intent(this,MainAdminlogin.class);
        startActivity(intent);


    }

    public void openLocalAdminlogin() {
        Intent intent  =new Intent(this,LocalAdminlogin.class);
        startActivity(intent);


    }
}