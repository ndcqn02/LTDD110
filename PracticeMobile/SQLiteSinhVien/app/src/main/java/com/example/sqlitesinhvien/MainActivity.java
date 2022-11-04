package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv_SV110;
    private Button btn_themSV110, btn_xoaSV110, btn_suaSV110;
    private EditText edt_maSv110, edt_tenSV110, edt_moTa110 ;
    MyDatabase myDatabase = new MyDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intViewListener();
        initView();
    }

    private void intViewListener() {
        btn_themSV110 = findViewById(R.id.btn_themSV110);
        btn_xoaSV110 = findViewById(R.id.btn_xoaSV110);
        btn_suaSV110 = findViewById(R.id.btn_suaSV110);
        edt_maSv110 = findViewById(R.id.edt_maSV110);
        edt_tenSV110 = findViewById(R.id.edt_tenSV110);
        edt_moTa110 = findViewById(R.id.edt_mota110);

        btn_themSV110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.insertLop(edt_maSv110.getText().toString(), edt_tenSV110.getText().toString(), edt_moTa110.getText().toString());
                Toast.makeText(getApplicationContext(), "Thêm thành công lớp mới!", Toast.LENGTH_LONG).show();
                initView();

            }
        });

        btn_suaSV110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.updateLop(edt_maSv110.getText().toString(), edt_tenSV110.getText().toString(), edt_moTa110.getText().toString());
                Toast.makeText(MainActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                initView();
            }
        });

        btn_xoaSV110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.deleteLop(edt_maSv110.getText().toString());
                Toast.makeText(MainActivity.this, "Xóa lớp thành công!", Toast.LENGTH_SHORT).show();
                initView();
            }
        });

    }

    private void initView() {
        rcv_SV110 = findViewById(R.id.rcv_SV110);
        rcv_SV110.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv_SV110.setLayoutManager(linearLayoutManager);
        // them duong divider giua cac item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_SV110.addItemDecoration(itemDecoration);

        ArrayList<SinhVien> arrayAdapter = (ArrayList<SinhVien>) myDatabase.readAllLop();

        LopAdapter adapter = new LopAdapter(arrayAdapter, this);
        rcv_SV110.setAdapter(adapter);

    }
















}