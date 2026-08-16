package com.aeibi.design.feature.projects

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.fallback
import com.aeibi.design.theme.SystemAppIconShape
import com.aeibi.design.theme.spacing

@Composable
fun ProjectListItem(
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
