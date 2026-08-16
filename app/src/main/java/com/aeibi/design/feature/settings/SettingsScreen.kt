package com.aeibi.design.feature.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import com.aeibi.design.data.settings.AppSettings
import com.aeibi.design.theme.dimensions
import com.aeibi.design.theme.previewColors
import com.aeibi.design.theme.spacing
import com.aeibi.design.theme.ColorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
  modifier: Modifier = Modifier,
  settings: AppSettings = AppSettings(),
  onSettingsEvent: (AppSettingsEvent) -> Unit = {},
  onBackClick: () -> Unit = {},
) {
  val spacing = MaterialTheme.spacing
  Scaffold(
    modifier = modifier.fillMaxSize(),
    topBar = {
      TopAppBar(
        title = { Text("设置") },
        navigationIcon = {
          IconButton(onClick = onBackClick) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "返回",
            )
          }
        },
      )
    },
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier.fillMaxSize().padding(innerPadding).navigationBarsPadding(),
      contentPadding = PaddingValues(horizontal = spacing.md, vertical = spacing.lg),
      verticalArrangement = Arrangement.spacedBy(spacing.md),
    ) {
      item {
        Text(text = "颜色主题", style = MaterialTheme.typography.titleMedium)
      }
      item {
        Row(horizontalArrangement = Arrangement.spacedBy(spacing.sm)) {
          ColorTheme.entries.forEach { theme ->
            ThemeOption(
              theme = theme,
              selected = theme == settings.colorTheme,
              onClick = { onSettingsEvent(AppSettingsEvent.SelectColorTheme(theme)) },
              modifier = Modifier.weight(1f),
            )
          }
        }
      }
    }
  }
}

@Composable
private fun ThemeOption(
  theme: ColorTheme,
  selected: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val dimensions = MaterialTheme.dimensions

  Card(
    modifier =
      modifier
        .height(dimensions.themeOptionHeight)
        .semantics {
          contentDescription = "${theme.displayName}颜色主题"
          role = Role.RadioButton
          this.selected = selected
        }
        .clickable(onClick = onClick),
    shape = MaterialTheme.shapes.medium,
    border =
      if (selected) {
        BorderStroke(dimensions.borderSelected, MaterialTheme.colorScheme.primary)
      } else {
        null
      },
  ) {
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
      Row(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        theme.previewColors().forEach { color ->
          Box(
            modifier =
              Modifier.weight(1f)
                .fillMaxHeight()
                .background(color),
          )
        }
      }
      if (selected) {
        Icon(
          imageVector = Icons.Filled.Check,
          contentDescription = null,
          tint = Color.White,
          modifier = Modifier.align(Alignment.Center),
        )
      }
    }
  }
}

private val ColorTheme.displayName: String
  get() =
    when (this) {
      ColorTheme.DEFAULT -> "苔藓绿"
      ColorTheme.OCEAN -> "海蓝"
      ColorTheme.VIOLET -> "紫罗兰"
      ColorTheme.CORAL -> "珊瑚"
    }
