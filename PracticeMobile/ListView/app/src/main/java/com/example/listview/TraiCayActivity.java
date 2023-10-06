package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TraiCayActivity extends AppCompatActivity {
    ListView lvtraicay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trai_cay);


        AnhXa();
        adapter = new TraiCayAdapter(this,R.layout.dong_trai_cay, arrayTraiCay );
        lvtraicay.setAdapter(adapter);
    }


    private void AnhXa() {
        lvtraicay = findViewById(R.id.listviewTraiCay);
        arrayTraiCay = new ArrayList<>();
        arrayTraiCay.add(new TraiCay("Dây tây", "Đay là dâu tây", R.drawable.girlxinh));
        arrayTraiCay.add(new TraiCay("Dây tây1", "Đay là dâu tây2", R.drawable.girlxinh));
        arrayTraiCay.add(new TraiCay("Dây tây2", "Đay là dâu tây3", R.drawable.girlxinh));
        arrayTraiCay.add(new TraiCay("Dây tây3", "Đay là dâu tây4", R.drawable.girlxinh));
        arrayTraiCay.add(new TraiCay("Dây tây4", "Đay là dâu tây4", R.drawable.girlxinh));
        arrayTraiCay.add(new TraiCay("Dây tây5", "Đay là dâu tây5", R.drawable.girlxinh));



    }
}