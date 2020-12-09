package com.gunawan.multipleimages.model

import com.google.gson.annotations.SerializedName

data class RespAddMultipleImages(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
