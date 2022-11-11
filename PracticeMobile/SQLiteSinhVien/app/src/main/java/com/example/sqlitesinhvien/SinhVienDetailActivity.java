package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SinhVienDetailActivity extends AppCompatActivity {

    private TextView tv_MaSV_dt, tv_tenSV_dt, tv_Mota_dt, tv_maLop_dt, tv_Diem_dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien_detail);

        initView();
    }

    private void initView() {
        tv_MaSV_dt = findViewById(R.id.tv_MaSV_dt);
        tv_tenSV_dt = findViewById(R.id.tv_tenSV_dt);
        tv_Mota_dt = findViewById(R.id.tv_Mota_dt);
        tv_maLop_dt = findViewById(R.id.tv_maLop_dt);
        tv_Diem_dt = findViewById(R.id.tv_Diem_dt);

        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("object_SV");

        tv_MaSV_dt.setText(sinhVien.getMaSV110());
        tv_tenSV_dt.setText(sinhVien.getTenSV110());
        tv_Mota_dt.setText(sinhVien.getMota110());
        tv_maLop_dt.setText(sinhVien.getMaLop());
        tv_Diem_dt.setText(String.valueOf(sinhVien.getDiem()));

    }
}