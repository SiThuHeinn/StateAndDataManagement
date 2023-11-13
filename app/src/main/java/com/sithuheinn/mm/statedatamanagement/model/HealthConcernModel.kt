package com.sithuheinn.mm.statedatamanagement.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class HealthConcernModel(
    val data: List<HealthConcernItem>
)

@JsonClass(generateAdapter = true)
data class HealthConcernItem(
    val id: Int,
    val name: String
)