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

public class CreateLocalAdmin extends AppCompatActivity {


    Button btn16;
    EditText edt200,edt201,edt202,edt203,edt204,edt205,edt206,edt207;
    DatabaseReference reff;
    LocalAdmins localAdmin;
    String Adminid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_local_admin);



        edt200= (EditText) findViewById(R.id.editText200);
        edt201= (EditText) findViewById(R.id.editText201);
        edt202= (EditText) findViewById(R.id.editText202);
        edt203= (EditText) findViewById(R.id.editText203);
        edt204= (EditText) findViewById(R.id.editText204);
        edt205= (EditText) findViewById(R.id.editText205);
        edt206= (EditText) findViewById(R.id.editText206);
        edt207= (EditText) findViewById(R.id.editText207);
        reff = FirebaseDatabase.getInstance().getReference().child("LocalAdmin");

        localAdmin = new LocalAdmins();

        btn16 = (Button) findViewById(R.id.button16);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Adminid=edt204.getText().toString();
                createAdmin();

            }
        });



    }

    public void createAdmin(){

            if(edt200.equals("")||edt201.equals("")||edt202.equals("")||edt203.equals("")||edt204.equals("")||edt205.equals("")||edt206.equals("")||edt206.equals("")||edt207.equals("")){
                Toast.makeText(CreateLocalAdmin.this,"Please Fill out all fields",Toast.LENGTH_SHORT).show();
            }
            else{

                if(edt206.getText().toString().equals(edt207.getText().toString())){
                    String Fname = edt200.getText().toString();
                    String Lname=edt201.getText().toString();
                    String CNIC=edt202.getText().toString();
                    String Mobile=edt203.getText().toString();
                    String ID=edt204.getText().toString();
                    String Region=edt205.getText().toString();
                    String Pass=edt206.getText().toString();



                    localAdmin.setFname(Fname);
                    localAdmin.setLname(Lname);
                    localAdmin.setCNIC(CNIC);
                    localAdmin.setMobile(Mobile);
                    localAdmin.setID(ID);
                    localAdmin.setRegion(Region);
                    localAdmin.setPass(Pass);

                    reff.child(String.valueOf(Adminid)).setValue(localAdmin);


                    Toast.makeText(CreateLocalAdmin.this,"Local User Created",Toast.LENGTH_SHORT).show();

                    Intent intent  =new Intent(this,MainActivity.class);
                    startActivity(intent);



                }

                else{



                    Toast.makeText(CreateLocalAdmin.this,"Password not matched",Toast.LENGTH_SHORT).show();



                }


            }





    }

}