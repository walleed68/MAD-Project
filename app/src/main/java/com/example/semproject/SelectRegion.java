package com.example.semproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectRegion extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

        Button btn12;



        Spinner spinner;
        String region;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);

        spinner= (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(

                this,
                R.array.spinnerItems,
                R.layout.color_spinner_layout

        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        btn12 = (Button) findViewById(R.id.button12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setnewrates();




            }
        });


    }

    public void setnewrates(){

        Intent intent  =new Intent(this,SetRates.class);
        region = spinner.getSelectedItem().toString();
        intent.putExtra("region",region);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}