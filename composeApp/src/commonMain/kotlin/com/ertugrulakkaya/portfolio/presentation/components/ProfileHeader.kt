package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ertugrulakkaya.portfolio.domain.model.Profile
import com.ertugrulakkaya.portfolio.domain.model.SocialLink
import com.ertugrulakkaya.portfolio.domain.model.SocialLinkType

@Composable
fun ProfileHeader(
    profile: Profile,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileAvatar(
            name = profile.name,
            avatarUrl = profile.avatarUrl
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = profile.name,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = profile.title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = profile.location,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(4.dp))

        profile.phone?.let { phone ->
            Text(
                text = phone,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

        Text(
            text = profile.email,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = profile.bio,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        SocialLinksRow(socialLinks = profile.socialLinks)
    }
}

@Composable
private fun ProfileAvatar(
    name: String,
    avatarUrl: String?,
    modifier: Modifier = Modifier
) {
    if (avatarUrl != null) {
        AsyncImage(
            model = avatarUrl,
            contentDescription = "Profile picture of $name",
            modifier = modifier
                .size(140.dp)
                .shadow(elevation = 12.dp, shape = CircleShape, spotColor = MaterialTheme.colorScheme.primary)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    } else {
        Surface(
            modifier = modifier
                .size(140.dp)
                .shadow(elevation = 12.dp, shape = CircleShape, spotColor = MaterialTheme.colorScheme.primary),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = name.take(2).uppercase(),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
private fun SocialLinksRow(
    socialLinks: List<SocialLink>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        socialLinks.forEach { link ->
            SocialLinkButton(link = link)
        }
    }
}

@Composable
private fun SocialLinkButton(
    link: SocialLink,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val label = when (link.type) {
        SocialLinkType.EMAIL -> "Email"
        SocialLinkType.GITHUB -> "GitHub"
        SocialLinkType.LINKEDIN -> "LinkedIn"
        SocialLinkType.WEBSITE -> "Web"
        SocialLinkType.TWITTER -> "Twitter"
    }

    FilledTonalButton(
        onClick = { uriHandler.openUri(link.url) },
        modifier = modifier
    ) {
        Text(label)
    }
}
