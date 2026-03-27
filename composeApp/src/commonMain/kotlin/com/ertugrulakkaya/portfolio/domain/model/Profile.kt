package com.ertugrulakkaya.portfolio.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val name: String,
    val title: String,
    val bio: String,
    val email: String,
    val location: String,
    val avatarUrl: String? = null,
    val socialLinks: List<SocialLink>
)

@Serializable
data class SocialLink(
    val type: SocialLinkType,
    val url: String,
    val iconName: String
)

@Serializable
enum class SocialLinkType {
    GITHUB,
    LINKEDIN,
    TWITTER,
    WEBSITE,
    EMAIL
}
