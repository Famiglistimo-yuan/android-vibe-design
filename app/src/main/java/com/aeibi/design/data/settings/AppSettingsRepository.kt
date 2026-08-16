package com.aeibi.design.data.settings

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.aeibi.design.theme.ColorTheme
import com.aeibi.design.theme.ThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val SETTINGS_DATA_STORE_NAME = "app_settings"

private val Context.appSettingsDataStore by preferencesDataStore(name = SETTINGS_DATA_STORE_NAME)

class AppSettingsRepository(private val context: Context) {
  val settings: Flow<AppSettings> =
    context.appSettingsDataStore.data.map { preferences ->
      AppSettings(
        themeMode = preferences[ThemeModeKey].toThemeMode(),
        colorTheme = preferences[ColorThemeKey].toColorTheme(),
      )
    }

  suspend fun setThemeMode(themeMode: ThemeMode) {
    context.appSettingsDataStore.edit { preferences ->
      preferences[ThemeModeKey] = themeMode.storageId
    }
  }

  suspend fun setColorTheme(colorTheme: ColorTheme) {
    context.appSettingsDataStore.edit { preferences ->
      preferences[ColorThemeKey] = colorTheme.storageId
    }
  }

  private fun String?.toThemeMode(): ThemeMode =
    when (this) {
      "dark", ThemeMode.DARK.name -> ThemeMode.DARK
      else -> ThemeMode.LIGHT
    }

  private fun String?.toColorTheme(): ColorTheme =
    when (this) {
      "ocean", ColorTheme.OCEAN.name -> ColorTheme.OCEAN
      "violet", ColorTheme.VIOLET.name -> ColorTheme.VIOLET
      "coral", ColorTheme.CORAL.name -> ColorTheme.CORAL
      else -> ColorTheme.DEFAULT
    }

  private val ThemeMode.storageId: String
    get() =
      when (this) {
        ThemeMode.LIGHT -> "light"
        ThemeMode.DARK -> "dark"
      }

  private val ColorTheme.storageId: String
    get() =
      when (this) {
        ColorTheme.DEFAULT -> "default"
        ColorTheme.OCEAN -> "ocean"
        ColorTheme.VIOLET -> "violet"
        ColorTheme.CORAL -> "coral"
      }

  private companion object {
    val ThemeModeKey: Preferences.Key<String> = stringPreferencesKey("theme_mode")
    val ColorThemeKey: Preferences.Key<String> = stringPreferencesKey("color_theme")
  }
}
