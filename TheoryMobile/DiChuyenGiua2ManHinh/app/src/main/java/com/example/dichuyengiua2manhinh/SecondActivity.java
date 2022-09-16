package com.example.dichuyengiua2manhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtString1 = findViewById(R.id.txtString);
        TextView txtNumber1 = findViewById(R.id.txtNumber);

        Intent intent = getIntent();
        String contenIsString = intent.getStringExtra("data");
        int contentIsNumber = intent.getIntExtra("number", 12);

        txtString1.setText(contenIsString);
        txtNumber1.setText("" + contentIsNumber);
    }
}