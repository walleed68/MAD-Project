package com.example.semproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RemoveLocalAdmin extends AppCompatActivity {


    EditText edt12;
    Button btn15;
    String AdminID;

    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_local_admin);

        edt12 = (EditText)findViewById(R.id.editText12);

        btn15 = (Button)findViewById(R.id.button15);

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AdminID = edt12.getText().toString();
                openRemoveAdmin();

            }
        });

    }


    public void openRemoveAdmin(){


        reff = FirebaseDatabase.getInstance().getReference().child("LocalAdmin");
        reff.child(String.valueOf(AdminID)).removeValue();

        Toast.makeText(RemoveLocalAdmin.this,"Local Admin Removed",Toast.LENGTH_SHORT).show();
        Intent intent  =new Intent(this,MainActivity.class);
        startActivity(intent);


    }


}