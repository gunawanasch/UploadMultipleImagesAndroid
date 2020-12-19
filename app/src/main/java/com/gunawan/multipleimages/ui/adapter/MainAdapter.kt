package com.gunawan.multipleimages.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gunawan.multipleimages.databinding.RowMultipleImagesBinding
import com.gunawan.multipleimages.repository.remote.model.ListImageItem
import com.gunawan.multipleimages.repository.remote.model.RespMultipleImagesModel

class MainAdapter(private val listMultpleImages: List<RespMultipleImagesModel>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private lateinit var adapter: ImageAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowMultipleImagesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return listMultpleImages.size
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMultpleImages[position])
        holder.binding.rvImage.setHasFixedSize(true)
        holder.binding.rvImage.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        adapter = ImageAdapter(listMultpleImages[position].listImage as List<ListImageItem>)
        adapter.notifyDataSetChanged()
        holder.binding.rvImage.adapter = adapter
    }

    class ViewHolder(val binding: RowMultipleImagesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RespMultipleImagesModel) {
            binding.item = item
        }
    }
}