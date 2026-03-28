package com.ertugrulakkaya.portfolio.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Skill(
    val id: String,
    val name: String,
    val category: SkillCategory,
    val proficiencyLevel: Int? = null
)

@Serializable
enum class SkillCategory {
    LANGUAGE,
    FRAMEWORK,
    TOOL,
    DATABASE,
    ARCHITECTURE,
    OTHER
}
