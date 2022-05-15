package com.example.churn;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    public static ArrayList<String> arrayL=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#000000\">" + "MY CUSTOMERS" + "</font>"));

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main_page);
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ItemFragment()).commit();
        LinearLayout myRoot = (LinearLayout) findViewById(R.id.list);
        ScrollView sv=(ScrollView) findViewById(R.id.scrollList);
        sv.setVisibility(View.INVISIBLE);
        myRoot.setVisibility(View.INVISIBLE);
        Pop p=new Pop();

        if(!p.getDeneme().equals("")){
            sv.setVisibility(View.VISIBLE);
            myRoot.setVisibility(View.VISIBLE);

            setListItems();
        }

    }

    public void setListItems(){
        Pop p=new Pop();
        TextView t=new TextView(getApplicationContext());
        String s=p.getDeneme();
        arrayL.add(s);
        LinearLayout myRoot = (LinearLayout) findViewById(R.id.list);

        LinearLayout a = new LinearLayout(this);
        a.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView[] pairs=new TextView[arrayL.size()];

        for(int l=0; l<arrayL.size(); l++)
        {
            pairs[l] = new TextView(this);
            pairs[l].setTextSize(20);
            pairs[l].setPadding(20,10,10,5);
            pairs[l].setLayoutParams(lp);
            pairs[l].setId(l);
            pairs[l].setText((l + 1) + " : "+arrayL.get(l));
            myRoot.addView(pairs[l]);
        }

    }



    public void insertFileClick(View view) {
        startActivity(new Intent(MainPage.this,Pop.class));

    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            LinearLayout myRoot = (LinearLayout) findViewById(R.id.list);
            ScrollView sv=(ScrollView) findViewById(R.id.scrollList);

            switch (item.getItemId()) {
                case R.id.results:
                    fragment = new Results();
                    myRoot.setVisibility(View.INVISIBLE);
                    sv.setVisibility(View.INVISIBLE);
                    break;
                case R.id.aboutApplication:
                    fragment = new Products();
                    myRoot.setVisibility(View.INVISIBLE);
                    sv.setVisibility(View.INVISIBLE);
                    break;
                case R.id.customers:
                    fragment = new ItemFragment();
                    myRoot.setVisibility(View.VISIBLE);
                    sv.setVisibility(View.VISIBLE);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return false;
        }
    };
}