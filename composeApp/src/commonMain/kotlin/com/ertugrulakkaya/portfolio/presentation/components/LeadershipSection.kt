package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.domain.model.Leadership
import com.ertugrulakkaya.portfolio.presentation.theme.FontWeightEmphasis
import com.ertugrulakkaya.portfolio.presentation.theme.FontWeightReading
import com.ertugrulakkaya.portfolio.presentation.theme.FontWeightStrong

@Composable
fun LeadershipSection(
    leadership: List<Leadership>,
    modifier: Modifier = Modifier
) {
    if (leadership.isEmpty()) return

    Column(modifier = modifier) {
        SectionTitle(title = "Leadership & Volunteer Experience")

        Spacer(modifier = Modifier.height(24.dp))

        leadership.forEachIndexed { index, item ->
            LeadershipCard(leadership = item)
            if (index < leadership.lastIndex) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun LeadershipCard(
    leadership: Leadership,
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
                        text = leadership.role,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeightStrong,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = leadership.organization,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeightEmphasis
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = formatDateRange(leadership.startDate, leadership.endDate, false),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = leadership.description,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeightReading,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.2
            )

            if (leadership.achievements.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))

                leadership.achievements.forEach { achievement ->
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
                            text = achievement,
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
}
