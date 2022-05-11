package com.example.bookpedia.adapter

import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookpedia.Book
import com.example.bookpedia.databinding.ItemBookBinding

class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemBookBinding.bind(view)
    //FUNCIÓN QUE DEFINE LOS VALORES DE CADA ELEMÉNTO
    fun render(bookModel: Book, onClickListener: (Book)-> Unit){
        //SETTEAMOS TEXTOS
        binding.textViewBook.text=bookModel.title
        binding.textViewAuthor.text=bookModel.author

        //SETTEAMOS IMAGEN

        Glide.with(binding.imageViewBook.context).load(bookModel.image).into(binding.imageViewBook)
        itemView.setOnClickListener{
            onClickListener(bookModel)
        }
    }
}