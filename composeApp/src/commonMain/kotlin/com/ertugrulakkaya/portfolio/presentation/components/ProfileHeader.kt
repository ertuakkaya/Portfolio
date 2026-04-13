package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ertugrulakkaya.portfolio.domain.model.Profile
import com.ertugrulakkaya.portfolio.domain.model.SocialLink
import com.ertugrulakkaya.portfolio.domain.model.SocialLinkType
import com.ertugrulakkaya.portfolio.presentation.theme.FontWeightEmphasis
import com.ertugrulakkaya.portfolio.presentation.theme.FontWeightReading
import com.ertugrulakkaya.portfolio.presentation.theme.FontWeightStrong
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.profile
import portfolio.composeapp.generated.resources.email
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.linkedin

@Composable
fun ProfileHeader(
    profile: Profile,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier) {
        val isCompact = maxWidth < 600.dp

        if (isCompact) {
            ProfileHeaderCompact(
                profile = profile,
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )
        } else {
            ProfileHeaderExpanded(
                profile = profile,
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )
        }
    }
}

@Composable
private fun ProfileHeaderExpanded(
    profile: Profile,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 32.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        ProfileAvatar(
            name = profile.name,
            avatarUrl = profile.avatarUrl,
            modifier = Modifier.size(160.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = profile.name,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeightEmphasis,
                    letterSpacing = (-0.704).sp
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = profile.title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeightReading
                ),
                color = MaterialTheme.colorScheme.secondary
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = profile.location,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = "•",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Text(
                    text = profile.email,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeightEmphasis
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = profile.bio,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            SocialLinksRow(socialLinks = profile.socialLinks)
        }

        ThemeToggleButton(
            isDarkTheme = isDarkTheme,
            onToggle = onToggleTheme
        )
    }
}

@Composable
private fun ProfileHeaderCompact(
    profile: Profile,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            ThemeToggleButton(
                isDarkTheme = isDarkTheme,
                onToggle = onToggleTheme
            )
        }

        ProfileAvatar(
            name = profile.name,
            avatarUrl = profile.avatarUrl,
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = profile.name,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeightEmphasis,
                letterSpacing = (-0.288).sp
            ),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Text(
            text = profile.title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeightReading
            ),
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = profile.location,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Text(
            text = profile.email,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeightEmphasis
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = profile.bio,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        SocialLinksRow(
            socialLinks = profile.socialLinks,
            modifier = Modifier.fillMaxWidth(),
            centered = true,
            compact = true
        )
    }
}

@Composable
private fun ProfileAvatar(
    name: String,
    avatarUrl: String?,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(1.dp, MaterialTheme.colorScheme.outline, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.profile),
            contentDescription = "Profile picture of $name",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun SocialLinksRow(
    socialLinks: List<SocialLink>,
    modifier: Modifier = Modifier,
    centered: Boolean = false,
    compact: Boolean = false
) {
    Row(
        modifier = modifier,
        horizontalArrangement = if (centered) Arrangement.Center else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        socialLinks.forEachIndexed { index, link ->
            if (index > 0) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            SocialLinkButton(link = link, compact = compact)
        }
    }
}

@Composable
private fun SocialLinkButton(
    link: SocialLink,
    modifier: Modifier = Modifier,
    compact: Boolean = false
) {
    val (iconRes, label) = when (link.type) {
        SocialLinkType.GITHUB -> Res.drawable.github to "GitHub"
        SocialLinkType.LINKEDIN -> Res.drawable.linkedin to "LinkedIn"
        SocialLinkType.EMAIL -> Res.drawable.email to "Email"
        SocialLinkType.TWITTER -> Res.drawable.github to "Twitter"
        SocialLinkType.WEBSITE -> Res.drawable.github to "Web"
    }

    GhostLinkButton(
        icon = painterResource(iconRes),
        label = label,
        url = link.url,
        modifier = modifier,
        compact = compact
    )
}

@Composable
private fun GhostLinkButton(
    icon: Painter,
    label: String,
    url: String,
    modifier: Modifier = Modifier,
    compact: Boolean = false
) {
    val uriHandler = LocalUriHandler.current

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(6.dp))
            .clickable { uriHandler.openUri(url) }
            .padding(
                horizontal = if (compact) 10.dp else 14.dp,
                vertical = if (compact) 6.dp else 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(if (compact) 14.dp else 16.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.width(if (compact) 6.dp else 8.dp))
        Text(
            text = label,
            style = if (compact) {
                MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeightEmphasis
                )
            } else {
                MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeightEmphasis
                )
            },
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ThemeToggleButton(
    isDarkTheme: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(1.dp, MaterialTheme.colorScheme.outline, CircleShape)
            .clickable(onClick = onToggle),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
            contentDescription = if (isDarkTheme) "Switch to light mode" else "Switch to dark mode",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(18.dp)
        )
    }
}
