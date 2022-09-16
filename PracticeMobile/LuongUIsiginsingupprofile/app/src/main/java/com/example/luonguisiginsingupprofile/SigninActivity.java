package com.example.luonguisiginsingupprofile;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SigninActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();  ẩn ActionBar
        setContentView(R.layout.activity_signin);
        EditText email = findViewById(R.id.SignIn_Email);
        EditText pass = findViewById(R.id.SignIn_Password);
        Button signin =  findViewById(R.id.btnSignIn);
        TextView notHaveAccount = findViewById(R.id.tv_NotHaveAcc);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("admin")  && pass.getText().toString().equals("admin")){
                    Intent intent = new Intent(SigninActivity.this, ProfileActivity.class);
                    startActivity(intent);
                }
            }
        });


        notHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAcc = new Intent(SigninActivity.this, signupActivity.class);
                startActivity(intentAcc);
            }
        });
    }





}