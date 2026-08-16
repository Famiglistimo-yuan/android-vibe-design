package com.aeibi.design.feature.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aeibi.design.data.settings.AppSettings
import com.aeibi.design.data.settings.AppSettingsRepository
import com.aeibi.design.theme.ThemeMode
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppSettingsViewModel(private val repository: AppSettingsRepository) : ViewModel() {
  val settings: StateFlow<AppSettings> =
    repository.settings.stateIn(
      scope = viewModelScope,
      started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
      initialValue = AppSettings(),
    )

  fun onEvent(event: AppSettingsEvent) {
    viewModelScope.launch {
      when (event) {
        AppSettingsEvent.ToggleThemeMode -> {
          val nextThemeMode =
            if (settings.value.themeMode == ThemeMode.DARK) ThemeMode.LIGHT else ThemeMode.DARK
          repository.setThemeMode(nextThemeMode)
        }
        is AppSettingsEvent.SelectColorTheme -> repository.setColorTheme(event.colorTheme)
      }
    }
  }
}

class AppSettingsViewModelFactory(context: Context) : ViewModelProvider.Factory {
  private val repository = AppSettingsRepository(context.applicationContext)

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    check(modelClass.isAssignableFrom(AppSettingsViewModel::class.java))
    return AppSettingsViewModel(repository) as T
  }
}
