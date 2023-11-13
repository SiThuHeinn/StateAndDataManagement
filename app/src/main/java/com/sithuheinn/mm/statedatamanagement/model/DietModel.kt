package com.sithuheinn.mm.statedatamanagement.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class DietModel(
   val data: List<DietItem>
)

@JsonClass(generateAdapter = true)
data class DietItem(
    val id: Int,
    val name: String,
    @Json(name = "tool_tip")
    val tooltip: String
)
