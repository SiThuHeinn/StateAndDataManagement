package com.sithuheinn.mm.statedatamanagement.feature.util

import android.content.Context
import com.sithuheinn.mm.statedatamanagement.model.AllergiesItem
import com.sithuheinn.mm.statedatamanagement.model.AllergiesModel
import com.sithuheinn.mm.statedatamanagement.model.DietItem
import com.sithuheinn.mm.statedatamanagement.model.DietModel
import com.sithuheinn.mm.statedatamanagement.model.HealthConcernItem
import com.sithuheinn.mm.statedatamanagement.model.HealthConcernModel
import com.sithuheinn.mm.statedatamanagement.model.ResultModel
import com.sithuheinn.mm.statedatamanagement.model.SingleChoiceAnswer
import com.sithuheinn.mm.statedatamanagement.model.SingleChoiceQuestionModel
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class OnBoardDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val moshi = Moshi.Builder().build()


    fun getHealthConcernItems(): List<HealthConcernItem> {
        val jsonString = readFromJsonFile("healthconcern.json")
        if (jsonString.isEmpty()) return emptyList()

        val adapter = moshi.adapter(HealthConcernModel::class.java)

        return adapter.fromJson(jsonString)?.data.orEmpty()
    }

    fun getDietItems(): List<DietItem> {
        val jsonString = readFromJsonFile("diets.json")
        if (jsonString.isEmpty()) return emptyList()

        val adapter = moshi.adapter(DietModel::class.java)
        return adapter.fromJson(jsonString)?.data.orEmpty()
    }

    fun getAllergiesItems(): List<AllergiesItem> {
        val jsonString = readFromJsonFile("allergies.json")
        if (jsonString.isEmpty()) return emptyList()
        val adapter = moshi.adapter(AllergiesModel::class.java)
        return adapter.fromJson(jsonString)?.data.orEmpty()
    }

    private fun readFromJsonFile(fileName: String): String {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            ""
        }
    }


    fun convertToJsonString(model: ResultModel): String {
        val adapter = moshi.adapter(ResultModel::class.java)
        return adapter.toJson(model)
    }


    fun getSingleChoiceQuestions(): List<SingleChoiceQuestionModel> {
        return listOf(
            SingleChoiceQuestionModel(
                title = "Is your daily exposure to sun is limited?*",
                answers = listOf(
                    SingleChoiceAnswer("Yes", false),
                    SingleChoiceAnswer("No", false),
                )
            ),
            SingleChoiceQuestionModel(
                title = "Do you current smoke (tobacco or marijuana)?*",
                answers = listOf(
                    SingleChoiceAnswer("Yes", false),
                    SingleChoiceAnswer("No", false),
                )
            ),
            SingleChoiceQuestionModel(
                title = "On average, how many alcoholic beverages do you have in a week?*",
                answers = listOf(
                    SingleChoiceAnswer("0-1", false),
                    SingleChoiceAnswer("2-5", false),
                    SingleChoiceAnswer("5+", false),
                )
            )
        )
    }






}