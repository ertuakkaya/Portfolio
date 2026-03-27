package com.ertugrulakkaya.portfolio.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.presentation.components.*
import com.ertugrulakkaya.portfolio.presentation.viewmodel.PortfolioUiState
import com.ertugrulakkaya.portfolio.presentation.viewmodel.PortfolioViewModel
import org.koin.compose.koinInject

@Composable
fun PortfolioScreen(
    viewModel: PortfolioViewModel = koinInject()
) {
    val uiState by viewModel.uiState.collectAsState()

    PortfolioContent(uiState = uiState)
}

@Composable
private fun PortfolioContent(
    uiState: PortfolioUiState,
    modifier: Modifier = Modifier
) {
    when {
        uiState.isLoading -> {
            LoadingState(modifier = modifier)
        }
        uiState.error != null -> {
            ErrorState(
                error = uiState.error!!,
                modifier = modifier
            )
        }
        uiState.data != null -> {
            val data = uiState.data!!
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                ProfileHeader(profile = data.profile)

                HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

                ProjectsSection(projects = data.projects)

                HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

                ExperienceSection(experiences = data.experiences)

                HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

                EducationSection(education = data.education)

                HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

                SkillsSection(skills = data.skills)

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
private fun LoadingState(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorState(
    error: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Error",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.error
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = error,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
