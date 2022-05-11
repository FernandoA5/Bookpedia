package com.example.bookpedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookpedia.Book
import com.example.bookpedia.R

class BookAdapter(private val bookList: List<Book>, private val onClickListener:(Book)-> Unit) : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BookViewHolder(layoutInflater.inflate(R.layout.item_book, parent, false))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = bookList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = bookList.size

}