package com.example.dichuyenmanhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtdata = findViewById(R.id.txtResult);
        TextView txtNumber = findViewById(R.id.txtNumber);

        Intent intent = getIntent();
        String noiDung = intent.getStringExtra("dulieu");
        int contentIsNumber = intent.getIntExtra("number", 123);

        txtdata.setText(noiDung);
        txtNumber.setText(""+ contentIsNumber);

    }
}