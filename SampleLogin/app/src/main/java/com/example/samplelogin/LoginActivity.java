package com.example.samplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.samplelogin.Models.Login.LoginRequest;
import com.example.samplelogin.Models.Login.LoginResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "http://192.168.1.48/SecurityAPI/api/Acount/Login";

    //Widgets

    public Button btnSignIn;
    public TextView txtId,txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnSignIn = findViewById(R.id.btnSignIn);
        txtId = findViewById(R.id.txtId);
        txtPassword = findViewById(R.id.txtPassword);



    }

    public void  loginClicked(View view){

        sendAndRequestResponse(txtId.getText().toString(),txtPassword.getText().toString());

    }



    private void sendAndRequestResponse(String username,String password) {

        com.example.samplelogin.Models.Common.Request<LoginRequest> req = new com.example.samplelogin.Models.Common.Request<LoginRequest>();
        req.data = new LoginRequest();

        req.data.username = username;
        req.data.password = password;

        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", "başarılı"+response  );
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody()  {

                    try {

                        Gson gson = new Gson();

                        return gson.toJson(req).getBytes();
                    } catch (Exception e) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", "", "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        Gson gson = new Gson();

                        Type collectionType = new TypeToken<com.example.samplelogin.Models.Common.Response<LoginResult>>() {
                        }.getType();

                        com.example.samplelogin.Models.Common.Response<LoginResult> map = gson.fromJson(new String(response.data, StandardCharsets.UTF_8), collectionType);

                        Log.e("VOLLEY","Gelen Verim"+map.data.token);
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}