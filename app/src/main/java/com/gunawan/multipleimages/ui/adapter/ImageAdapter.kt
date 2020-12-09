package com.gunawan.multipleimages.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gunawan.multipleimages.databinding.RowImageBinding
import com.gunawan.multipleimages.model.ListImageItem

class ImageAdapter(private val listImage: List<ListImageItem>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowImageBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        Glide.with(holder.itemView.context).load("https://apici.teknoguna.com/api_upload_multiple_images/assets/images/"+listImage[position].filename).into(holder.binding.ivImage)
    }

    class ViewHolder(val binding: RowImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {}
    }
}