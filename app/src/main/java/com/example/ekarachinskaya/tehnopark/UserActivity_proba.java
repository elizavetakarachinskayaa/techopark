package com.example.ekarachinskaya.tehnopark;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class UserActivity_proba extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        final Button GoToDanActivity = (Button) findViewById(R.id.GoToDanActivity);

        Intent intent = getIntent();
        final String login = intent.getStringExtra("login");
        String company = intent.getStringExtra("company");
        //int age = intent.getIntExtra("age", -1);

        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        TextView etLogin = (TextView) findViewById(R.id.etLogin);
        TextView etCompany = (TextView) findViewById(R.id.etCompany);


        // Display user details
        String message = "Добро пожаловать," + login ;
        tvWelcomeMsg.setText(message);
        etLogin.setText(login);
        etCompany.setText(company);


        GoToDanActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //final String login = etLogin.getText().toString();


                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent(UserActivity_proba.this, ZayavkiActivity.class);
                                intent.putExtra("login", login);
                                UserActivity_proba.this.startActivity(intent);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                zayavRequest zayavRequest = new zayavRequest(login, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserActivity_proba.this);
                queue.add(zayavRequest);
            }
        });
    }

   }
