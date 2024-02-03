package com.example.marvelapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    companion object {
        const val TAG = "MarvelApplication"
    }
}