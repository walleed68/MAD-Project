package com.example.semproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeEvent;

public class ChangePassword extends AppCompatActivity {

    EditText edt27;
    EditText edt28;
    Button btn18;
    String b;
    DatabaseReference reff;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        edt27= (EditText) findViewById(R.id.editText27);
        edt28= (EditText) findViewById(R.id.editText28);
        reff= FirebaseDatabase.getInstance().getReference().child("password");

        btn18 = (Button) findViewById(R.id.button18);
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openChangePass();
            }
        });

    }

    public void openChangePass(){




        if (edt27.getText().toString().equals(edt28.getText().toString()) ){

            b=edt27.getText().toString();

            reff.setValue(b);


            Intent intent  =new Intent(this,MainAdminlogin.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(ChangePassword.this,"Password not matched",Toast.LENGTH_LONG).show();
        }

    }
}