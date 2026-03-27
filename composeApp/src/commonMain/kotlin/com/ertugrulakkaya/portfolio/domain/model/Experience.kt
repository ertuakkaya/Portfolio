package com.ertugrulakkaya.portfolio.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Experience(
    val id: String,
    val company: String,
    val position: String,
    val startDate: String,
    val endDate: String?,
    val isCurrent: Boolean,
    val description: String,
    val location: String? = null,
    val companyLogo: String? = null
)
