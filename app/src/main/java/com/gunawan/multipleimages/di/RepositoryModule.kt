package com.gunawan.multipleimages.di

import com.gunawan.multipleimages.repository.remote.MultipleImagesRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    single {
        MultipleImagesRepository(get())
    }
}