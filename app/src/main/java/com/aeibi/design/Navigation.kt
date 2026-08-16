package com.aeibi.design

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.aeibi.design.feature.projects.ProjectsScreen
import com.aeibi.design.feature.settings.AppSettingsEvent
import com.aeibi.design.feature.settings.SettingsScreen
import com.aeibi.design.data.settings.AppSettings

@Composable
fun MainNavigation(
  settings: AppSettings,
  onSettingsEvent: (AppSettingsEvent) -> Unit,
) {
  val backStack = rememberNavBackStack(Main)

  NavDisplay(
    backStack = backStack,
    onBack = { backStack.removeLastOrNull() },
    entryProvider =
      entryProvider {
        entry<Main> {
          ProjectsScreen(
            modifier = Modifier.fillMaxSize().safeDrawingPadding(),
            isDarkTheme = settings.isDarkTheme,
            onThemeToggle = { onSettingsEvent(AppSettingsEvent.ToggleThemeMode) },
            onSettingsClick = { backStack.add(Settings) },
          )
        }
        entry<Settings> {
          SettingsScreen(
            modifier = Modifier.fillMaxSize().safeDrawingPadding(),
            settings = settings,
            onSettingsEvent = onSettingsEvent,
            onBackClick = { backStack.removeLastOrNull() },
          )
        }
      },
  )
}
