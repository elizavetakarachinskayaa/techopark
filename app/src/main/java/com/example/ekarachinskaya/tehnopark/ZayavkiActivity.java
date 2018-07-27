package com.example.ekarachinskaya.tehnopark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ZayavkiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zayavki);
        TextView textView3 = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();
        String login = intent.getStringExtra("login");
        String message = "Получилось" + login;

        textView3.setText(message);

    }
}
