package com.gunawan.multipleimages.di

import com.gunawan.multipleimages.viewmodel.MultipleImagesViewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    single {
        MultipleImagesViewModel(get())
    }
}