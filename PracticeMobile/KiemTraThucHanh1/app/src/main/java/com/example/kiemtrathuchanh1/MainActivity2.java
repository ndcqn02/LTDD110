package com.example.kiemtrathuchanh1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView ten = (TextView) findViewById(R.id.txtten);
    TextView msvien = (TextView)findViewById(R.id.txtMSV);
    TextView queQuan = (TextView) findViewById(R.id.txtquequan);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        SinhVien sv2 = (SinhVien) intent.getSerializableExtra("dulieu");

    }
}