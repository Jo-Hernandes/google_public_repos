package com.jonathas.googlepublicrepositories

import android.app.Application
import com.jonathas.googlepublicrepositories.dependencyInjection.application
import com.jonathas.googlepublicrepositories.dependencyInjection.dataSource
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class GoogleReposApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@GoogleReposApplication)
            modules(application + dataSource)
        }
    }

}