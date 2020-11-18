package com.example.semproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class MainAdmin extends AppCompatActivity {

    Button btn6;
    Button btn7;
    Button btn17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManageLocalAdmin();

            }
        });

        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelectRegion();

            }
        });

        btn17 = (Button) findViewById(R.id.button17);
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChangePassword();

            }
        });


    }
    public void  openManageLocalAdmin(){
        Intent intent  =new Intent(this,ManageLocalAdmins.class);
        startActivity(intent);
    }
    public void  openSelectRegion(){
        Intent intent  =new Intent(this,SelectRegion.class);
        startActivity(intent);
    }


    public void openChangePassword(){
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);

    }

}