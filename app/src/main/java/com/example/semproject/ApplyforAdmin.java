package com.example.semproject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.AsyncTaskLoader;


import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import java.util.Properties;

import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ApplyforAdmin extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5;
    Button btnsnd;
    String sEmail,sPassword,msg,subject,myemail, Fname, Lname, Cnic , Cell , Region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyfor_admin);
        ed1 = (EditText)  findViewById(R.id.fname);
        ed2 = (EditText) findViewById(R.id.lname);
        ed3 = (EditText) findViewById(R.id.cnic);
        ed4 = (EditText) findViewById(R.id.cell);
        ed5 = (EditText) findViewById(R.id.region);


        btnsnd = findViewById(R.id.button3);

        subject = "Local Admin Request";
        myemail = "walleedmustafa68@gmail.com";

        //Sender Email Credential

        sEmail = "bcsfyp2k17@gmail.com";
        sPassword = "fyp2k17a";

        btnsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fname = ed1.getText().toString();
                Lname = ed2.getText().toString();
                Cnic =  ed3.getText().toString();
                Cell = ed4.getText().toString();
                Region = ed5.getText().toString();


                msg = "F name: " + Fname + " L name: " + Lname + " Cnic: " + Cnic + " Cell: " + Cell + " Region: " + Region ;

                sendemail();
            }
        });



    }
   public void sendemail(){
       // Initialize properties

       Properties properties = new Properties();
       properties.put("mail.smtp.auth","true");
       properties.put("mail.smtp.starttls.enable","true");
       properties.put("mail.smtp.host","smtp.gmail.com");
       properties.put("mail.smtp.port","587");

       //Initialize session
       Session session = Session.getInstance (properties,new Authenticator(){


           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(sEmail,sPassword);
           }

       });



       try {
           //Initialize email content
           Message message = new MimeMessage(session);
           //Sender email
           message.setFrom(new InternetAddress(sEmail));
           //Recipt email
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(myemail));
           //Email subject
           message.setSubject(subject);
           //Email message
           message.setText(msg);
           //send Email
           new SendMail().execute(message);



       } catch (MessagingException e) {
           e.printStackTrace();
       }


   }


    private class SendMail extends AsyncTask<Message,String,String> {

        //Initialize progress dialog
        private ProgressDialog progressDialog;




        protected void onPreExecute(){
            super.onPreExecute();
            //create and show progress
            progressDialog = ProgressDialog.show( ApplyforAdmin.this, "Please Wait", "Sending Mail", true, false );
        }

        protected  String doInBackground(Message...messages){



            try {
                //when success
                Transport.send(messages[0]);
                return "Success";

            }
            catch (MessagingException e){
                //when error
                e.printStackTrace();
                return "Error";
            }



        }

        protected void onPostExecute(String s){

            super.onPostExecute(s);
            //Dismiss dialog
            progressDialog.dismiss();
            if (s.equals("Success")){

                //When Success


                //Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ApplyforAdmin.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color = #509324 >Success</font>"));
                builder.setMessage("Mail send successfully");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //clear all edit text
                        ed1.setText("");
                        ed2.setText("");
                        ed3.setText("");
                        ed4.setText("");
                        ed5.setText("");



                    }
                });
                // Show alert dialog
                builder.show();
            }
            else{
                //when error
                Toast.makeText(getApplicationContext(), "Something went Wrong please try again later", Toast.LENGTH_LONG ).show();
            }


        }




    }
}