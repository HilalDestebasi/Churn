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
import android.util.Log;
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
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Pop extends Activity {
    public ArrayList<String> arrayList = new ArrayList<String>();
    DataModel val = new DataModel();
    Services service = new Services();
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


        arrayList.add(customerId.getText().toString());
        arrayList.add(customerSurname.getText().toString());
        arrayList.add(creditScore.getText().toString());
        arrayList.add(geography.getText().toString());
        arrayList.add(gender.getText().toString());
        arrayList.add(age.getText().toString());
        arrayList.add(tenure.getText().toString());
        arrayList.add(balance.getText().toString());
        arrayList.add(numOfProd.getText().toString());
        arrayList.add(hasCreditCard.getText().toString());
        arrayList.add(isActiveMember.getText().toString());
        arrayList.add(estimatedSalary.getText().toString());
        arrayList.add(exited.getText().toString());
        StringBuffer sb = new StringBuffer();
        sb.append("1,");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
            if(i!=arrayList.size()-1) {
                sb.append(",");
            }
        }

        String lastStr = sb.toString();

        val.val = lastStr;

        Intent in = new Intent(Pop.this, MainPage.class);
        //in.putStringArrayListExtra("test", arrayList);

        service.postData(val);

        //Log.d("exited", service.sendExited());
        deneme=customerSurname.getText().toString();

        startActivity(in);
        setResult(Activity.RESULT_OK);
    }
    public String getDeneme(){
        return deneme;
    }
}

