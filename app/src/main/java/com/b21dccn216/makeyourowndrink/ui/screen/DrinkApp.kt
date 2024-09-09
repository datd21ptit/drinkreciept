package com.b21dccn216.makeyourowndrink.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.b21dccn216.makeyourowndrink.DrinkViewmodel
import com.b21dccn216.makeyourowndrink.R
import com.b21dccn216.makeyourowndrink.model.AppViewModeProvider
import com.b21dccn216.makeyourowndrink.model.Category
import com.b21dccn216.makeyourowndrink.model.Drink
import com.b21dccn216.makeyourowndrink.model.DrinkWithIngredients
import com.b21dccn216.makeyourowndrink.ui.component.AppBar


enum class AppScreen(val title: String){
    Home("Home"),
    Detail("Detail/{drinkId}"),
}

@Composable
fun DrinkApp(
    viewModel: DrinkViewmodel = viewModel(factory = AppViewModeProvider.Factory),
    navController: NavHostController = rememberNavController()
){
    var currentDetail by remember {
        mutableStateOf<DrinkWithIngredients?>(null)
    }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route?: AppScreen.Home.title
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            AppBar(
                title = {
                    when(currentScreen){
                        AppScreen.Home.title -> {
                            Icon(painter = painterResource(id = R.drawable.appbar_icon), contentDescription = null)
                        }
                        AppScreen.Detail.title -> {
                            Text(text = currentDetail?.drink?.name ?: "Loading",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        else -> {
                            Text(text = "Null")
                        }
                    }
                },
                back = {
                    if(navController.previousBackStackEntry != null){
                        IconButton(onClick = {
                            Log.d("Navigation", "DrinkApp: ${navController.previousBackStackEntry}")
                            navController.popBackStack() }) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null)
                        }
                    }
                },
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = AppScreen.Home.name){
                if(!uiState.isLoading) {
                    HomeScreen(
                        recentDrinkList = uiState.recentDrinkList,
                        categories = uiState.categorie,
                        onClickDrink = { drink ->
                            navController.navigate("Detail/${drink.drinkId}")
                        },
                        onCategoryClick = { category ->

                        }
                    )
                }

            }
            
            composable(
                route = AppScreen.Detail.title,
                arguments = listOf(navArgument("drinkId"){type = NavType.LongType})
            ){backStackEntry ->
                val drinkId = backStackEntry.arguments?.getLong("drinkId")
                if(drinkId != null){
                    LaunchedEffect(key1 = drinkId) {
                        currentDetail = viewModel.getDrinkWithIngredients(drinkId)
                    }
                    currentDetail?.let { it ->
                        DetailScreen(recipe = it)
                    }
                }

            }
        }
    }
}