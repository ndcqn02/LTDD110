package com.example.sqlitedienthoai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMobileActivity extends AppCompatActivity {
    EditText edt_id, edt_name, edt_quantity;
    Button btn_add, btn_modified, btn_delete;
    Mydatabase mydatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mobile);

        initViewListener();
    }

    private void initViewListener() {
        mydatabase = new Mydatabase(this);
        MainActivity mainActivity = new MainActivity();


        btn_add = findViewById(R.id.btn_add);
        btn_modified = findViewById(R.id.btn_modified);
        btn_delete = findViewById(R.id.btn_delete);
        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        edt_quantity = findViewById(R.id.edt_quantity);



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mobile mobile = new Mobile(edt_id.getText().toString(), edt_name.getText().toString(), edt_quantity.getText().toString());

                mydatabase.insertMobile(mobile);
                Intent intent = new Intent(AddMobileActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btn_modified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mobile mobile = new Mobile(edt_id.getText().toString(), edt_name.getText().toString(), edt_quantity.getText().toString());
                mydatabase.updateMobile(mobile);
                Intent intent = new Intent(AddMobileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydatabase.deleteMobile(edt_id.getText().toString());
                Intent intent = new Intent(AddMobileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}