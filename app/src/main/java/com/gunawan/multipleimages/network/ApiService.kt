package com.gunawan.multipleimages.network

import com.gunawan.multipleimages.model.RespMultipleImagesModel
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiService {

    @GET("MultipleImages/getAllMultipleImages")
    fun getAllMultipleImages(): Observable<List<RespMultipleImagesModel>>

    @Multipart
    @POST("MultipleImages/addMultipleImages")
    fun addMultipleImages(@Part("name") name: RequestBody, @Part listImage: MutableList<MultipartBody.Part>): Observable<ResponseBody>

}