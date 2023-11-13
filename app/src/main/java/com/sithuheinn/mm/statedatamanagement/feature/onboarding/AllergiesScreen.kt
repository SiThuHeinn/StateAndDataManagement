package com.sithuheinn.mm.statedatamanagement.feature.onboarding

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sithuheinn.mm.statedatamanagement.design.AutoCompleteTextField
import com.sithuheinn.mm.statedatamanagement.design.CheckBoxItem
import com.sithuheinn.mm.statedatamanagement.design.Chip
import com.sithuheinn.mm.statedatamanagement.design.LabelText
import com.sithuheinn.mm.statedatamanagement.design.OnboardNavigationButton
import com.sithuheinn.mm.statedatamanagement.model.AllergiesItem

@ExperimentalLayoutApi
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllergiesScreen(
    allergiesItems: List<AllergiesItem>,
    selectedItems: List<AllergiesItem>,
    onSelectedItem: (String) -> Unit,
    onRemoveItem: (String) -> Unit,
    onBack: () -> Unit,
    onNext: () -> Unit
) {

    Scaffold(
        content = {
            Column {

                LabelText(
                    modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 25.dp),
                    text = "Write any specific allergies or sensitive towards specific things. (optional)",
                )


                var expanded by remember {
                    mutableStateOf(selectedItems.isNotEmpty())
                }

                AnimatedVisibility(visible = expanded) {
                    FlowRow(modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 25.dp)) {
                        selectedItems.map { it.name }.forEach {
                            Chip(title = it, isSelected = true) {
                                onRemoveItem.invoke(it)
                            }
                        }
                    }
                }

                AutoCompleteTextField(allergiesItems = allergiesItems) {
                    expanded = true
                    onSelectedItem.invoke(it)
                }


            }
        },
        bottomBar = {
            OnboardNavigationButton(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp)
                    .fillMaxWidth(),
                onBack = onBack,
                onNext = onNext
            )
        }
    )
}


