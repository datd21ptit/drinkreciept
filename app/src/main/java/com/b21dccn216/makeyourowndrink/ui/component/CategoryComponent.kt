package com.b21dccn216.makeyourowndrink.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.b21dccn216.makeyourowndrink.model.Category
import com.b21dccn216.makeyourowndrink.ui.theme.categoryBackgroundColor
import com.b21dccn216.makeyourowndrink.ui.theme.valueTextColor


@Composable
fun CategoryItem(
    pair: Pair<Category, Int>,
    onClickCategory: (Category) -> Unit = {}
){
    val category = pair.first
    val count = pair.second
    Surface(
        modifier = Modifier
            .size(height = 123.dp, width = 95.dp)
            .clickable { onClickCategory(category) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = categoryBackgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(4.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = category.icon),
                contentDescription = category.name,
                modifier = Modifier.size(height = 55.dp, width = 60.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = category.name,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 34.sp,
                    fontWeight = FontWeight.Light,
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$count mixes",
                style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 34.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = valueTextColor)
            )
        }
    }
}