package com.example.reference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Contacts> list;
    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder holder, int position) {
        Contacts contact = list.get(position);
        if (contact ==  null)
            return;
        holder.nameContact.setText(contact.getName());
        holder.numberContact.setText(contact.getNumbers());
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameContact = itemView.findViewById(R.id.nameContact);
            numberContact = itemView.findViewById(R.id.numberContact);

        }
    }
}
