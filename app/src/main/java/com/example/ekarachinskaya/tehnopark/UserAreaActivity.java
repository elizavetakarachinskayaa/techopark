package com.example.ekarachinskaya.tehnopark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        Intent intent = getIntent();
        String login = intent.getStringExtra("login");
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
    }

    public void GoToDanActivity (View view){
        Intent intent = new Intent(UserAreaActivity.this, DanActivity.class);
        startActivity(intent);

    }
}