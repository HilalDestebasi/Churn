package com.example.churn;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataModel implements Serializable {
    @SerializedName("val")
    String val;
}

