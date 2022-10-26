package com.example.reference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {


    private List<Contacts> list;
    private Context mcontext;

    public ContactsAdapter(List<Contacts> list, Context context) {
        this.list = list;
        this.mcontext = context;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder holder, int position) {
        final  Contacts contact = list.get(position);
        if (contact ==  null)
            return;
        holder.nameContact.setText(list.get(position).getName());
        holder.numberContact.setText(list.get(position).getNumbers());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickGoToDeTail(contact);
            }
        });

    }

    private void OnClickGoToDeTail(Contacts contact){
        Intent intent = new Intent(mcontext, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_contact", contact);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }

    public void Release(){
        mcontext = null;
    }


    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameContact;
        private TextView numberContact;
        private ConstraintLayout layoutItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameContact = itemView.findViewById(R.id.nameContact);
            numberContact = itemView.findViewById(R.id.numberContact);
            layoutItem = itemView.findViewById(R.id.layout_item);
        }
    }
}
