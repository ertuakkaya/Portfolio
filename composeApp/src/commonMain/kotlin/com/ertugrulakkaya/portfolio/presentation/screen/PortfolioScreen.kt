package com.ertugrulakkaya.portfolio.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import com.ertugrulakkaya.portfolio.presentation.components.ErrorState
import com.ertugrulakkaya.portfolio.presentation.components.LoadingState
import com.ertugrulakkaya.portfolio.presentation.components.ProfileHeader
import com.ertugrulakkaya.portfolio.presentation.components.ProjectsSection
import com.ertugrulakkaya.portfolio.presentation.components.SkillsSection
import com.ertugrulakkaya.portfolio.presentation.components.EducationSection
import com.ertugrulakkaya.portfolio.presentation.components.ExperienceSection
import com.ertugrulakkaya.portfolio.presentation.components.LeadershipSection
import com.ertugrulakkaya.portfolio.presentation.viewmodel.PortfolioViewModel
import com.ertugrulakkaya.portfolio.presentation.viewmodel.ThemeViewModel
import org.koin.compose.koinInject

@Composable
fun PortfolioScreen(
    viewModel: PortfolioViewModel = koinInject(),
    themeViewModel: ThemeViewModel = koinInject()
) {
    val uiState by viewModel.uiState.collectAsState()
    val isLoading = uiState.isLoading
    val error = uiState.error
    val data = uiState.data
    val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()
    val bgColor = MaterialTheme.colorScheme.background
    val surfaceVariantColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
    val primaryContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.15f)

    val backgroundBrush = remember(isDarkTheme, bgColor, surfaceVariantColor, primaryContainerColor) {
        if (isDarkTheme) {
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
            PortfolioContent(
                data = data,
                isDarkTheme = isDarkTheme,
                onToggleTheme = { themeViewModel.toggleTheme() }
            )
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
            .padding(horizontal = 32.dp),
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
private fun AnimatedSectionCard(
    visible: Boolean,
    delayMillis: Int = 0,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(visible) {
        if (visible) {
            if (delayMillis > 0) {
                delay(delayMillis.toLong())
            }
            startAnimation = true
        } else {
            startAnimation = false
        }
    }

    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 600),
        label = "section_alpha"
    )

    val offsetY by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 50f,
        animationSpec = tween(durationMillis = 600),
        label = "section_offset"
    )

    SectionCard(
        modifier = modifier
            .graphicsLayer(alpha = alpha, translationY = offsetY)
    ) {
        content()
    }
}

@Composable
private fun PortfolioContent(
    data: PortfolioData,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    var sectionsVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        sectionsVisible = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        AnimatedSectionCard(visible = sectionsVisible, delayMillis = 0) {
            ProfileHeader(
                profile = data.profile,
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        AnimatedSectionCard(visible = sectionsVisible, delayMillis = 100) {
            ProjectsSection(projects = data.projects)
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedSectionCard(visible = sectionsVisible, delayMillis = 200) {
            ExperienceSection(experiences = data.experiences)
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedSectionCard(visible = sectionsVisible, delayMillis = 300) {
            EducationSection(education = data.education)
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedSectionCard(visible = sectionsVisible, delayMillis = 400) {
            LeadershipSection(leadership = data.leadership)
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedSectionCard(visible = sectionsVisible, delayMillis = 500) {
            SkillsSection(skills = data.skills)
        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}
