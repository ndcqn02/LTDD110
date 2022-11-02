package com.example.sqlitedienthoai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv_Recyclerview;
    AdapterMobile  adapterMobile;
    ImageView img_add;
    Mydatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_add = findViewById(R.id.img_Add);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMobileActivity.class);
                startActivity(intent);

            }
        });

        initView();
    }

    public void initView() {
        rcv_Recyclerview = findViewById(R.id.rcv_Recyclerview);
        mydatabase = new Mydatabase(this );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv_Recyclerview.setLayoutManager(linearLayoutManager);

        adapterMobile = new AdapterMobile( mydatabase.readAllMobile());
        rcv_Recyclerview.setAdapter(adapterMobile);
        adapterMobile.notifyDataSetChanged();
    }
}