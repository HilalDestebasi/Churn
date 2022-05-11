package com.example.churn;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


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
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    @Nullable

    public void addCustomerClick(View view) {
        ListView list=(ListView) findViewById(R.id.list);
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
        // Add the pet to our listview
        listItems.add(customerId.getText().toString()+"\t"+customerSurname.getText().toString());
        adapter.notifyDataSetChanged();

        list.setVisibility(View.VISIBLE);

    }

}

