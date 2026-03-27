package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.domain.model.Experience

@Composable
fun ExperienceSection(
    experiences: List<Experience>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(title = "Experience")

        Spacer(modifier = Modifier.height(16.dp))

        experiences.forEachIndexed { index, experience ->
            ExperienceCard(experience = experience)
            if (index < experiences.lastIndex) {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun ExperienceCard(
    experience: Experience,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
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
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = experience.company,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                if (experience.isCurrent) {
                    SuggestionChip(
                        onClick = { },
                        label = { Text("Current") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = formatDateRange(experience.startDate, experience.endDate, experience.isCurrent),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (experience.location != null) {
                Text(
                    text = experience.location,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = experience.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

private fun formatDateRange(startDate: String, endDate: String?, isCurrent: Boolean): String {
    val start = formatDate(startDate)
    val end = if (isCurrent) "Present" else endDate?.let { formatDate(it) } ?: ""
    return "$start - $end"
}

private fun formatDate(date: String): String {
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
