package com.example.churn;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services implements IService{

    String surname;
    String exited;
    List<ResponseModel> results;
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getExited() {
        return exited;
    }

    public void setExited(String exited) {
        this.exited = exited;
    }

    public void postData(DataModel val) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.126.50.162:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<ResponseModel> call = retrofitAPI.postMethod(val);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                ResponseModel responseFromAPI = response.body();
// TODO:
                Log.d("response: ",responseFromAPI.Exited);
                setExited(responseFromAPI.Exited);
                setSurname(responseFromAPI.Surname);
                //Log.d("exited " , getExited());
                //results.add(responseFromAPI);

                String responseString = "Response Code : " + response.code();
                Log.d("lol",responseString);


            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                Log.d("error","couldn't get response");

            }
    });
}

    @Override
    public String sendExited() {
        return exited;
    }
}