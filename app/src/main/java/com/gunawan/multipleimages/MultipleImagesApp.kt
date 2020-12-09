package com.gunawan.multipleimages

import android.app.Application
import com.gunawan.multipleimages.di.networkModule
import com.gunawan.multipleimages.di.repositoryModule
import com.gunawan.multipleimages.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MultipleImagesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(networkModule, repositoryModule, viewModelModule))
    }
}