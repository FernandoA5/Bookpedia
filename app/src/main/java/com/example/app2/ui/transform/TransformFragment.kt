package com.example.app2.ui.transform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app2.R
import com.example.app2.databinding.FragmentTransformBinding
import com.example.app2.databinding.ItemTransformBinding

class TransformFragment : Fragment() {

    private var _binding: FragmentTransformBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val transformViewModel = ViewModelProvider(this).get(TransformViewModel::class.java)
        _binding = FragmentTransformBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerviewTransform
        val adapter = TransformAdapter()
        recyclerView.adapter = adapter
        transformViewModel.texts.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class TransformAdapter : ListAdapter<String, TransformViewHolder>(object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        })
    {

        private val drawables = listOf(
            R.drawable.avatar_1,
            R.drawable.avatar_2,
            R.drawable.avatar_3,
            R.drawable.avatar_4,
            R.drawable.avatar_5,
            R.drawable.avatar_6,
            R.drawable.avatar_7,
            R.drawable.avatar_8,
            R.drawable.avatar_9,
            R.drawable.avatar_10,
            R.drawable.avatar_11,
            R.drawable.avatar_12,
            R.drawable.avatar_13,
            R.drawable.avatar_14,
            R.drawable.avatar_15,
            R.drawable.avatar_16,
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransformViewHolder {
            val binding = ItemTransformBinding.inflate(LayoutInflater.from(parent.context))
            return TransformViewHolder(binding)
        }

        override fun onBindViewHolder(holder: TransformViewHolder, position: Int) {
            holder.title?.text = getItem(position)
            //ESTO MUESTRA LA IMAGEN
            //
            // SI QUITAS ITEMS DE drawables, SE MUESTRAN MENOS ELEMENTOS EN EL RV PERO CRASHEA.
            //Si COMENTAS ESTA LINEA, YA NO CRASHEA, PERO MUESTRA 16 ELEMENTOS AUNQUE drawables TENGA MENOS.
            holder.imagen?.setImageDrawable(ResourcesCompat.getDrawable(holder.imagen.resources, drawables[position], null))

            holder.author?.text = getItem(position)
        }
    }

    class TransformViewHolder(binding: ItemTransformBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imagen: ImageView? = binding.imageViewBook
        val title: TextView? = binding.textViewBook
        val author: TextView? = binding.textViewAuthor
    }
}