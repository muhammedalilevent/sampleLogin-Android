package com.example.samplelogin.Models.Common;

import com.google.gson.annotations.SerializedName;

public class Response<T>   {

    @SerializedName("data")
    public T data;
    @SerializedName("responseCode")
    public int responseCode;
    @SerializedName("errorExists")
    public boolean errorExists;
    @SerializedName("responseMessage")
    public String responseMessage;
}
