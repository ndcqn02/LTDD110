package com.example.listview;

import android.content.Context;
import android.telephony.ims.ImsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter  extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size(); //tra ve so dong cua list
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
        TraiCay traiCay = traiCayList.get(i);

        txtten.setText(traiCay.getTen());
        txtMota.setText(traiCay.getMoTa());
        imgHinh.setImageResource(traiCay.getHinh());



        return view;  // tra ve view
    }
}
