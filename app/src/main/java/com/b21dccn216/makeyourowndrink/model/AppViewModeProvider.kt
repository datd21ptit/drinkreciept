package com.b21dccn216.makeyourowndrink.model

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.b21dccn216.makeyourowndrink.DrinkApplication
import com.b21dccn216.makeyourowndrink.DrinkViewmodel

object AppViewModeProvider {
    val Factory = viewModelFactory {
        initializer {
            DrinkViewmodel(drinkApplication().container.appRepository)
        }
    }
}

fun CreationExtras.drinkApplication(): DrinkApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as DrinkApplication)
