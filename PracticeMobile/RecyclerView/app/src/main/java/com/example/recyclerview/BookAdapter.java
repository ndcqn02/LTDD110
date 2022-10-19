package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter  extends  RecyclerView.Adapter<BookAdapter.BookViewHodler>{
    private List<Book> mBook;

    public void setData(List<Book> list){
        this.mBook = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BookViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHodler holder, int position) {
        Book book = mBook.get(position);
        if(book == null)
            return;
        holder.imgBook.setImageResource(book.getResourceId());
        holder.tvTitle.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        if (mBook != null)
            return mBook.size();
        return 0;
    }

    public class BookViewHodler extends RecyclerView.ViewHolder {
        private ImageView imgBook;
        private TextView tvTitle;

        public BookViewHodler(@NonNull View itemView) {
            super(itemView);


            imgBook = itemView.findViewById(R.id.img_book);
            tvTitle = itemView.findViewById( R.id.tv_title);

        }
    }

}
