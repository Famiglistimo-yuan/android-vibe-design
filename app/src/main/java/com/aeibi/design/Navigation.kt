package com.aeibi.design

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.aeibi.design.feature.projects.ProjectsScreen

@Composable
fun MainNavigation(isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
  val backStack = rememberNavBackStack(Main)

  NavDisplay(
    backStack = backStack,
    onBack = { backStack.removeLastOrNull() },
    entryProvider =
      entryProvider {
        entry<Main> {
          ProjectsScreen(
            modifier = Modifier.fillMaxSize().safeDrawingPadding(),
            isDarkTheme = isDarkTheme,
            onThemeToggle = onThemeToggle,
          )
        }
      },
  )
}
