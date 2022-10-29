package com.example.sqlitesinhvien;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LopAdapter extends  RecyclerView.Adapter<LopAdapter.ViewHolder>{
    private List<Lop> list;
    private Context mcontext;

    public LopAdapter(List<Lop> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lop, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lop lop = list.get(position);
        if (lop == null){
            return;
        }

        holder.tv_MaLop.setText(lop.getMalop().toString());
        holder.tv_TenLop.setText(lop.getTenlop().toString());
        holder.tv_SiSo.setText(lop.getSiso());

    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_TenLop;
        private TextView tv_MaLop;
        private TextView tv_SiSo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_MaLop = itemView.findViewById(R.id.tv_MaLop);
            tv_TenLop= itemView.findViewById(R.id.tv_TenLop);
            tv_SiSo= itemView.findViewById(R.id.tv_SiSo);
        }
    }

}
