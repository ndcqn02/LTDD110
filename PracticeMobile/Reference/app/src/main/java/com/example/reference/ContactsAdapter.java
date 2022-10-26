package com.example.reference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter> {
    List<Contacts> list;

    public void setData(List<Contacts> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_adapter);



    }


    @NonNull
    @Override
    public ContactsAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}