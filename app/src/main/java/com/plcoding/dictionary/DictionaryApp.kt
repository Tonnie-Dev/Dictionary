package com.plcoding.dictionary

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class DictionaryApp : Application(){

    //create an observable mutable state
    var isDark by mutableStateOf(false)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    
    fun toggleTheme(){

        isDark = !isDark
    }
}