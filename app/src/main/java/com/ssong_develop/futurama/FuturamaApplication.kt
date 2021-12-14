package com.ssong_develop.futurama

import android.app.Application
import com.ssong_develop.utils.ImageLoader
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FuturamaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ImageLoader.initialize(this)
    }
}