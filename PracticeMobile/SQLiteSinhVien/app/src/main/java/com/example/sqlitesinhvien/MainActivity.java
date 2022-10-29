package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database=null;
    private RecyclerView rcv_Lop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doDeleteDb();
        doCreateDb();

        doCreateTable();
        doInsertRecord();


        initView();

    }

    private void initView() {
        RecyclerView rcv_Lop = findViewById(R.id.rcv_Lop);
        rcv_Lop.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv_Lop.setLayoutManager(linearLayoutManager);
        // them duong divider giua cac item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_Lop.addItemDecoration(itemDecoration);

        ArrayList<Lop> arrayList = new ArrayList<>();
        arrayList = loadalllop();
//        arrayList.add(new Lop("123", "Lap trinh di dong", "20"));

        Toast.makeText(this, arrayList.get(0).getTenlop(), Toast.LENGTH_LONG);


//        LopAdapter adapter = new LopAdapter(arrayList, this);
//        rcv_Lop.setAdapter(adapter);

    }



    public void doCreateDb()
    {
        database=openOrCreateDatabase(
                "qlsinhvien.db",
                MODE_PRIVATE,
                null);
    }
    public void doDeleteDb()
    {
        String msg="";
        if(deleteDatabase("qlsinhvien.db")==true)
        {
            msg="Delete database [qlsinhvien.db] is successful";
        }
        else
        {
            msg="Delete database [qlsinhvien.db] is failed";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    public void doCreateTable()
    {
        doCreateDb();
        doCreateLopTable();
        doCreateSinhvienTable();
    }
    public void doCreateLopTable()
    {
        String sql="CREATE TABLE tbllop (";
        sql+="malop TEXT primary key,";
        sql+="tenlop TEXT,";
        sql+="siso INTEGER)";
        database.execSQL(sql);
    }
    public void doCreateSinhvienTable()
    {
        String sql="CREATE TABLE tblsinhvien ("+
                "masv TEXT PRIMARY KEY ,"+
                "tensv TEXT,"+
                "malop TEXT NOT NULL CONSTRAINT malop "+
                " REFERENCES tbllop(malop) ON DELETE CASCADE)";
        database.execSQL(sql);
    }
    public void doDeleteRecordTable()
    {
        database.delete("tbllop", null, null);
        String malop="DHTH7C";
        database.delete("tbllop",
                "malop=?",
                new String[]{malop});
    }
    public ArrayList<Lop> loadalllop()
    {
        ArrayList<Lop> arrLop = null;
        Cursor c=database.query("tbllop",
                null, null, null, null, null, null);
        c.moveToFirst();

        while(c.isAfterLast()==false)
        {
            arrLop.add(new Lop(c.getString(0), c.getString(1), c.getString(2)));
            c.moveToNext();
        }
        c.close();
        return arrLop;
    }
    public void doInsertRecord()
    {
        ContentValues values=new ContentValues();
        values.put("malop", "DHTH7A");
        values.put("tenlop", "Dai hoc tin hoc 7a");
        values.put("siso", 20);
        String msg="";
        if(database.insert("tbllop", null, values)==-1){
            msg="Failed to insert record";
        }
        else{
            msg="insert record is successful";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void updateLopName(String malop,String new_tenlop)
    {
        ContentValues values=new ContentValues();
        values.put("tenlop", new_tenlop);
        String msg="";
        int ret=database.update("tbllop", values,
                "malop=?", new String[]{malop});
        if(ret==0){
            msg="Failed to update";
        }
        else{
            msg="updating is successful";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }







}