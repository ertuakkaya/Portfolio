package com.ertugrulakkaya.portfolio.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.domain.model.Skill
import com.ertugrulakkaya.portfolio.domain.model.SkillCategory

@Composable
fun SkillsSection(
    skills: List<Skill>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(title = "Technical Skills")

        Spacer(modifier = Modifier.height(20.dp))

        SkillCategory.entries.forEach { category ->
            val categorySkills = skills.filter { it.category == category }
            if (categorySkills.isNotEmpty()) {
                SkillCategoryRow(
                    category = category,
                    skills = categorySkills
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun SkillCategoryRow(
    category: SkillCategory,
    skills: List<Skill>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = category.displayName,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight(590),
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            skills.forEachIndexed { index, skill ->
                Text(
                    text = "•",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                )
                Text(
                    text = skill.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

private val SkillCategory.displayName: String
    get() = when (this) {
        SkillCategory.MOBILE_UI -> "Mobile & UI"
        SkillCategory.ARCHITECTURE -> "Architecture"
        SkillCategory.BACKEND_DB -> "Backend & DBs"
        SkillCategory.TOOLS_TECH -> "Tools & Tech"
        SkillCategory.PRACTICES -> "Practices"
    }
