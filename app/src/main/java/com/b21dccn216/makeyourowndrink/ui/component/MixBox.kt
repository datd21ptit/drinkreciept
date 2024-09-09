package com.b21dccn216.makeyourowndrink.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.b21dccn216.makeyourowndrink.model.Drink
import com.b21dccn216.makeyourowndrink.ui.theme.valueTextColor

@Composable
fun MixBox(
    modifier: Modifier = Modifier,
    recipe: Drink,
    onClickDrink: (Drink) -> Unit = {}
){
    ConstraintLayout(
        modifier = Modifier
            .size(width = 248.dp, height = 334.dp)
            .background(color = valueTextColor, shape = RoundedCornerShape(16.dp))
            .clickable { onClickDrink(recipe) }
    ) {
        val (imgItem, nameTokeOne,nameTokenTwo, contentCol, ratingCol) = createRefs()
//        val verticalGuideline50 = createGuidelineFromStart(0.5f)
        Image(
            painter = painterResource(id = recipe.img),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .constrainAs(imgItem) {
                    end.linkTo(parent.end, margin = -48.dp)
                },
        )
        Column(
            modifier = Modifier
                .constrainAs(contentCol){
                    bottom.linkTo(parent.bottom, margin = 12.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                },
        ){
            RowIconAndText(text = recipe.categoryName.toString(), icon = Icons.Filled.Star)
            Spacer(modifier = Modifier.height(6.dp))
            RowIconAndText(text = "${recipe.time} min", icon = Icons.Default.Check)
            Spacer(modifier = Modifier.height(6.dp))
            RowIconAndText(text = recipe.like.toString(), icon = Icons.Filled.FavoriteBorder)
        }
        Column(modifier = Modifier
            .constrainAs(ratingCol){
                start.linkTo(contentCol.end)
                bottom.linkTo(parent.bottom, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
                width = Dimension.fillToConstraints
            },
            horizontalAlignment = Alignment.End
        ){
            Text(text = recipe.difficulty,
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    lineHeight = 34.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(4.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .size(width = 98.dp, height = 32.dp)
                    .background(color = Color(0xFFE45462), shape = RoundedCornerShape(16.dp))
            ){
                Row(modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    for(i in 1..recipe.rate){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription =  null,
                            tint = Color.Yellow,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    for(i in recipe.rate+1..4){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription =  null,
                            tint = Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
        val listToken = recipe.name.split(" ")
        Text(text = listToken.get(0),
            style = TextStyle(
                fontWeight = FontWeight.Black,
                fontSize = 34.sp,
                color = Color.White,
                fontFamily = FontFamily.Default
            ),
            modifier = Modifier.constrainAs(nameTokeOne){
                top.linkTo(parent.top, margin = 32.dp)
                start.linkTo(parent.start, margin = 12.dp)
            })
        if(listToken.size > 1){
            Text(text = listToken.get(1),
                style = TextStyle(
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFFFFFFFF).copy(alpha = 0.5f),
                    fontFamily = FontFamily.Default
                ),
                modifier = Modifier.constrainAs(nameTokenTwo){
                    top.linkTo(nameTokeOne.bottom, margin = 2.dp)
                    start.linkTo(parent.start, margin = 12.dp)
                })
        }
    }
}

@Composable
fun RowIconAndText(
    text: String,
    icon: ImageVector
){
    Row(verticalAlignment = Alignment.CenterVertically){
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(8.dp),
            tint = Color.White
        )
        Text(text = text,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 34.sp,
                color = Color.White
            )
        )
    }
}

