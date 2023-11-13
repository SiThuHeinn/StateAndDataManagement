package com.sithuheinn.mm.statedatamanagement.design

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Chip(
    title: String,
    isSelected: Boolean,
    onSelected: () -> Unit
) {


    val background = if (isSelected) Color.Blue else Color.Blue.copy(alpha = 0.1f)
    val contentColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .padding(5.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(background)
            .clickable(
                onClick = {
                    onSelected()
                }
            )

    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 10.dp, end = 10.dp),
            text = title,
            color = contentColor,
            fontSize = 14.sp,

        )
    }
}