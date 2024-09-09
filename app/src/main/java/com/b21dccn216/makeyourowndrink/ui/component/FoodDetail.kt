package com.b21dccn216.makeyourowndrink.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.b21dccn216.makeyourowndrink.R
import com.b21dccn216.makeyourowndrink.model.Drink
import com.b21dccn216.makeyourowndrink.ui.theme.timeColor
import com.b21dccn216.makeyourowndrink.ui.theme.difficultyColor
import com.b21dccn216.makeyourowndrink.ui.theme.servesColor
import com.b21dccn216.makeyourowndrink.ui.theme.categoryColor
import com.b21dccn216.makeyourowndrink.ui.theme.descriptionColor


@Composable
fun FoodInformation(
    modifier: Modifier,
    recipe: Drink
){
    ConstraintLayout(modifier = modifier) {
        val (columnInfo, imgIcon, backgroundImage, descriptionText) = createRefs()
//        Background image
        Image(
            painter = painterResource(id = R.drawable.vector_23),
            contentDescription = null,
            modifier = Modifier.constrainAs(backgroundImage){
                bottom.linkTo(imgIcon.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            contentScale = ContentScale.FillWidth
            )
//        Product image
        Image(
            painter = painterResource(id = recipe.img),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .constrainAs(imgIcon){
                bottom.linkTo(columnInfo.bottom)
//                end.linkTo(parent.end)
                start.linkTo(columnInfo.end, margin = 0.dp)
            },
//            contentScale = ContentScale.Fit
        )
//        descriptionText
        Text(
            text = recipe.description,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = descriptionColor
            ),
            modifier = Modifier.padding(16.dp)
                .constrainAs(descriptionText){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
            }
        )
//        Product Information
        Column(
            modifier = Modifier
                .constrainAs(columnInfo){
                top.linkTo(descriptionText.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 24.dp)
            }
        ) {
//            Time
            InformationComponent(
                title = "Time",
                content = recipe.time.toString(),
                unit = "min",
                color = timeColor)
//            Difficulty
            InformationComponent(
                title = "Difficulty",
                content = recipe.difficulty,
                unit = "",
                color = difficultyColor)
//            Category
            InformationComponent(
                title = "Category",
                content = recipe.categoryName.toString(),
                unit = "",
                color = categoryColor)
//            Serves
            InformationComponent(
                title = "Serves",
                content = recipe.serves.toString(),
                unit = "",
                color = servesColor)
        }
    }
}


@Composable
fun InformationComponent(
    title: String,
    content: String,
    unit: String?,
    color: Color
){
    Text(text = title,
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            color = color
        )
    )
    Text(text = "$content $unit",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 44.sp,
            color = color
        ),
        modifier = Modifier.padding(vertical = 8.dp))
    Spacer(modifier = Modifier.height(16.dp))
}

