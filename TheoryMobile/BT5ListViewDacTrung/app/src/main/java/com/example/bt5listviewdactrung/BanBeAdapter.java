package com.example.bt5listviewdactrung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class BanBeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<BanBe> BanBeList;

    public BanBeAdapter(Context context, int layout, List<BanBe> banBeList) {
        this.context = context;
        this.layout = layout;
        BanBeList = banBeList;
    }


    @Override
    public int getCount() {
        return BanBeList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        view = inflater.inflate(layout, null);  // de chua layout




        // anh xa view
        TextView txtten = view.findViewById(R.id.texviewTen);
        TextView txtMota = view.findViewById(R.id.texviewMoTa);
        ImageView imgHinh = view.findViewById(R.id.imageviewHinh);

        //gan gia tri
       BanBe banBe = BanBeList.get(i);

        txtten.setText(banBe.getTen());
        txtMota.setText(banBe.getMoTa());
        imgHinh.setImageResource(banBe.getHinh());


        return view;
    }
}
