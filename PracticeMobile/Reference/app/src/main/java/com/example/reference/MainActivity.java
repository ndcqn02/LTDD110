package com.example.reference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.ref.Reference;

public class MainActivity extends AppCompatActivity {

    EditText edtUser, edtPass;
    Button btnSignin;
    CheckBox cbRemenber;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById( R.id.edtPass);
        cbRemenber = findViewById(R.id.cbRemeber);
        btnSignin = findViewById(R.id.btnSignIn);

        sharedPreferences= getSharedPreferences("dataLogin", MODE_PRIVATE);
        // lấy giá trị từ sharePreferences
        edtUser.setText(sharedPreferences.getString("user",""));
        edtPass.setText(sharedPreferences.getString("pass",""));
        cbRemenber.setChecked(sharedPreferences.getBoolean("checked",false));




        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUser.getText().toString().trim();
                String password = edtPass.getText().toString().trim();

                if(username.equals("admin") && password.equals("123")){
                    Toast.makeText( MainActivity.this, "Login successfull",Toast.LENGTH_SHORT).show();

                    //if mà tick vào nhớ
                    if(cbRemenber.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("user", username);
                        editor.putString("pass",password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("user");
                        editor.remove("pass");
                        editor.remove("checked");
                        editor.commit();
                    }


                }else {
                    Toast.makeText( MainActivity.this, "Erorr",Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}