package com.b21dccn216.makeyourowndrink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.b21dccn216.makeyourowndrink.model.DrinkAppDatabase
import com.b21dccn216.makeyourowndrink.ui.screen.DrinkApp
import com.b21dccn216.makeyourowndrink.ui.theme.MakeYourOwnDrinkTheme


// This project clone UI from link below
// https://www.figma.com/design/iUKb1HjSS7NrhbGdxjCxb3/Make-Your-Own-Drink-App-(Community)?node-id=0-1&t=1dqgN7fQkKRBKCXW-0
// Dat
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MakeYourOwnDrinkTheme {
                DrinkApp()
            }
        }
    }
}

