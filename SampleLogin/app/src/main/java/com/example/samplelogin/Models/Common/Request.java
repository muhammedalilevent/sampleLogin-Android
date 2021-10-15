package com.example.samplelogin.Models.Common;

import com.google.gson.annotations.SerializedName;

public class Request<T> {

    @SerializedName("Data")
    public T data;


}