package com.aeibi.design.data.settings

import com.aeibi.design.theme.ColorTheme
import com.aeibi.design.theme.ThemeMode

/** Persistent settings that affect the app as a whole. */
data class AppSettings(
  val themeMode: ThemeMode = ThemeMode.LIGHT,
  val colorTheme: ColorTheme = ColorTheme.DEFAULT,
) {
  val isDarkTheme: Boolean
    get() = themeMode == ThemeMode.DARK
}
