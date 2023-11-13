package com.sithuheinn.mm.statedatamanagement.design

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun CheckBoxItem(
    modifier: Modifier,
    title: String,
    isChecked: Boolean,
    tooltip: String,
    onCheckedChange: () -> Unit
) {


    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { onCheckedChange.invoke() },
        )

        Text(text = title)
    }
}