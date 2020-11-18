package com.example.semproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;

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

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainAdminlogin extends AppCompatActivity {

    Button btn8;
    EditText edt5;
    EditText edt6;
    int counter = 2;
    String a , b;

    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_adminlogin);
        edt5= (EditText) findViewById(R.id.editText5);
        edt6= (EditText) findViewById(R.id.editText6);

        btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });

        reff= FirebaseDatabase.getInstance().getReference();
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                b= snapshot.child("pass").getValue().toString();
                a=snapshot.child("email").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }


    public void login() {
        if (edt5.getText().toString().equals(a) && edt6.getText().toString().equals(b)) {

            openMainAdmin();
        } else {
            if(counter==0){
                counter=2;
                new CountDownTimer(10000, 10000) {

                    public void onTick(long millisUntilFinished) {
                        btn8.setVisibility(View.INVISIBLE);
                        Toast.makeText(MainAdminlogin.this,"please wait 10 seconds",Toast.LENGTH_LONG).show();

                    }

                    public void onFinish() {
                        btn8.setVisibility(View.VISIBLE);
                    }
                }.start();


            }
            else{
                Toast.makeText(MainAdminlogin.this,"Incorrect Credentials",Toast.LENGTH_SHORT).show();
                counter--;
            }
        }
    }
        public void openMainAdmin(){
        Intent intent = new Intent(this, MainAdmin.class);
        startActivity(intent);

    }

}

