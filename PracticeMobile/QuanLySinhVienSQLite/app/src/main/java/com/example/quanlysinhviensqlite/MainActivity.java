package com.example.quanlysinhviensqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersDatabaseAdapter usersDatabaseAdapter = new UsersDatabaseAdapter(getApplicationContext());
    }
    //open activity to Insert new rows in table
    public void insertRowActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, InsertRowActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    //Open activity to update rows
    public void updateRowView(View view) {
        Intent myIntent = new Intent(MainActivity.this, UpdateRowsActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    //call method to show rows count in Toast
    public void rowCount(View view) {
//        UsersDatabaseAdapter.getRowCount();
    }

    //Open activity to delete rows
    public void deleteRowActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, deleteRowsActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    //Button method to truncate table rows
//    public void truncateTable(View view) {
//        UsersDatabaseAdapter.truncateTable();
//    }

    //Open URL in browser
    public void goToUrl (View view) {
        String url = "https://timoday.edu.vn";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}