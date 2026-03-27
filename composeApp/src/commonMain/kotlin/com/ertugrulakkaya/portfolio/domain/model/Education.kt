package com.ertugrulakkaya.portfolio.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Education(
    val id: String,
    val school: String,
    val degree: String,
    val field: String,
    val startDate: String,
    val endDate: String?,
    val isCurrent: Boolean,
    val description: String? = null,
    val schoolLogo: String? = null
)
