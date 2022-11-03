package com.example.sqlitedienthoai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Mydatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QLDienThoai.db";
    private static final String TABLE_NAME = "Mobile";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_QUANTITY = "quantity";
    private static final String TABLE_NAME_CATEGORY = "category";
    private static final String KEY_ID_CATEGORY = "idCategory";
    private static final String KEY_NAME_CATEGORY = "nameCategory";

    public Mydatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create_table_category = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT )", TABLE_NAME_CATEGORY, KEY_ID_CATEGORY, KEY_NAME_CATEGORY);
        String create_table_mobile = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT, %s TEXT )", TABLE_NAME, KEY_ID, KEY_NAME, KEY_QUANTITY);
        sqLiteDatabase.execSQL(create_table_category);
        sqLiteDatabase.execSQL(create_table_mobile);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String crop_table_mobile = String.format("DROP TABLE IF EXITS %s", TABLE_NAME);
        String crop_table_category = String.format("DROP TABLE IF EXITS %s", TABLE_NAME_CATEGORY);
        sqLiteDatabase.execSQL(crop_table_mobile);
        sqLiteDatabase.execSQL(crop_table_category);
        onCreate(sqLiteDatabase);
    }

    public void insertMobile(Mobile mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, mobile.getId());
        values.put(KEY_NAME, mobile.getName());
        values.put(KEY_QUANTITY, mobile.getQuantity());
        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public void updateMobile(Mobile mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, mobile.getName());
        values.put(KEY_QUANTITY, mobile.getQuantity());

        db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[]{mobile.getId()});
        db.close();
    }

    public void deleteMobile(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]{id});
        db.close();
    }

    public List<Mobile> readAllMobile() {
        List<Mobile> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            arrayList.add(new Mobile(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        return arrayList;
    }


    public void insertCategory(String id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_CATEGORY, id);
        values.put(KEY_NAME_CATEGORY, name);

        db.insert(TABLE_NAME_CATEGORY, null, values);
        db.close();
    }

    public void deleteCategory(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_CATEGORY,"id = ?", new String[]{id} );
    }

    public List<Category> readAllCategory(){
        List<Category> listCategory = new  ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_CATEGORY, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false){
            listCategory.add(new Category(cursor.getString(0), cursor.getString(1)));
            cursor.moveToNext();
        }
        return listCategory;
    }



}
