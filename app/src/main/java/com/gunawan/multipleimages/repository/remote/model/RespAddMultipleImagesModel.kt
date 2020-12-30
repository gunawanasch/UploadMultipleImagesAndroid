package com.gunawan.multipleimages.repository.remote.model

import com.google.gson.annotations.SerializedName

data class RespAddMultipleImagesModel(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
