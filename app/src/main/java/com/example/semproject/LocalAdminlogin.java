package com.example.semproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LocalAdminlogin extends AppCompatActivity {

    Button btn10;
    Button btn9;
    EditText edt300;
    EditText edt301;
    String id,pass,region;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_adminlogin);

        edt300= (EditText) findViewById(R.id.editText300);
        edt301= (EditText) findViewById(R.id.editText301);



        btn10 = (Button) findViewById(R.id.button10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgetPassword();

            }
        });

        btn9= (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = edt300.getText().toString();
                openSetRates();

            }
        });

    }

    public void openForgetPassword() {
        Intent intent  =new Intent(this,ForgetPassword.class);
        startActivity(intent);
    }


    public void openSetRates() {

        reff = FirebaseDatabase.getInstance().getReference().child("LocalAdmin").child(String.valueOf(id));
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pass = snapshot.child("pass").getValue().toString();
                region = snapshot.child("region").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        if ( edt300.getText().toString().equals(id)&&edt301.getText().toString().equals(pass)){
            Intent intent  =new Intent(this,SetRates.class);
            intent.putExtra("region",region);
            startActivity(intent);

        }
    }



}