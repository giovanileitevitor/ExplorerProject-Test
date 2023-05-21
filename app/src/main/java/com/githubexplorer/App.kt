package com.githubexplorer

import android.app.Application
import com.githubexplorer.AppComponent.getAllModules
import com.githubexplorer.features.projectlist.di.projectListModule
import com.githubexplorer.features.projectlist.di.userListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() = startKoin {
        androidContext(this@App)
        koin.loadModules(getAllModules())
    }
}

object AppComponent{
    fun getAllModules(): List<Module> = listOf(*getAppModules())

    private fun getAppModules(): Array<Module>{
        return arrayOf(
            projectListModule,
            userListModule
        )
    }
}