package com.b21dccn216.makeyourowndrink.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.b21dccn216.makeyourowndrink.R
import com.b21dccn216.makeyourowndrink.model.Ingredient
import com.b21dccn216.makeyourowndrink.model.IngredientWithQuantity
import com.b21dccn216.makeyourowndrink.ui.theme.backgroundColor
import com.b21dccn216.makeyourowndrink.ui.theme.borderColor
import com.b21dccn216.makeyourowndrink.ui.theme.nameTextColor
import com.b21dccn216.makeyourowndrink.ui.theme.servesColor
import com.b21dccn216.makeyourowndrink.ui.theme.valueTextColor

@Composable
fun IngredientList(
    listItem: List<IngredientWithQuantity>
){
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Ingredients",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    lineHeight = 44.sp,
                    color = servesColor
                )
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp).size(24.dp),
                tint = valueTextColor
            )

        }
        LazyVerticalGrid(
            columns = GridCells.FixedSize(100.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
        ) {
            items(listItem){ item ->
                Ingredient(
                    ingredient = item.ingredient,
                    value = item.quantity,
                )
            }
        }
    }
}

@Composable
fun Ingredient(
    ingredient: Ingredient,
    value: Int,
){
    ConstraintLayout(
        modifier = Modifier
            .size(100.dp, 100.dp)
            .clip(CircleShape)
            .background(color = backgroundColor)
            .border(
                BorderStroke(
                    width = 2.dp,
                    color = borderColor
                ),
                shape = CircleShape
            )
    ) {
        val horizontalGuideline50 = createGuidelineFromTop(0.5f)
        val verticalGuideline50 = createGuidelineFromStart(0.5f)
        val endGuideline20 = createGuidelineFromEnd(0.1f)
        val (imgIcon, valueText, unitText, nameText) = createRefs()
        val bottomBarrier = createBottomBarrier(valueText, unitText)
//
//Icon image of ingredient
        Image(
            painter = painterResource(id = ingredient.icon),
            contentDescription = null,
            modifier = Modifier.constrainAs(imgIcon){
                top.linkTo(parent.top)
                bottom.linkTo(horizontalGuideline50)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                height = Dimension.fillToConstraints
            },
            contentScale = ContentScale.FillHeight
        )
//
// Value of ingredient
        Text(
            text = value.toString(),
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                lineHeight = 14.sp,
                color = valueTextColor,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            modifier = Modifier
                .constrainAs(valueText){
                    end.linkTo(verticalGuideline50, margin = 2.dp)
                    top.linkTo(horizontalGuideline50)
                }
        )
//
//        Unit of ingredient
        ingredient.unit?.let {
            Text(
                text = ingredient.unit,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    color = valueTextColor
                ),
                modifier = Modifier
                    .constrainAs(unitText){
                        top.linkTo(valueText.bottom, margin = -2.dp)
                        end.linkTo(valueText.end)
                    }
            )
        }
//
//        Name of ingredient

        Text(
            text = ingredient.name,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                color = nameTextColor
            ),
            modifier = Modifier
                .constrainAs(nameText){
                    top.linkTo(valueText.top)
                    bottom.linkTo(bottomBarrier)
                    start.linkTo(verticalGuideline50)
                    end.linkTo(endGuideline20)
                    width = Dimension.fillToConstraints
                },
            maxLines = 2,

            )
    }
}


