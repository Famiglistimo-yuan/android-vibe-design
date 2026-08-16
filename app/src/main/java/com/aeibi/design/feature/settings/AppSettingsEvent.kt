package com.aeibi.design.feature.settings

import com.aeibi.design.theme.ColorTheme

/** User-initiated changes to application-wide settings. */
sealed interface AppSettingsEvent {
  data object ToggleThemeMode : AppSettingsEvent

  data class SelectColorTheme(val colorTheme: ColorTheme) : AppSettingsEvent
}
