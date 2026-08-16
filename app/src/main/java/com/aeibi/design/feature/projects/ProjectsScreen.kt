package com.aeibi.design.feature.projects

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.fallback
import com.aeibi.design.theme.SystemAppIconShape
import com.aeibi.design.theme.VibeDesignTheme
import com.aeibi.design.theme.spacing

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProjectsScreen(
  modifier: Modifier = Modifier,
  isDarkTheme: Boolean = false,
  onThemeToggle: () -> Unit = {},
) {
  val spacing = MaterialTheme.spacing
  Scaffold(
    modifier = modifier.fillMaxSize(),
    topBar = {
      TopAppBar(
        title = { Text("Aeibi") },
        actions = {
          IconButton(onClick = onThemeToggle) {
            Icon(
              imageVector = if (isDarkTheme) Icons.Filled.LightMode else Icons.Filled.DarkMode,
              contentDescription = if (isDarkTheme) "切换到浅色模式" else "切换到深色模式",
            )
          }
          IconButton(onClick = {}) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "新建项目")
          }
          IconButton(onClick = {}) {
            Icon(imageVector = Icons.Filled.Settings, contentDescription = "设置")
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
        ProjectListItem(
          name = "日常发芽",
          description = "不焦虑的日常习惯记录",
          updatedAt = "刚刚修改",
        )
      }
      item {
        ProjectListItem(
          name = "周末去哪",
          description = "根据心情生成短途路线",
          updatedAt = "昨天修改",
        )
      }
      item {
        ProjectListItem(
          name = "专注计时器",
          description = "把大任务切成可完成的小段",
          updatedAt = "8月6日修改",
        )
      }
      item {
        ProjectListItem(
          name = "专注计时器",
          description = "把大任务切成可完成的小段",
          updatedAt = "8月6日修改",
        )
      }
      item {
        ProjectListItem(
          name = "专注计时器",
          description = "把大任务切成可完成的小段",
          updatedAt = "8月6日修改",
        )
      }
      item {
        ProjectListItem(
          name = "专注计时器",
          description = "把大任务切成可完成的小段",
          updatedAt = "8月6日修改",
        )
      }
      item {
        ProjectListItem(
          name = "专注计时器",
          description = "把大任务切成可完成的小段",
          updatedAt = "8月6日修改",
        )
      }
      item {
        ProjectListItem(
          name = "专注计时器",
          description = "把大任务切成可完成的小段",
          updatedAt = "8月6日修改",
        )
      }
      item {
        ProjectListItem(
          name = "专注计时器",
          description = "把大任务切成可完成的小段",
          updatedAt = "8月6日修改",
        )
      }
    }
  }
}

@Composable
private fun ProjectListItem(
  name: String,
  description: String,
  updatedAt: String,
  iconUri: String? = null,
) {
  val context = LocalContext.current
  val defaultIcon = context.packageManager.defaultActivityIcon

  val spacing = MaterialTheme.spacing
  val shape = MaterialTheme.shapes.small
  Row(
    modifier =
      Modifier.fillMaxWidth()
        .height(IntrinsicSize.Min)
        .clip(shape)
        .background(MaterialTheme.colorScheme.surface)
        .border(1.dp, MaterialTheme.colorScheme.outlineVariant, shape)
        .padding(spacing.md),
    horizontalArrangement = Arrangement.spacedBy(spacing.md),
  ) {
    AsyncImage(
      model =
        ImageRequest.Builder(context)
          .data(iconUri)
          .fallback(defaultIcon)
          .error(defaultIcon)
          .build(),
      contentDescription = "$name App Icon",
      modifier = Modifier.size(84.dp).clip(SystemAppIconShape),
      contentScale = ContentScale.Fit,
    )

    Column(modifier = Modifier.weight(1f)) {
      Text(
        text = name,
        color = MaterialTheme.colorScheme.onSurface,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
      )
      Text(
        text = description,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.bodySmall,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
      )
      Spacer(modifier = Modifier.weight(1f))
      Text(
        text = updatedAt,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.labelSmall,
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ProjectsScreenPreview() {
  VibeDesignTheme(dynamicColor = false) { ProjectsScreen() }
}

@Preview(showBackground = true, widthDp = 340, heightDp = 700)
@Composable
fun ProjectsScreenPortraitPreview() {
  VibeDesignTheme(dynamicColor = false) { ProjectsScreen() }
}
