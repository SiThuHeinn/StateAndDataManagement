package com.sithuheinn.mm.statedatamanagement.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun OnboardNavigationButton(
    modifier: Modifier,
    onBack: () -> Unit,
    onNext: () -> Unit
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            modifier = Modifier
                .padding(end = 15.dp)
                .clip(RoundedCornerShape(5.dp)),
            onClick = onBack
        ) {
            Text(
                text = "Back"
            )
        }

        Button(
            modifier = Modifier
                .padding(start = 15.dp)
                .clip(RoundedCornerShape(5.dp)),
            onClick = onNext
        ) {
            Text(text = "Next")
        }
    }
}