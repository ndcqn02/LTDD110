package com.example.kiemtrathuchanh1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnChuyen = findViewById(R.id.btnMain);
        Button btnCancel = findViewById(R.id.btnCancel);
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText hten = (EditText) findViewById(R.id.editTextTen);
                EditText msvien = (EditText) findViewById(R.id.editTextMSV);
                EditText queQuan = (EditText) findViewById(R.id.editTextQueQuan);


                String ten = hten.getText().toString();
                String msv = msvien.getText().toString();
                String que = queQuan.getText().toString();


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                SinhVien sv = new SinhVien(ten, msv, que);
                intent.putExtra("dulieu",  sv);

                startActivity(intent);

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText hten = (EditText) findViewById(R.id.editTextTen);
                EditText msvien = (EditText) findViewById(R.id.editTextMSV);
                EditText queQuan = (EditText) findViewById(R.id.editTextQueQuan);

                hten.setText("");
                msvien.setText("");
                queQuan.setText("");
            }
        });
    }
}