package com.example.luonguisiginsingupprofile;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    EditText username, password;
    Button btnSignin;
    DBHelper DB;
    TextView notHaveAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();  ẩn ActionBar
        setContentView(R.layout.activity_signin);

        username = (EditText) findViewById(R.id.SignIn_Email);
        password = (EditText) findViewById(R.id.SignIn_Password);
        btnSignin = (Button) findViewById(R.id.btnSignIn);
        notHaveAccount = findViewById(R.id.tv_NotHaveAcc);
        DB = new DBHelper(this);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(SigninActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(SigninActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SigninActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        notHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);

            }
        });
    }




}