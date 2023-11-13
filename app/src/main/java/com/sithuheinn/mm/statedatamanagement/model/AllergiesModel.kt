package com.sithuheinn.mm.statedatamanagement.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AllergiesModel(
    val data: List<AllergiesItem>
)

@JsonClass(generateAdapter = true)
data class AllergiesItem(
    val id: Int,
    val name: String
)