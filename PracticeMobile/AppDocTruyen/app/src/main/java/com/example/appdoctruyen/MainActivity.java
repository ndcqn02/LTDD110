package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.appdoctruyen.adapter.TruyenTranhAdapter;
import com.example.appdoctruyen.api.ApiLayTruyen;
import com.example.appdoctruyen.interfaces.LayTruyenVe;
import com.example.appdoctruyen.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayTruyenVe {

    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;
    EditText editTimKiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        anhxa();
        setup();
        setClick();
        new ApiLayTruyen(this).execute();

    }


    private void init() {
        truyenTranhArrayList = new ArrayList<>();
       truyenTranhArrayList.add(new TruyenTranh("VÕ LUYỆN ĐỈNH PHONG", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/32/vo-luyen-dinh-phong.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Gate - Jietai Kare no Chi nite, Kaku Tatakeri", "Chapter 105", "https://st.ntcdntempv3.com/data/comics/58/gate-jietai-kare-no-chi-nite-kaku-tatakeri.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Tôi Không Phải Là Cinderella", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/146/toi-khong-phai-la-cinderella.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Thế Thân Hào Môn", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/28/the-than-hao-mon.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("VÕ LUYỆN ĐỈNH PHONG", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/32/vo-luyen-dinh-phong.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Gate - Jietai Kare no Chi nite, Kaku Tatakeri", "Chapter 105", "https://st.ntcdntempv3.com/data/comics/58/gate-jietai-kare-no-chi-nite-kaku-tatakeri.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Tôi Không Phải Là Cinderella", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/146/toi-khong-phai-la-cinderella.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Thế Thân Hào Môn", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/28/the-than-hao-mon.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("VÕ LUYỆN ĐỈNH PHONG", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/32/vo-luyen-dinh-phong.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Gate - Jietai Kare no Chi nite, Kaku Tatakeri", "Chapter 105", "https://st.ntcdntempv3.com/data/comics/58/gate-jietai-kare-no-chi-nite-kaku-tatakeri.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Tôi Không Phải Là Cinderella", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/146/toi-khong-phai-la-cinderella.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Thế Thân Hào Môn", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/28/the-than-hao-mon.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("VÕ LUYỆN ĐỈNH PHONG", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/32/vo-luyen-dinh-phong.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Gate - Jietai Kare no Chi nite, Kaku Tatakeri", "Chapter 105", "https://st.ntcdntempv3.com/data/comics/58/gate-jietai-kare-no-chi-nite-kaku-tatakeri.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Tôi Không Phải Là Cinderella", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/146/toi-khong-phai-la-cinderella.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Thế Thân Hào Môn", "Chapter 2657", "https://st.ntcdntempv3.com/data/comics/28/the-than-hao-mon.jpg"));

        adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);


    }

    private void anhxa() {
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        editTimKiem = findViewById(R.id.editTiemKiem);
    }

    private void setup() {
        gdvDSTruyen.setAdapter(adapter);
    }

    private void setClick() {
        editTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editTimKiem.getText().toString();
                adapter.sortTruyen(s);
            }
        });
    }



    @Override
    public void batDau() {
        Toast.makeText(this,"Dang lay ve", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            truyenTranhArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for (int i =0 ; i< arr.length(); i++){
                JSONObject o = arr.getJSONObject(i);
                truyenTranhArrayList.add(new TruyenTranh(o));

                adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
                gdvDSTruyen.setAdapter(adapter);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void biLoi() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}