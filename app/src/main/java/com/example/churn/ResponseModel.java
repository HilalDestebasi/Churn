package com.example.churn;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseModel implements Serializable {
    @SerializedName("RowNumber")
    String RowNumber;
    @SerializedName("CustomerId")
    String CustomerId;
    @SerializedName("Surname")
    String Surname;
    @SerializedName("CreditScore")
    String CreditScore;
    @SerializedName("Geography")
    String Geography;
    @SerializedName("Gender")
    String Gender;
    @SerializedName("Age")
    String Age;
    @SerializedName("Tenure")
    String Tenure;
    @SerializedName("Balance")
    String Balance;
    @SerializedName("NumberOfProducts")
    String NumOfProducts;
    @SerializedName("HasCrCard")
    String HasCrCard;
    @SerializedName("IsActiveMember")
    String IsActiveMember;
    @SerializedName("EstimatedSalary")
    String EstimatedSalary;
    @SerializedName("Exited")
    String Exited;
}
