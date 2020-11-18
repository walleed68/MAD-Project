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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetRates extends AppCompatActivity {

    Button btn19;
    EditText edt400,edt401,edt402,edt403,edt404,edt405;
    DatabaseReference reff;
    setrate obj1=new setrate();
    String region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_rates);


        edt400= (EditText) findViewById(R.id.editText400);
        edt401= (EditText) findViewById(R.id.editText401);
        edt402= (EditText) findViewById(R.id.editText402);
        edt403= (EditText) findViewById(R.id.editText403);
        edt404= (EditText) findViewById(R.id.editText404);
        edt405= (EditText) findViewById(R.id.editText405);

        reff = FirebaseDatabase.getInstance().getReference().child("Rates");

        region = getIntent().getStringExtra("region");

        btn19 = (Button) findViewById(R.id.button19);
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnewrate();

            }
        });

    }



    public  void  setnewrate(){


        if( edt400.getText().toString().equals("")||edt401.getText().toString().equals("")||edt402.getText().toString().equals("")||edt403.getText().toString().equals("")||edt404.getText().toString().equals("")||edt405.getText().toString().equals(""))
        {
            Toast.makeText(SetRates.this,"Please fill out all fields ",Toast.LENGTH_SHORT).show();
        }
        else{


            String potato=edt400.getText().toString();
            String cabbage=edt401.getText().toString();
            String bittermellon=edt402.getText().toString();
            String lemon=edt403.getText().toString();
            String onion=edt404.getText().toString();
            String tomato=edt405.getText().toString();

            obj1.setPotato(potato);
            obj1.setCabbage(cabbage);
            obj1.setBittermellon(bittermellon);
            obj1.setLemon(lemon);
            obj1.setOnion(onion);
            obj1.setTomato(tomato);



            reff.child(String.valueOf(region)).setValue(obj1);

            Toast.makeText(SetRates.this,"Prices updated",Toast.LENGTH_SHORT).show();
            Intent intent  =new Intent(this,MainActivity.class);
            startActivity(intent);

        }


    }



}