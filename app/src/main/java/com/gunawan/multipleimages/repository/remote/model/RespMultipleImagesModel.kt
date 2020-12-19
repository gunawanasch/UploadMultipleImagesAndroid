package com.gunawan.multipleimages.repository.remote.model

import com.google.gson.annotations.SerializedName

data class RespMultipleImagesModel(

    @field:SerializedName("list_image")
	val listImage: List<ListImageItem?>? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("id_title")
	val idTitle: String? = null
)

data class ListImageItem(

	@field:SerializedName("filename")
	val filename: String? = null,

	@field:SerializedName("id_image")
	val idImage: String? = null
)
