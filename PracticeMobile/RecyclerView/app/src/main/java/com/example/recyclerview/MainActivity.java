package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private  RecyclerView rcv_Category;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        RecyclerView recyclerView = findViewById(R.id.rcv_Category);
        recyclerView.setHasFixedSize(true); // toi uu hoa du lieu khong bi anh boi noi dung trong adapter

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<DataShop> arrayList = new ArrayList<>();
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));
        arrayList.add(new DataShop(R.drawable.anh1,"anh dep"));

        ShopAdapter adapter = new ShopAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(adapter);




        ////////////////////

//        rcv_Category = findViewById(R.id.rcv_Category);
//        categoryAdapter = new CategoryAdapter(this.getApplicationContext());
//
//        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        rcv_Category.setLayoutManager(linearLayoutManager1);
//
//        categoryAdapter.setDaTa(getCategory());
//        rcv_Category.setAdapter(categoryAdapter);
    }

    private List<Category> getCategory(){
        List<Category> listCategory  = new ArrayList<>();

        List<Book> listBook = new ArrayList<>();
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 1" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 2" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 3" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 4" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 5" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 6" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 7" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 8" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 9" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 10" ));
        listBook.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 11" ));


        List<Book> listBook2 = new ArrayList<>();
        listBook2.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 1" ));
        listBook2.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 2" ));
        listBook2.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 3" ));
        listBook2.add( new Book(R.drawable.anh1,"Sach Thau Tom Tam Ly 4" ));

        List<DataShop> listDataShop = new ArrayList<>();
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));
        listDataShop.add(new DataShop(R.drawable.imagegirl,"anh dep"));

        listCategory.add(new Category("Category1", listBook));
        listCategory.add(new Category("Category2", listBook));
        listCategory.add(new Category("Category3", listBook));

//        listCategory.add(new Category("Category4", listDataShop));




        return  listCategory;
    }

}