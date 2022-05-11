package com.example.bookpedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookpedia.adapter.BookAdapter

class RecyclerViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }
    /*
    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = manager
        recyclerView.adapter = BookAdapter(Temporal_provider.Books_List){
                book -> onItemSelected(book)
        }
        recyclerView.addItemDecoration(decoration)
    }

    private fun onItemSelected(book: Book) {
        Toast.makeText(this, book.title, Toast.LENGTH_SHORT).show()
    }*/
}