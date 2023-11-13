package com.sithuheinn.mm.statedatamanagement.feature.onboarding

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sithuheinn.mm.statedatamanagement.feature.util.OnBoardDataSource
import com.sithuheinn.mm.statedatamanagement.model.AllergiesItem
import com.sithuheinn.mm.statedatamanagement.model.DietItem
import com.sithuheinn.mm.statedatamanagement.model.HealthConcernItem
import com.sithuheinn.mm.statedatamanagement.model.ResultModel
import com.sithuheinn.mm.statedatamanagement.model.SingleChoiceAnswer
import com.sithuheinn.mm.statedatamanagement.model.SingleChoiceQuestionModel
import com.squareup.moshi.Json
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardSharedViewModel @Inject constructor(
     private val onBoardDataSource: OnBoardDataSource
): ViewModel() {

    private val _heathConcernViewItems: MutableState<List<HealthConcernViewItem>> = mutableStateOf(emptyList())
    val healthConcernViewItem = _heathConcernViewItems

    private val _checkedNone: MutableState<Boolean> = mutableStateOf(false)
    val checkedNone = _checkedNone
    private val _dietItems: MutableState<List<DietViewItem>> = mutableStateOf(emptyList())
    val dietViewItem = _dietItems

    private val _singleChoiceQuestions: MutableState<List<SingleChoiceQuestionModel>> = mutableStateOf(emptyList())
    val singleChoiceQuestions = _singleChoiceQuestions


    private val _allergiesItems: MutableState<List<AllergiesItem>> = mutableStateOf(emptyList())
    val allergiesItems = _allergiesItems
    private val _selectedAllergiesItems: MutableState<List<AllergiesItem>> = mutableStateOf(emptyList())
    val selectedAllergiesItem = _selectedAllergiesItems



    init {
        val items = onBoardDataSource.getHealthConcernItems().map { it.toViewItem() }
        _heathConcernViewItems.value = items

        val diets = onBoardDataSource.getDietItems().map { it.toViewItem() }
        _dietItems.value = diets

        val questions = onBoardDataSource.getSingleChoiceQuestions()
        _singleChoiceQuestions.value = questions

        val allergiesItems = onBoardDataSource.getAllergiesItems()
        _allergiesItems.value = allergiesItems
    }


    fun onSelectHealthConcernViewItem(index: Int) {
        val viewItems =  _heathConcernViewItems.value.toMutableList()
        val isSelected = !viewItems[index].isSelected
        viewItems[index] = viewItems[index].copy(isSelected = isSelected)
        _heathConcernViewItems.value = viewItems
    }


    fun onSingleChoiceAnswerSelected(questionIndex: Int, newAnswers: List<SingleChoiceAnswer>) {
        val questions = _singleChoiceQuestions.value.toMutableList()
        questions[questionIndex] = questions[questionIndex].copy(answers = newAnswers)
        _singleChoiceQuestions.value = questions

    }


    fun onCheckChangedDietItem(index: Int) {
        _checkedNone.value = false
        val viewItems = _dietItems.value.toMutableList()
        val isChecked = !viewItems[index].isChecked
        viewItems[index] = viewItems[index].copy(isChecked = isChecked)
        _dietItems.value = viewItems
    }

    fun onCheckNoneDietItem() {
        _checkedNone.value = true
        val viewItems = _dietItems.value.map { it.copy(isChecked = false) }
        _dietItems.value = viewItems
    }


    fun onSelectAllergiesItem(text: String) {
        val selected = _allergiesItems.value.filter { it.name == text }.toMutableList()

        if (_selectedAllergiesItems.value.isNotEmpty()) {
            selected.addAll(_selectedAllergiesItems.value)
        }
        _selectedAllergiesItems.value = selected
    }

    fun onRemoveAllergiesItem(text: String) {
        val selected = _selectedAllergiesItems.value.toMutableList().filter { it.name != text }
        _selectedAllergiesItems.value = selected
    }






    fun onFinish() {
        val resultModel = ResultModel(
            healthConcern = _heathConcernViewItems.value.filter { it.isSelected }.map { it.toModel() },
            diets = _dietItems.value.filter { it.isChecked }.map { it.toModel() },
            isDailyExposure = false,
            isSmoke = false,
            alchol = _singleChoiceQuestions.value[2].answers.firstOrNull { it.isSelected }?.text.orEmpty(), // shouldn't check with static index, but, since its an test app.
            allergies = _selectedAllergiesItems.value
        )

        val jsonString = onBoardDataSource.convertToJsonString(resultModel)
        Log.d("onboard vm", jsonString)
    }





    override fun onCleared() {
        super.onCleared()
        Log.d("onboard vm", "onCleared")
    }

}


fun HealthConcernItem.toViewItem(): HealthConcernViewItem {
    return HealthConcernViewItem(
        id = this.id,
        name = this.name,
        isSelected = false
    )
}

fun HealthConcernViewItem.toModel(): HealthConcernItem {
    return HealthConcernItem(
        id = this.id,
        name = this.name,
    )
}

data class HealthConcernViewItem(
    val id: Int,
    val name: String,
    val isSelected: Boolean
)

fun DietItem.toViewItem(): DietViewItem {
    return DietViewItem(
        id = this.id,
        name = this.name,
        tooltip = this.tooltip,
        isChecked = false,
    )
}

fun DietViewItem.toModel(): DietItem {
    return DietItem(
        id = this.id,
        name = this.name,
        tooltip = this.tooltip
    )
}

data class DietViewItem(
    val id: Int,
    val name: String,
    val tooltip: String,
    val isChecked: Boolean
)