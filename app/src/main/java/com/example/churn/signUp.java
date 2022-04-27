package com.example.churn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_sign_up);
    }
    FirebaseDatabase db;


    public void signUpClick(View v) {

        EditText name=(EditText) findViewById(R.id.name);
        EditText email=(EditText) findViewById(R.id.email);
        EditText password=(EditText) findViewById(R.id.password);
        EditText passwordAgain=(EditText) findViewById(R.id.password_again);
        TextView errorMessage=(TextView) findViewById(R.id.error_message);
        if(!passwordAgain.getText().toString().equals(password.getText().toString())
                ||email.getText().toString().length()==0
                ||name.getText().toString().length()==0){
            errorMessage.setText("!!Please Enter Correctly!!");
            errorMessage.setVisibility(View.VISIBLE);
        }else{
            EditText company=(EditText) findViewById(R.id.company);
            EditText address=(EditText) findViewById(R.id.address);
            EditText phone  =(EditText) findViewById(R.id.phone);
            saveUser(name.getText().toString(),email.getText().toString(),password.getText().toString(),
                    company.getText().toString(), address.getText().toString(),phone.getText().toString());
            Toast.makeText(signUp.this,"User Added to Firebase",Toast.LENGTH_LONG).show();

            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);

        }



    }

    public void saveUser(String name,String email,String password,String company, String address, String phone){

        Toast.makeText(signUp.this,"Firebase Connection is Success",Toast.LENGTH_LONG).show();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        User u=new User(name,email,password,company,address,phone);
        myRef.child("Users").push().setValue(u);

    }
}