package com.example.bookpedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookpedia.adapter.BookAdapter
import com.example.bookpedia.databinding.FragmentRecyclerViewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RecyclerViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerBooks: RecyclerView
    private lateinit var binding: FragmentRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val view: View = inflater.inflate(R.layout.fragment_recycler_view, container, false)

        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)

        val manager = LinearLayoutManager(requireContext())
        val decoration = DividerItemDecoration(requireContext(), manager.orientation)
        val recyclerView = binding.recyclerViewFragment
        recyclerView.layoutManager = manager
        recyclerView.adapter = BookAdapter(Temporal_provider.Books_List){
                book -> onItemSelected(book)
        }
        recyclerView.addItemDecoration(decoration)

        return binding.recyclerViewFragment

    }
    private fun onItemSelected(book: Book) {
        Toast.makeText(requireContext(), book.title, Toast.LENGTH_SHORT).show()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecyclerViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                RecyclerViewFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
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

    */
}