package com.example.sqlitesinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QLSinhVien.db";
    private  static final String TABLE_NAME = "Lop";
    private static final String KEY_MA_SV = "maSV";
    private static final String KEY_TEN_SV = "tenSV";
    private static final String KEY_MO_TA = "moTa";


    public MyDatabase( Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_lop = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT, %s TEXT )",TABLE_NAME, KEY_MA_SV, KEY_TEN_SV, KEY_MO_TA);
        sqLiteDatabase.execSQL(create_table_lop);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop_table_lop = String.format("DROP TABLE IF EXITS %s", TABLE_NAME);
        sqLiteDatabase.execSQL(drop_table_lop);
        onCreate(sqLiteDatabase);
    }



    public void insertLop(String maLop, String tenLop, String siSo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MA_SV, maLop);
        values.put(KEY_TEN_SV,tenLop);
        values.put(KEY_MO_TA, siSo);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateLop(String maLop, String tenLop, String siSo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TEN_SV, tenLop);
        values.put(KEY_MO_TA, siSo);
        db.update(TABLE_NAME, values, KEY_MA_SV + "=?", new String[]{maLop});
        db.close();
    }

    public void deleteLop(String maLop){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_MA_SV + "=?", new String[] {maLop}); // ep kieu neu khac String
        db.close();
    }

    public List<SinhVien> readAllLop(){
        List<SinhVien> listSinhVien = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            listSinhVien.add(new SinhVien(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        return listSinhVien;
    }


}
