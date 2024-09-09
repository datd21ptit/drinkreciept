package com.b21dccn216.makeyourowndrink.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.b21dccn216.makeyourowndrink.ui.theme.valueTextColor

@Composable
fun TitleAndContent(
    title: String,
    onClickSeeAll: ()->Unit = {},
    content: @Composable () -> Unit,
){
    Column(
        modifier = Modifier
    ) {
        TitleAndSeeAllButton(title = title, onclick = onClickSeeAll)
        Spacer(modifier = Modifier.height(8.dp))
        // move this out
        content()
        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
fun TitleAndSeeAllButton(
    modifier: Modifier = Modifier,
    title: String,
    onclick: () -> Unit = {}
){
    Row(
        modifier = modifier.padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                lineHeight = 34.sp
            ),
            modifier = Modifier.weight(1f)
        )
        OutlinedButton(
            onClick = onclick,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(width = 1.dp, color = valueTextColor),
            contentPadding = PaddingValues(),
            modifier = Modifier.size(height = 34.dp, width = 52.dp)
        ) {
            Text(
                text = "See all",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 34.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = valueTextColor
                )
            )
        }
    }
}