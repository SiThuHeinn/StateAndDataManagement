package com.sithuheinn.mm.statedatamanagement.feature.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sithuheinn.mm.statedatamanagement.design.Chip
import com.sithuheinn.mm.statedatamanagement.design.LabelText
import com.sithuheinn.mm.statedatamanagement.design.ListItem
import com.sithuheinn.mm.statedatamanagement.design.OnboardNavigationButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalLayoutApi
@Composable
fun HealthConcernScreen(
    healthConcernItems: List<HealthConcernViewItem>,
    onItemSelect: (Int) -> Unit,
    onBack: () -> Unit,
    onNext: () -> Unit
) {


    Scaffold(
        content = {
            Column {

                LabelText(
                    modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 25.dp),
                    text = "Select the top health concerns. * (up to 5)",
                )

                FlowRow(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                ) {
                    healthConcernItems.forEachIndexed { index, item ->
                        Chip(title = item.name, isSelected = item.isSelected) {
                            onItemSelect(index)
                        }
                    }
                }

                LabelText(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 20.dp, bottom = 10.dp),
                    text = "Prioritize",
                )
                
                LazyColumn {
                    items(items = healthConcernItems.filter { it.isSelected }) {
                        ListItem(text = it.name)
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


//    Box(
//        modifier = Modifier
//            .background(Color.Blue.copy(alpha = 0.1f))
//            .fillMaxSize()
//
//    ) {
//
//        Column {
//
//            LabelText(
//                modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 25.dp),
//                text = "Select the top health concerns. * (up to 5)",
//            )
//
//            FlowRow(
//                modifier = Modifier
//                    .padding(start = 20.dp, end = 20.dp, top = 10.dp)
//            ) {
//                healthConcernItems.forEachIndexed { index, item ->
//                    Chip(title = item.name, isSelected = item.isSelected) {
//                        onItemSelect(index)
//                    }
//                }
//            }
//
//            LabelText(
//                modifier = Modifier
//                    .padding(start = 25.dp, end = 25.dp, top = 20.dp),
//                text = "Prioritize",
//            )
//
//        }
//
//
//
//    }


}