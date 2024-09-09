package com.b21dccn216.makeyourowndrink.data

import android.content.Context
import com.b21dccn216.makeyourowndrink.model.Drink
import com.b21dccn216.makeyourowndrink.model.DrinkAppDatabase
import com.b21dccn216.makeyourowndrink.model.DrinkAppRepository
import com.b21dccn216.makeyourowndrink.model.DrinkRepository
import com.b21dccn216.makeyourowndrink.model.ItemRepository

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val appRepository: DrinkAppRepository
}

/**
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [AppContainer]
     */
    override val appRepository: DrinkAppRepository by lazy {
        DrinkAppRepository(DrinkAppDatabase.getDatabase(context))
    }
}