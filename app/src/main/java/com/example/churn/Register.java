package com.example.churn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;



public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_register);



    }
    public void loginClick(View v) {

        EditText email=(EditText) findViewById(R.id.email);

        EditText password=(EditText) findViewById(R.id.password);
        TextView errorMessage=(TextView) findViewById(R.id.error_message);
        if(email.length()==0){
            errorMessage.setText("!!Please Enter Correctly!!");
            errorMessage.setVisibility(View.VISIBLE);
        }else{
            Intent i=new Intent(this,MainPage.class);
            startActivity(i);
        }

    }

    public void signUpClick(View v) {

            Intent i=new Intent(this,signUp.class);
            startActivity(i);


    }
}