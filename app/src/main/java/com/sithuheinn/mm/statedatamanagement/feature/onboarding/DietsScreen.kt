package com.sithuheinn.mm.statedatamanagement.feature.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sithuheinn.mm.statedatamanagement.design.CheckBoxItem
import com.sithuheinn.mm.statedatamanagement.design.LabelText
import com.sithuheinn.mm.statedatamanagement.design.OnboardNavigationButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DietScreen(
    dietViewItems: List<DietViewItem>,
    checkedNone: MutableState<Boolean>,
    onChecked: (Int) -> Unit,
    onCheckedNone: () -> Unit,
    onBack: () -> Unit,
    onNext: () -> Unit
) {


    Scaffold(
        content = {
            Column {

                LabelText(
                    modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 25.dp),
                    text = "Select the diets you follow.*",
                )
                CheckBoxItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp),
                    title = "None",
                    isChecked = checkedNone.value,
                    tooltip = ""
                ) {
                    onCheckedNone.invoke()
                }


                dietViewItems.forEachIndexed { index, dietViewItem ->
                    CheckBoxItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 15.dp, end = 15.dp
                            ),
                        title = dietViewItem.name,
                        isChecked = dietViewItem.isChecked,
                        tooltip = dietViewItem.tooltip
                    ) {
                        onChecked.invoke(index)
                    }
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