package com.example.semproject;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rates extends AppCompatActivity {


    TextView txt5,txt7,txt9,txt11,txt13,txt15;
    DatabaseReference reff;
    String region,potato,cabbage, bittermellon,lemon,onion,tomato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);


        region=getIntent().getStringExtra("region");
        txt5= (TextView) findViewById(R.id.textView5);
        txt7= (TextView) findViewById(R.id.textView7);
        txt9= (TextView) findViewById(R.id.textView9);
        txt11= (TextView) findViewById(R.id.textView11);
        txt13= (TextView) findViewById(R.id.textView13);
        txt15= (TextView) findViewById(R.id.textView15);


        reff = FirebaseDatabase.getInstance().getReference().child("Rates").child(String.valueOf(region));
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 potato= snapshot.child("potato").getValue().toString();
                 cabbage= snapshot.child("cabbage").getValue().toString();
                bittermellon= snapshot.child("bittermellon").getValue().toString();
                lemon= snapshot.child("lemon").getValue().toString();
                onion= snapshot.child("onion").getValue().toString();
                tomato= snapshot.child("tomato").getValue().toString();


                txt5.setText(potato);
                txt7.setText(cabbage);
                txt9.setText(bittermellon);
                txt11.setText(lemon);
                txt13.setText(onion);
                txt15.setText(tomato);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });



    }
}