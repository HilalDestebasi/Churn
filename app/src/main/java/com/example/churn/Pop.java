package com.example.churn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Pop extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        DisplayMetrics dm =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width =dm.widthPixels;
        int height =dm.heightPixels;
        getWindow().setLayout((int)(width*.9),(int)(height*.6));
    }
    public static String deneme="";


    @SuppressLint("ResourceType")
    @Nullable

    public void addCustomerClick(View view) throws IOException {
        EditText customerId=(EditText) findViewById(R.id.customerID);
        EditText customerSurname=(EditText) findViewById(R.id.customerSurname);
        EditText creditScore=(EditText) findViewById(R.id.creditScore);
        EditText geography=(EditText) findViewById(R.id.geography);
        EditText gender=(EditText) findViewById(R.id.gender);
        EditText age=(EditText) findViewById(R.id.age);
        EditText tenure=(EditText) findViewById(R.id.tenure);
        EditText balance=(EditText) findViewById(R.id.balance);
        EditText numOfProd=(EditText) findViewById(R.id.numOfProducts);
        EditText hasCreditCard=(EditText) findViewById(R.id.hasCrCard);
        EditText isActiveMember=(EditText) findViewById(R.id.isActiveMember);
        EditText estimatedSalary=(EditText) findViewById(R.id.estimatedSalary);
        EditText exited=(EditText) findViewById(R.id.exited);
        deneme=customerSurname.getText().toString();

        Intent in = new Intent(Pop.this, MainPage.class);

        startActivity(in);
        setResult(Activity.RESULT_OK);
    }
    public String getDeneme(){
        return deneme;
    }
}

