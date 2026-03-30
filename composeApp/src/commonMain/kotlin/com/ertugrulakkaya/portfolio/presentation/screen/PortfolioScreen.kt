package com.ertugrulakkaya.portfolio.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import com.ertugrulakkaya.portfolio.presentation.components.ErrorState
import com.ertugrulakkaya.portfolio.presentation.components.LoadingState
import com.ertugrulakkaya.portfolio.presentation.components.ProfileHeader
import com.ertugrulakkaya.portfolio.presentation.components.ProjectsSection
import com.ertugrulakkaya.portfolio.presentation.components.SkillsSection
import com.ertugrulakkaya.portfolio.presentation.components.EducationSection
import com.ertugrulakkaya.portfolio.presentation.components.ExperienceSection
import com.ertugrulakkaya.portfolio.presentation.viewmodel.PortfolioViewModel

import org.koin.compose.koinInject

@Composable
fun PortfolioScreen(
    viewModel: PortfolioViewModel = koinInject()
) {
    val uiState by viewModel.uiState.collectAsState()
    val isLoading = uiState.isLoading
    val error = uiState.error
    val data = uiState.data

    val isDark = isSystemInDarkTheme()
    val bgColor = MaterialTheme.colorScheme.background
    val surfaceVariantColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
    val primaryContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.15f)

    val backgroundBrush = remember(isDark, bgColor, surfaceVariantColor, primaryContainerColor) {
        if (isDark) {
            Brush.verticalGradient(
                colors = listOf(
                    bgColor,
                    surfaceVariantColor,
                    bgColor
                )
            )
        } else {
            Brush.verticalGradient(
                colors = listOf(
                    bgColor,
                    primaryContainerColor,
                    bgColor
                )
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {
        if (data != null) {
            PortfolioContent(data = data)
        }

        if (isLoading) {
            if (data == null) {
                LoadingState()
            } else {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                )
            }
        }

        if (error != null) {
            if (data == null) {
                ErrorState(error = error)
            } else {
                Snackbar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp),
                    action = {
                        TextButton(onClick = { viewModel.loadPortfolioData() }) {
                            Text("Retry")
                        }
                    }
                ) {
                    Text(error)
                }
            }
        }
    }
}

@Composable
private fun SectionCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            content()
        }
    }
}

@Composable
private fun PortfolioContent(
    data: PortfolioData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        ProfileHeader(profile = data.profile)

        Spacer(modifier = Modifier.height(48.dp))

        SectionCard {
            ProjectsSection(projects = data.projects)
        }

        Spacer(modifier = Modifier.height(24.dp))

        SectionCard {
            ExperienceSection(experiences = data.experiences)
        }

        Spacer(modifier = Modifier.height(24.dp))

        SectionCard {
            EducationSection(education = data.education)
        }

        Spacer(modifier = Modifier.height(24.dp))

        SectionCard {
            SkillsSection(skills = data.skills)
        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}
