package com.example.reference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
//    TextView nameContactDetail;
//    TextView numberContactDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        Bundle bundle = getIntent().getExtras();
        if( bundle == null){
            return;
        }

        TextView nameContactDetail = findViewById(R.id.nameContactDetail);
        TextView numberContactDetail = findViewById(R.id.numberContactDetail);

        Contacts contact = (Contacts) bundle.get("object_contact");
        nameContactDetail.setText(contact.getName());
        numberContactDetail.setText(contact.getNumbers());

    }
}