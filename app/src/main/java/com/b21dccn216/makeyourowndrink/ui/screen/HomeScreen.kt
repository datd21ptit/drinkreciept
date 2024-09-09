package com.b21dccn216.makeyourowndrink.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.b21dccn216.makeyourowndrink.model.Category
import com.b21dccn216.makeyourowndrink.model.Drink
import com.b21dccn216.makeyourowndrink.ui.component.CategoryItem
import com.b21dccn216.makeyourowndrink.ui.component.MixBox
import com.b21dccn216.makeyourowndrink.ui.component.TitleAndContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    recentDrinkList: List<Drink>,
    categories: List<Pair<Category, Int>>,
    onCategoryClick: (Category) -> Unit = {},
    onClickDrink: (Drink) -> Unit = {}
){
    var contentTextField by remember {
        mutableStateOf("")
    }
    Column{
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "I want to learn...",
            style = TextStyle(
                fontSize = 30.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Row(
            modifier = Modifier
//                    .height(35.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 12.dp)
                .background(color = Color.Transparent)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            TextField(
                value = contentTextField,
                textStyle = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    lineHeight = 34.sp
                ),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                onValueChange = { contentTextField = it},
                placeholder = {
                    Text(text = "Search", modifier = Modifier.fillMaxSize())
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                )
            )
        }

        TitleAndContent(title = "Categories", content = {
            LazyRow (
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(categories){item ->
                    CategoryItem(
                        pair = item,
                        onClickCategory = onCategoryClick)
                }
            }
        })
        TitleAndContent(title = "Recent Mixes", content = {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(48.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(recentDrinkList) { item ->
                    MixBox(
                        recipe = item,
                        onClickDrink = onClickDrink)
                }
            }
        })
//        }
    }
}



