package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv_Lop;
    private Button btn_themLop, btn_xoaLop, btn_suaLop;
    private EditText edt_maLop, edt_tenLop, edt_siSo ;
    MyDatabase myDatabase = new MyDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intViewListener();
        initView();
    }

    private void intViewListener() {
        btn_themLop = findViewById(R.id.btn_themlop);
        btn_xoaLop = findViewById(R.id.btn_xoalop);
        btn_suaLop = findViewById(R.id.btn_sualop);
        edt_maLop = findViewById(R.id.edt_malop);
        edt_tenLop = findViewById(R.id.edt_tenlop);
        edt_siSo = findViewById(R.id.edt_siso);

        btn_themLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.insertLop(edt_maLop.getText().toString(), edt_tenLop.getText().toString(), edt_siSo.getText().toString());
                Toast.makeText(getApplicationContext(), "Thêm thành công lớp mới!", Toast.LENGTH_LONG).show();
                initView();

            }
        });

        btn_suaLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.updateLop(edt_maLop.getText().toString(), edt_tenLop.getText().toString(), edt_siSo.getText().toString());
                Toast.makeText(MainActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                initView();
            }
        });

        btn_xoaLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.deleteLop(edt_maLop.getText().toString());
                Toast.makeText(MainActivity.this, "Xóa lớp thành công!", Toast.LENGTH_SHORT).show();
                initView();
            }
        });

    }

    private void initView() {
        rcv_Lop = findViewById(R.id.rcv_Lop);
        rcv_Lop.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv_Lop.setLayoutManager(linearLayoutManager);
        // them duong divider giua cac item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_Lop.addItemDecoration(itemDecoration);

        ArrayList<Lop> arrayAdapter = (ArrayList<Lop>) myDatabase.readAllLop();

        LopAdapter adapter = new LopAdapter(arrayAdapter, this);
        rcv_Lop.setAdapter(adapter);

    }
















}