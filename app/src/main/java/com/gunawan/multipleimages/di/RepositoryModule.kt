package com.gunawan.multipleimages.di

import com.gunawan.multipleimages.repository.MultipleImagesRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    single {
        MultipleImagesRepository(get())
    }
}