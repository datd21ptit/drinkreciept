package com.b21dccn216.makeyourowndrink;

import android.app.Application
import com.b21dccn216.makeyourowndrink.data.AppContainer
import com.b21dccn216.makeyourowndrink.data.AppDataContainer


class DrinkApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}