package com.sithuheinn.mm.statedatamanagement.design

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sithuheinn.mm.statedatamanagement.model.SingleChoiceAnswer
import com.sithuheinn.mm.statedatamanagement.model.SingleChoiceQuestionModel


@Composable
fun SingleChoiceQuestionItem(
    title: String,
    answers: List<SingleChoiceAnswer>,
    onAnswered: (List<SingleChoiceAnswer>) -> Unit
) {


    Column {
        LabelText(
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 20.dp),
            text = title
        )

        answers.forEachIndexed { index, answer ->
            SingleChoiceAnswerItem(text = answer.text, isSelected = answer.isSelected) {
                val updatedAnswers = answers.mapIndexed { ansIndex, singleChoiceAnswer ->
                    if (ansIndex == index) {
                        singleChoiceAnswer.copy(isSelected = !singleChoiceAnswer.isSelected)
                    } else {
                        singleChoiceAnswer.copy(isSelected = false)

                    }
                }

                onAnswered.invoke(updatedAnswers)
            }
        }
    }

}

@Composable
fun SingleChoiceAnswerItem(
    text: String,
    isSelected: Boolean,
    onAnswered: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically

    ) {
        RadioButton(selected = isSelected, onClick = { onAnswered.invoke() })
        Text(text = text)
    }
}