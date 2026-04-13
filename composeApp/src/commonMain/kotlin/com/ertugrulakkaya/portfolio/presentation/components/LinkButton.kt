package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import com.ertugrulakkaya.portfolio.presentation.theme.PortfolioTheme
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.email
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.linkedin

@Composable
fun LinkButton(
    icon: Painter,
    label: String,
    url: String,
    modifier: Modifier = Modifier,
    compact: Boolean = false
) {
    val uriHandler = LocalUriHandler.current

    Button(
        onClick = { uriHandler.openUri(url) },
        modifier = modifier.border(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline,
            shape = RoundedCornerShape(6.dp)
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(6.dp),
        contentPadding = if (compact) {
            PaddingValues(horizontal = 10.dp, vertical = 6.dp)
        } else {
            PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        },
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(if (compact) 14.dp else 18.dp),
                tint = if (compact) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.width(if (compact) 4.dp else 8.dp))
            Text(
                text = label,
                style = if (compact) {
                    MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(510)
                    )
                } else {
                    MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight(510)
                    )
                },
                color = if (compact) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview
@Composable
private fun LinkButtonPreview() {
    PortfolioTheme(darkTheme = false) {
        LinkButton(
            icon = painterResource(Res.drawable.github),
            label = "GitHub",
            url = "https://github.com"
        )
    }
}

@Preview
@Composable
private fun LinkButtonDarkPreview() {
    PortfolioTheme(darkTheme = true) {
        LinkButton(
            icon = painterResource(Res.drawable.linkedin),
            label = "LinkedIn",
            url = "https://linkedin.com"
        )
    }
}

@Preview
@Composable
private fun LinkButtonCompactPreview() {
    PortfolioTheme(darkTheme = true) {
        LinkButton(
            icon = painterResource(Res.drawable.email),
            label = "Email",
            url = "mailto:test@example.com",
            compact = true
        )
    }
}

@Preview
@Composable
private fun LinkButtonsPreview() {
    PortfolioTheme(darkTheme = false) {
        Column(modifier = Modifier.padding(16.dp)) {
            LinkButton(
                icon = painterResource(Res.drawable.github),
                label = "GitHub",
                url = "https://github.com"
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinkButton(
                icon = painterResource(Res.drawable.linkedin),
                label = "LinkedIn",
                url = "https://linkedin.com"
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinkButton(
                icon = painterResource(Res.drawable.email),
                label = "Email",
                url = "mailto:test@example.com"
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinkButton(
                icon = painterResource(Res.drawable.github),
                label = "Compact",
                url = "https://github.com",
                compact = true
            )
        }
    }
}
