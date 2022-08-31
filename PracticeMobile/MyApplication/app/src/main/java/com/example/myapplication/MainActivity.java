package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btnLogin); // ánh xạ thẻ có id là btnLogin với thuộc tính btnlogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity2.class);
                startActivity(intent);

            }
        });

//        ArrayList<String> arrayName = new ArrayList<>();
//        arrayName.add("Ha Noi");
//        arrayName.add("Da Nang");
//        arrayName.add("Can Tho");

//        Log.d();
//        Log.d("Phan tu: " + arrayName.get(1));
//        System.out.println("SIZE: " + arrayName.size());
    }
}