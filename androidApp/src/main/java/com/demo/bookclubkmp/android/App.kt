package com.demo.bookclubkmp.android

import android.app.Application
import com.demo.bookclubkmp.android.di.viewModelModule
import com.demo.bookclubkmp.di.AppDIKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppDIKoin.getKoin().loadModules(listOf(viewModelModule))
    }
}