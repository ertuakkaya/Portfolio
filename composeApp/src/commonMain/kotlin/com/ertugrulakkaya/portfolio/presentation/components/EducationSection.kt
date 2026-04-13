package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.domain.model.Education
import com.ertugrulakkaya.portfolio.presentation.theme.*

@Composable
fun EducationSection(
    education: List<Education>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(title = "Education")

        Spacer(modifier = Modifier.height(24.dp))

        education.forEachIndexed { index, edu ->
            EducationCard(education = edu)
            if (index < education.lastIndex) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun EducationCard(
    education: Education,
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
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = education.school,
                style = Typography.titleLarge.copy(
                    fontWeight = FontWeightStrong
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${education.degree} in ${education.field}",
                style = Typography.bodyLarge.copy(
                    fontWeight = FontWeightEmphasis
                ),
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = formatDateRange(education.startDate, education.endDate, education.isCurrent),
                style = Typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            education.gpa?.let { gpa ->
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "GPA: $gpa",
                    style = Typography.labelMedium.copy(
                        fontWeight = FontWeightEmphasis
                    ),
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            if (education.description != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = education.description,
                    style = Typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
