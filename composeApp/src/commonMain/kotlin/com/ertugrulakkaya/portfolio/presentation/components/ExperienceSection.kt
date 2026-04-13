package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.domain.model.Experience
import com.ertugrulakkaya.portfolio.presentation.theme.*

@Composable
fun ExperienceSection(
    experiences: List<Experience>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(title = "Experience")

        Spacer(modifier = Modifier.height(24.dp))

        experiences.forEachIndexed { index, experience ->
            TimelineItem(experience = experience)
            if (index < experiences.lastIndex) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun TimelineItem(
    experience: Experience,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = experience.position,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeightStrong,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = experience.company,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeightEmphasis
                    )
                }

                if (experience.isCurrent) {
                    CurrentBadge()
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = formatDateRange(experience.startDate, experience.endDate, experience.isCurrent),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )

            if (experience.location != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = experience.location,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            experience.description.split(". ").filter { it.isNotBlank() }.forEach { point ->
                Row(
                    modifier = Modifier.padding(bottom = 4.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "•",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = point.trim().let { if (it.endsWith(".")) it else "$it." },
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeightReading,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.2
                    )
                }
            }
        }
    }
}

@Composable
private fun CurrentBadge() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(9999.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = "Current",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeightEmphasis,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@PublishedApi
internal fun formatDateRange(startDate: String, endDate: String?, isCurrent: Boolean): String {
    val start = formatDate(startDate)
    val end = if (isCurrent) "Present" else endDate?.let { formatDate(it) } ?: ""
    return "$start - $end"
}

@PublishedApi
internal fun formatDate(date: String): String {
    val parts = date.split("-")
    if (parts.size != 2) return date
    val year = parts[0]
    val month = parts[1].toIntOrNull() ?: return date
    val monthName = listOf(
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    ).getOrNull(month - 1) ?: return date
    return "$monthName $year"
}
