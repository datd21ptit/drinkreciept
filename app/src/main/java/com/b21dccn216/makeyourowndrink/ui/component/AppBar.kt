package com.b21dccn216.makeyourowndrink.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.b21dccn216.makeyourowndrink.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: @Composable() () -> Unit,
    back: @Composable() () -> Unit = { Box(modifier = Modifier) {} },
){
    CenterAlignedTopAppBar(
        modifier = Modifier,
        colors = topAppBarColors(
            containerColor = Color.Transparent,
        ),
        navigationIcon = {
            back()
        },
        title = {
            title()
        },
        actions = {
            Icon(painter = painterResource(id = R.drawable.acc_icon), contentDescription = null)
        }
    )
}