package com.jonathas.googlepublicrepositories.dependencyInjection

import com.jonathas.googlepublicrepositories.repository.GitReposRepository
import com.jonathas.googlepublicrepositories.repository.RestServiceImpl
import com.jonathas.googlepublicrepositories.repository.WebClient
import org.koin.dsl.module

val dataSource = module {

    factory {
        return@factory GitReposRepository()
    }

    factory {
        return@factory RestServiceImpl(get()).provideWebService()
    }

    factory {
        return@factory WebClient()
    }

}
