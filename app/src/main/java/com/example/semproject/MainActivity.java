package com.example.semproject;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView txt4;
    TextView txt2;
    TextView txt;
    Button btn2;
    Spinner spinner;
    String region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView) findViewById(R.id.textView);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast();
            }
        });

        spinner= (Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(

                this,
                R.array.spinnerItems,
                R.layout.color_spinner_layout

        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        txt4=(TextView) findViewById(R.id.textView4);
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminpanel();
            }
        });
        txt2=(TextView) findViewById(R.id.textView2);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApplyforAdmin();
            }
        });

        btn2 =(Button) findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                region = spinner.getSelectedItem().toString();
                openRates();


            }
        });

    }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openAdminpanel() {
        Intent intent  =new Intent(this,Adminpannel.class);
        startActivity(intent);
    }
    public void openApplyforAdmin() {
        Intent intent  =new Intent(this,ApplyforAdmin.class);
        startActivity(intent);
    }

    public void displayToast() {
        Toast.makeText(MainActivity.this,"Mail us at 'walleedmustafa68@gmail.com'",Toast.LENGTH_LONG).show();
    }

    public  void  openRates(){

        Intent intent  =new Intent(this,Rates.class);
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