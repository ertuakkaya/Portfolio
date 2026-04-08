package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ertugrulakkaya.portfolio.domain.model.Profile
import com.ertugrulakkaya.portfolio.domain.model.SocialLink
import com.ertugrulakkaya.portfolio.domain.model.SocialLinkType
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
            modifier = Modifier.size(200.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = profile.name,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = profile.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = profile.location,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = profile.email,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = profile.bio,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(16.dp))

            SocialLinksRow(socialLinks = profile.socialLinks)
        }
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
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileAvatar(
            name = profile.name,
            avatarUrl = profile.avatarUrl,
            modifier = Modifier.size(140.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = profile.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Text(
            text = profile.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = profile.location,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Text(
                text = profile.email,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = profile.bio,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

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
    val avatarModifier = modifier
        .shadow(elevation = 12.dp, shape = CircleShape, spotColor = MaterialTheme.colorScheme.primary)
        .clip(CircleShape)

    Box(
        modifier = avatarModifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.profile),
            contentDescription = "Profile picture of $name",
            contentScale = ContentScale.Crop
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
                Spacer(modifier = Modifier.width(12.dp))
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

    LinkButton(
        icon = painterResource(iconRes),
        label = label,
        url = link.url,
        modifier = modifier,
        compact = compact
    )
}



@Composable
private fun ThemeToggleButton(
    isDarkTheme: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onToggle,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
            contentDescription = if (isDarkTheme) "Switch to light mode" else "Switch to dark mode",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}
