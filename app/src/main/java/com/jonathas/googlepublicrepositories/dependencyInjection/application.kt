package com.jonathas.googlepublicrepositories.dependencyInjection

import com.jonathas.googlepublicrepositories.ui.home.GetDataUseCase
import com.jonathas.googlepublicrepositories.ui.home.HomeViewModel
import org.koin.dsl.module

val application = module {

    factory { HomeViewModel(get()) }

    factory { GetDataUseCase(get()) }
}