package com.example.churn;

import java.io.File;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RetrofitAPI {
    @POST("/upload/")
    Call<ResponseModel> postMethod(@Body DataModel val);
}
