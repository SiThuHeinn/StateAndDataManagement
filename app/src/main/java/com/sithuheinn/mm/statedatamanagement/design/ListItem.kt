package com.sithuheinn.mm.statedatamanagement.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ListItem(
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray.copy(alpha = 0.3f)),
    ) {
        Chip(title = text, isSelected = true) {}
        Icon(modifier = Modifier.align(Alignment.CenterEnd).padding(end = 10.dp), imageVector = Icons.Default.List, contentDescription = "")
    }
}