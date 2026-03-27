package com.ertugrulakkaya.portfolio.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: String,
    val name: String,
    val description: String,
    val technologies: List<String>,
    val imageUrl: String? = null,
    val demoUrl: String? = null,
    val sourceUrl: String? = null,
    val isFeatured: Boolean = false,
    val isKmpProject: Boolean = false
)
