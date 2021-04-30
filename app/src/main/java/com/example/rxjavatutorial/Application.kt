package com.example.rxjavatutorial

import android.app.Application
import android.content.res.Configuration
import android.util.Log

/**
 * @author at-vinhnguyen on 4/23/21.
 */
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("xxx", "Application: onCreate()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.i("xxx", "Application: onConfigurationChanged()")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.i("xxx", "Application: onLowMemory()")
    }
}
