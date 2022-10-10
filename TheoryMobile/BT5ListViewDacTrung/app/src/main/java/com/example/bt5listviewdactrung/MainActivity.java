package com.example.bt5listviewdactrung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvBanBe;
    ArrayList<BanBe> arrayBanBe;
    BanBeAdapter adapter;

    Button btnThem;
    EditText edt;
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem = (Button)  findViewById(R.id.btnThem);
        edt = (EditText) findViewById(R.id.edtext);


        lvBanBe =(ListView) findViewById(R.id.listviewBanBe);
        arrayBanBe = new ArrayList<>();

        AnhXa();
        Adapter adapter = new BanBeAdapter(this, R.layout.mucdobanbe, arrayBanBe);
        lvBanBe.setAdapter((ListAdapter) adapter);




    }

    private void AnhXa() {
        lvBanBe = findViewById(R.id.listviewBanBe);
        arrayBanBe = new ArrayList<>();
        arrayBanBe.add(new BanBe("Nguyễn Đức Cường", "Bạn thân nhất", R.drawable.anhvuong));
        arrayBanBe.add(new BanBe("Nguyễn Văn A", "Bạn bình thường", R.drawable.anhvuong));
        arrayBanBe.add(new BanBe("Nguyễn Văn A", "Bạn bình thường", R.drawable.anhvuong));
        arrayBanBe.add(new BanBe("Nguyễn Văn A", "Bạn bình thường", R.drawable.anhvuong));
        arrayBanBe.add(new BanBe("Nguyễn Văn A", "Bạn bình thường", R.drawable.anhvuong));
        arrayBanBe.add(new BanBe("Nguyễn Văn A", "Bạn bình thường", R.drawable.anhvuong));

    }
}