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
        SectionTitle(title = "Skills")

        Spacer(modifier = Modifier.height(16.dp))

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
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(12.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            skills.forEach { skill ->
                SkillChip(skill = skill)
            }
        }
    }
}

@Composable
private fun SkillChip(
    skill: Skill,
    modifier: Modifier = Modifier
) {
    AssistChip(
        onClick = { },
        label = {
            Text(
                text = if (skill.proficiencyLevel != null) {
                    "${skill.name} (${skill.proficiencyLevel}%)"
                } else {
                    skill.name
                },
                style = MaterialTheme.typography.bodyMedium
            )
        },
        modifier = modifier
    )
}

private val SkillCategory.displayName: String
    get() = when (this) {
        SkillCategory.LANGUAGE -> "Languages"
        SkillCategory.FRAMEWORK -> "Frameworks"
        SkillCategory.TOOL -> "Tools"
        SkillCategory.DATABASE -> "Databases"
        SkillCategory.OTHER -> "Other"
        SkillCategory.ARCHITECTURE -> "Architecture"
    }
