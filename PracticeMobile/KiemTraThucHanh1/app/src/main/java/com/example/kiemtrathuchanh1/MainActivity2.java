package com.example.kiemtrathuchanh1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView ten = (TextView) findViewById(R.id.txtten);
        TextView msvien = (TextView)findViewById(R.id.txtMSV);
        TextView queQuan = (TextView) findViewById(R.id.txtquequan);


        Intent intent = getIntent();
        SinhVien sv2 = (SinhVien) intent.getSerializableExtra("dulieu");

        ten.setText(sv2.getTen());
        msvien.setText( " " + sv2.getMsv() );
        queQuan.setText(" " + sv2.getQuequan() );

        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}