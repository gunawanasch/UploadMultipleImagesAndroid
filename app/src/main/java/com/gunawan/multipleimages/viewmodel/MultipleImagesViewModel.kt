package com.gunawan.multipleimages.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.gunawan.multipleimages.repository.remote.model.RespAddMultipleImagesModel
import com.gunawan.multipleimages.repository.remote.model.RespMultipleImagesModel
import com.gunawan.multipleimages.repository.MultipleImagesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.File

class MultipleImagesViewModel(private val repo: MultipleImagesRepository) : ViewModel() {
    private var disposables = CompositeDisposable()
    var ldRespMultipleImages = MutableLiveData<List<RespMultipleImagesModel>>()
    var ldRespAddMultipleImages = MutableLiveData<RespAddMultipleImagesModel>()
    var ldMsg = MutableLiveData<String>()

    fun getMultipleImages() {
        disposables.add(
            repo.getAllMultipleImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {}
                .doOnComplete {}
                .doOnError {
                    ldMsg.value = it.message
                }
                .subscribe {
                    ldRespMultipleImages.value = it
                }
        )
    }

    fun addMultipleImages(name: String, listImage: MutableList<File>) {
        disposables.add(
            repo.addMultipleImages(name, listImage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {}
                .doOnComplete {}
                .doOnError {
                    ldMsg.value = it.message
                }
                .subscribe {
                    val response = Gson().fromJson(it.string(), RespAddMultipleImagesModel::class.java)
                    ldRespAddMultipleImages.value = response
                }
        )
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        if (!disposables.isDisposed) disposables.dispose()
    }

}