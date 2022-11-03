package com.example.sqlitedienthoai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.ViewHolder>{
    private List<Category> mlist;
    private Context mcontext;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = mlist.get(position);
        if (category == null )
            return;

        holder.tv_nameCategory.setText(category.getName());
        holder.tv_idCategory.setText(category.getId());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mcontext, RecyclerView.VERTICAL, false);
        holder.rcv_Category.setLayoutManager(linearLayoutManager);

//        AdapterMobile adapterMobile = new AdapterMobile( );


    }

    @Override
    public int getItemCount() {
        if(mlist !=  null)
            return mlist.size();
        return 0;
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nameCategory, tv_idCategory;
        RecyclerView rcv_Category;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           tv_nameCategory = itemView.findViewById(R.id.tv_nameCategory);
           tv_idCategory = itemView.findViewById(R.id.tv_nameCategory);
           rcv_Category = itemView.findViewById(R.id.rcv_Category);
       }
   }
}
