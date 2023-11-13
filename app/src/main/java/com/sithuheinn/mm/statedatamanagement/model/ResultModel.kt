package com.sithuheinn.mm.statedatamanagement.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ResultModel(
    @Json(name = "health_concerns")
    val healthConcern: List<HealthConcernItem>,
    val diets: List<DietItem>,
    @Json(name = "is_daily_exposure")
    val isDailyExposure: Boolean,
    @Json(name = "is_smoke")
    val isSmoke: Boolean,
    val alchol: String,
    val allergies: List<AllergiesItem>
)