package com.sithuheinn.mm.statedatamanagement.model

data class SingleChoiceQuestionModel(
    val title: String,
    val answers: List<SingleChoiceAnswer>
)

data class SingleChoiceAnswer(
    val text: String,
    val isSelected: Boolean
)