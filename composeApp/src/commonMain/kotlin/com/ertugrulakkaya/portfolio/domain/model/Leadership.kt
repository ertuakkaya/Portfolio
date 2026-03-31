package com.ertugrulakkaya.portfolio.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Leadership(
    val id: String,
    val organization: String,
    val role: String,
    val startDate: String,
    val endDate: String,
    val description: String,
    val achievements: List<String> = emptyList()
)
