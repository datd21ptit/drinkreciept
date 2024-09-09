package com.b21dccn216.makeyourowndrink.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.b21dccn216.makeyourowndrink.model.DrinkWithIngredients
import com.b21dccn216.makeyourowndrink.ui.component.AppBar
import com.b21dccn216.makeyourowndrink.ui.component.FoodInformation
import com.b21dccn216.makeyourowndrink.ui.component.IngredientList


@Composable
fun DetailScreen(
    recipe: DrinkWithIngredients
){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        FoodInformation(
            recipe = recipe.drink,
            modifier = Modifier.fillMaxWidth()
        )

        IngredientList(recipe.ingredients)
    }

}


