package com.gunawan.multipleimages.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gunawan.multipleimages.databinding.RowAddImageBinding
import java.io.File

class AddImageAdapter(private val listImage: List<File>) : RecyclerView.Adapter<AddImageAdapter.ViewHolder>() {
    private var listener: OnCustomClickListener? = null

    interface OnCustomClickListener {
        fun onDeleteClicked(position: Int)
    }

    fun setOnCustomClickListener(listener: OnCustomClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowAddImageBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        Glide.with(holder.itemView.context).load(listImage[position]).into(holder.binding.ivImage)
        holder.binding.ivDelete.setOnClickListener {
            listener?.onDeleteClicked(position)
        }
    }

    class ViewHolder(val binding: RowAddImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {}
    }
}