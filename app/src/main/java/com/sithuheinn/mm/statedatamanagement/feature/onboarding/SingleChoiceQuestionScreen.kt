package com.sithuheinn.mm.statedatamanagement.feature.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sithuheinn.mm.statedatamanagement.design.SingleChoiceQuestionItem
import com.sithuheinn.mm.statedatamanagement.model.SingleChoiceAnswer
import com.sithuheinn.mm.statedatamanagement.model.SingleChoiceQuestionModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SingleChoiceQuestionScreen(
    questions: List<SingleChoiceQuestionModel>,
    onAnswered: (quesIndex: Int, List<SingleChoiceAnswer>) -> Unit,
    onFinished: () -> Unit
) {


    Scaffold(
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                questions.forEachIndexed { index, model ->
                    SingleChoiceQuestionItem(
                        title = model.title,
                        answers = model.answers,
                        onAnswered = {
                            onAnswered.invoke(index, it)
                        })
                }
            }
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                ,
                onClick = onFinished
            ) {
                Text(text = "Get my personalized vitamin")
            }
        },
    )
}