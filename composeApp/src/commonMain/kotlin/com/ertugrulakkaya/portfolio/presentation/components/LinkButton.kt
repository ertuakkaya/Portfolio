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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.presentation.theme.PortfolioTheme
import androidx.compose.ui.tooling.preview.Preview
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
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    Button(
        onClick = { uriHandler.openUri(url) },
        modifier = modifier.border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge
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
        }
    }
}
