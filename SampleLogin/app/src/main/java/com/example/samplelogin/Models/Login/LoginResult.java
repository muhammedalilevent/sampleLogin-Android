package com.example.samplelogin.Models.Login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class LoginResult {


     
    @SerializedName("organization")
    public Organization organization;
     
    @SerializedName("user")
    public User user;
     
    @SerializedName("token")
    public String token;

    public static class Organization {
         
        @SerializedName("channels")
        private List<Channels> channels;
         
        @SerializedName("info")
        private Info ınfo;
    }

    public static class Channels {
         
        @SerializedName("title")
        private String title;
         
        @SerializedName("id")
        private int ıd;
    }

    public static class Info {
         
        @SerializedName("status")
        private int status;
         
        @SerializedName("createDate")
        private int createdate;
         
        @SerializedName("endDate")
        private int enddate;
         
        @SerializedName("startDate")
        private int startdate;
         
        @SerializedName("name")
        private String name;
         
        @SerializedName("id")
        private int ıd;
    }

    public static class User {
         
        @SerializedName("status")
        private int status;
         
        @SerializedName("email")
        private String email;
         
        @SerializedName("mobil")
        private String mobil;
         
        @SerializedName("username")
        private String username;
         
        @SerializedName("lastname")
        private String lastname;
         
        @SerializedName("firstName")
        private String firstname;
         
        @SerializedName("id")
        private int ıd;
    }
}
