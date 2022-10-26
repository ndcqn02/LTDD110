package com.example.reference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainContactsActivity extends AppCompatActivity {
    RecyclerView rcvContact;
    ArrayList<Contacts> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contacts);


        initView();
    }
    private void initView() {
        rcvContact = findViewById(R.id.rcvContact);
        rcvContact.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvContact.setLayoutManager(linearLayoutManager);


        getPhoneContacts();
        
        ContactsAdapter adapter = new ContactsAdapter(arrayList , getApplicationContext());
        rcvContact.setAdapter(adapter);

    }


    public ArrayList<Contacts> getPhoneContacts(){



        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS},0 );
        }
        ContentResolver contentProvider = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentProvider.query(uri, null, null, null , null);
        Log.i("CONTACT_PROVIDER_DEMO", "TOTAL # of Contacts ::: " + Integer.toString(cursor.getCount()));

        if (cursor.getCount() > 0){
            while(cursor.moveToNext()){
                @SuppressLint("Range") String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                arrayList.add(new Contacts(contactName, contactNumber));

                Log.i("CONTACT_PROVIDER_DEMO", "Contact Name  :::  " + contactName  + " Ph# ::: " + contactNumber);
            }
        }
        return arrayList;
    }


}