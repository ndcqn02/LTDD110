package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThem, btnCapNhat;
    EditText edt;
    ListView listViewMonHoc;
    ArrayList<String> arrayCourses;
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        btnThem = (Button)  findViewById(R.id.btnThem);
        edt = (EditText) findViewById(R.id.edtext);

        listViewMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        arrayCourses = new ArrayList<>();

        arrayCourses.add("Mang may tinh");
        arrayCourses.add("Lap trinh C");
        arrayCourses.add("Lap trinh di dong");
        arrayCourses.add("Java nang cao");
        arrayCourses.add("Mang may tinh");








        final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourses);

        listViewMonHoc.setAdapter(adapter);

        listViewMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt.setText(arrayCourses.get(i));
                vitri = i;
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourses.set(vitri, edt.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        listViewMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourses.remove(i);
                adapter.notifyDataSetChanged();

                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = edt.getText().toString();
                arrayCourses.add(monhoc);
                adapter.notifyDataSetChanged();  // cap nhap lai du lieu trong listview
            }
        });


    }
}