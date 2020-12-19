package com.gunawan.multipleimages.repository

import com.gunawan.multipleimages.repository.remote.model.RespMultipleImagesModel
import com.gunawan.multipleimages.repository.remote.ApiService
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import java.io.File


class MultipleImagesRepository(val api: ApiService) {

    fun getAllMultipleImages(): Observable<List<RespMultipleImagesModel>> {
        return api.getAllMultipleImages()
    }

    fun addMultipleImages(name: String, listImage: MutableList<File>): Observable<ResponseBody> {
        val nameRequest: RequestBody = RequestBody.create(MediaType.parse("text/plain"), name)
        val listMultipartImage: MutableList<MultipartBody.Part> = ArrayList()
        for (i in 0 until listImage.size) {
            listMultipartImage.add(
                MultipartBody.Part.createFormData(
                    "image["+i+"]",
                    listImage[i].name,
                    RequestBody.create(MediaType.parse("image/*"), listImage[i])
                )
            )
        }
        return api.addMultipleImages(nameRequest, listMultipartImage)
    }

}