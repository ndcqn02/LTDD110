package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ShowLopActivity extends AppCompatActivity {
    private RecyclerView rcv_lop110;
    private Button btn_themlop110, btn_xoalop110, btn_sualop110;
    private EditText edt_maLop110, edt_tenLop110, edt_siSoLop110;
    MyDatabase myDatabase = new MyDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lop);

        intViewListener();
        initView();
    }

    private void intViewListener() {
        btn_themlop110 = findViewById(R.id.btn_themLop110);
        btn_sualop110 = findViewById(R.id.btn_suaLop110);
        btn_xoalop110 = findViewById(R.id.btn_xoaLop110);
        edt_maLop110 = findViewById(R.id.edt_maLop110);
        edt_tenLop110 = findViewById(R.id.edt_tenLop110);
        edt_siSoLop110 = findViewById(R.id.edt_siSoLop110);


        btn_themlop110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lop lop = new Lop(edt_maLop110.getText().toString(), edt_tenLop110.getText().toString(), Integer.parseInt(edt_siSoLop110.getText().toString()));
                if (myDatabase.insertLop(lop) == -1){
                    Toast.makeText(ShowLopActivity.this, "Error!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ShowLopActivity.this, "Thêmm lớp thành công!", Toast.LENGTH_SHORT).show();
                }
                initView();
            }
        });

        btn_sualop110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lop lop = new Lop(edt_maLop110.getText().toString(), edt_tenLop110.getText().toString(), Integer.parseInt(edt_siSoLop110.getText().toString()));
                if(myDatabase.updateLop(lop) == -1){
                    Toast.makeText(ShowLopActivity.this, "Error!!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ShowLopActivity.this, "Modified successful!", Toast.LENGTH_SHORT).show();
                }
                initView();
            }
        });

        btn_xoalop110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myDatabase.deleteLop(edt_maLop110.getText().toString()) == -1) {
                    Toast.makeText(ShowLopActivity.this, "Error!!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ShowLopActivity.this, "Deleted successful!", Toast.LENGTH_SHORT).show();
                }
                initView();
            }
        });
    }

    private void initView() {
        rcv_lop110 = findViewById(R.id.rcv_lop110);
        rcv_lop110.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv_lop110.setLayoutManager(linearLayoutManager);
        // them duong divider giua cac item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_lop110.addItemDecoration(itemDecoration);

        ArrayList<Lop> arrLopAdapter = (ArrayList<Lop>) myDatabase.readAllLop();

        LopAdapter adapter = new LopAdapter(arrLopAdapter, new IclickItemRecyclerview() {
            @Override
            public void onClickItemLop(Lop lop) {
                onClickGoToSinhVien(lop);
            }

            @Override
            public void onClickItemSinhVien(SinhVien sinhVien) {

            }
        });
        rcv_lop110.setAdapter(adapter);
    }

    private void onClickGoToSinhVien(Lop lop){
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_Lop", lop);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}