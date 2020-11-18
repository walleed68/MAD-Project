package com.example.semproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class ManageLocalAdmins extends AppCompatActivity {

    Button btn13;
    Button btn14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_local_admins);

        btn13 = (Button) findViewById(R.id.button13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateLocalAdmin();

            }
        });

        btn14 = (Button) findViewById(R.id.button14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRemoveLocalAdmin();

            }
        });

    }

    public void  openCreateLocalAdmin(){
        Intent intent  =new Intent(this,CreateLocalAdmin.class);
        startActivity(intent);
    }
    public void  openRemoveLocalAdmin(){
        Intent intent  =new Intent(this,RemoveLocalAdmin.class);
        startActivity(intent);
    }
}