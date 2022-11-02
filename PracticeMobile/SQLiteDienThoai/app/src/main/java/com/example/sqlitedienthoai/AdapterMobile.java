package com.example.sqlitedienthoai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMobile extends RecyclerView.Adapter<AdapterMobile.ViewHolder> {
    private Context mcontext;
    private List<Mobile> mlist;

    public AdapterMobile( List<Mobile> mlist) {
        this.mlist = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mobile mobile = mlist.get(position);
        if (mobile == null){
            return;
        }

        holder.tv_name.setText(mobile.getName());
        holder.tv_describe.setText(mobile.getId());
        holder.tv_quatity.setText(mobile.getQuantity());
    }

    @Override
    public int getItemCount() {
        if (mlist != null){
            return mlist.size();
        }
        return 0;
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name, tv_describe, tv_quatity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_describe = itemView.findViewById(R.id.tv_id);
            tv_quatity = itemView.findViewById(R.id.tv_quantity);
        }
    }
}
