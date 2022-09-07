package com.example.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnClick;  // khai bao kieu element
    private EditText editTextKL, editTextCC;
    private TextView textView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button) findViewById(R.id.button) ;   // bat id
        editTextKL = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextCC = (EditText) findViewById(R.id.editTextTextPersonName2);
        textView6 = (TextView) findViewById(R.id.textView6);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueKL = editTextKL.getText().toString();
                String valueCC = editTextCC.getText().toString();

                Double weight =Double.parseDouble(valueKL);
                Double height =Double.parseDouble(valueCC);

                Double result = weight / (height * height);
                textView6.setText(result + "");
            }
        });


    }
}