package com.example.kiemtrathuchanh1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    String ten;
    String msv;
    String que;

    EditText hten = findViewById(R.id.editTextTen);
    EditText msvien = findViewById(R.id.editTextMSV);
    EditText queQuan = findViewById(R.id.editTextQueQuan);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChuyen = findViewById(R.id.btnMain);
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ten = hten.getText().toString();
                msv = msvien.getText().toString();
                que = queQuan.getText().toString();


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                SinhVien sv = new SinhVien(ten, msv, que);
                intent.putExtra("dulie",  sv);

                startActivity(intent);




            }
        });
    }
}