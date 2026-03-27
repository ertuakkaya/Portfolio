package com.ertugrulakkaya.portfolio.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioData(
    val profile: Profile,
    val experiences: List<Experience>,
    val education: List<Education>,
    val projects: List<Project>,
    val skills: List<Skill>
)
