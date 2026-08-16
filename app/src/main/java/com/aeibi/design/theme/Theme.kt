package com.aeibi.design.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = MossLight,
    onPrimary = DarkBackground,
    primaryContainer = MossContainerDark,
    onPrimaryContainer = DarkOnSurface,
    background = DarkBackground,
    onBackground = DarkOnSurface,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
    outlineVariant = DarkOutline,
  )

private val LightColorScheme =
  lightColorScheme(
    primary = Moss,
    onPrimary = LightSurface,
    primaryContainer = MossContainer,
    onPrimaryContainer = LightOnSurface,
    background = LightBackground,
    onBackground = LightOnSurface,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    outlineVariant = LightOutline,
  )

private val OceanDarkColorScheme =
  darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF93CDED),
    onPrimary = androidx.compose.ui.graphics.Color(0xFF003549),
    primaryContainer = androidx.compose.ui.graphics.Color(0xFF004D68),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFFC9E7FA),
    background = androidx.compose.ui.graphics.Color(0xFF0D1418),
    onBackground = androidx.compose.ui.graphics.Color(0xFFDFE9EE),
    surface = androidx.compose.ui.graphics.Color(0xFF151D21),
    onSurface = androidx.compose.ui.graphics.Color(0xFFDFE9EE),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFF273238),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFFBEC9CF),
    outline = androidx.compose.ui.graphics.Color(0xFF3F4A50),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFF3F4A50),
  )

private val OceanLightColorScheme =
  lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF245F77),
    onPrimary = androidx.compose.ui.graphics.Color.White,
    primaryContainer = androidx.compose.ui.graphics.Color(0xFFC9E7FA),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFF001E2A),
    background = androidx.compose.ui.graphics.Color(0xFFF5FAFD),
    onBackground = androidx.compose.ui.graphics.Color(0xFF171C1F),
    surface = androidx.compose.ui.graphics.Color(0xFFFBFDFE),
    onSurface = androidx.compose.ui.graphics.Color(0xFF171C1F),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFFDFE9EE),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFF56636A),
    outline = androidx.compose.ui.graphics.Color(0xFFBAC6CC),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFFBAC6CC),
  )

private val VioletDarkColorScheme =
  darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFFD6C1FF),
    onPrimary = androidx.compose.ui.graphics.Color(0xFF3C176E),
    primaryContainer = androidx.compose.ui.graphics.Color(0xFF542D86),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFFECDDFF),
    background = androidx.compose.ui.graphics.Color(0xFF17121D),
    onBackground = androidx.compose.ui.graphics.Color(0xFFEAE2F0),
    surface = androidx.compose.ui.graphics.Color(0xFF201927),
    onSurface = androidx.compose.ui.graphics.Color(0xFFEAE2F0),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFF322A3B),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFFD0C4D5),
    outline = androidx.compose.ui.graphics.Color(0xFF4A414F),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFF4A414F),
  )

private val VioletLightColorScheme =
  lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF684095),
    onPrimary = androidx.compose.ui.graphics.Color.White,
    primaryContainer = androidx.compose.ui.graphics.Color(0xFFECDDFF),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFF260050),
    background = androidx.compose.ui.graphics.Color(0xFFFCF8FF),
    onBackground = androidx.compose.ui.graphics.Color(0xFF1D1A20),
    surface = androidx.compose.ui.graphics.Color(0xFFFFFBFF),
    onSurface = androidx.compose.ui.graphics.Color(0xFF1D1A20),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFFEDE5F0),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFF655C69),
    outline = androidx.compose.ui.graphics.Color(0xFFCDC3D0),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFFCDC3D0),
  )

private val CoralDarkColorScheme =
  darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFFFFB4A7),
    onPrimary = androidx.compose.ui.graphics.Color(0xFF5B1A10),
    primaryContainer = androidx.compose.ui.graphics.Color(0xFF7A2F23),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFFFFDAD3),
    background = androidx.compose.ui.graphics.Color(0xFF1B1210),
    onBackground = androidx.compose.ui.graphics.Color(0xFFF1DFDB),
    surface = androidx.compose.ui.graphics.Color(0xFF241916),
    onSurface = androidx.compose.ui.graphics.Color(0xFFF1DFDB),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFF392B27),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFFD9C1BB),
    outline = androidx.compose.ui.graphics.Color(0xFF51413D),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFF51413D),
  )

private val CoralLightColorScheme =
  lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF914D3F),
    onPrimary = androidx.compose.ui.graphics.Color.White,
    primaryContainer = androidx.compose.ui.graphics.Color(0xFFFFDAD3),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFF3B0A04),
    background = androidx.compose.ui.graphics.Color(0xFFFFF8F6),
    onBackground = androidx.compose.ui.graphics.Color(0xFF231A18),
    surface = androidx.compose.ui.graphics.Color(0xFFFFFBFF),
    onSurface = androidx.compose.ui.graphics.Color(0xFF231A18),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFFF5E5E1),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFF6D5B56),
    outline = androidx.compose.ui.graphics.Color(0xFFD4C1BC),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFFD4C1BC),
  )

@Composable
fun VibeDesignTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  colorTheme: ColorTheme = ColorTheme.DEFAULT,
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      else -> colorTheme.colorScheme(darkTheme)
    }

  CompositionLocalProvider(
    LocalSpacing provides Spacing(),
    LocalDimensions provides Dimensions(),
  ) {
    MaterialTheme(
      colorScheme = colorScheme,
      typography = Typography,
      shapes = AppShapes,
      content = content,
    )
  }
}

private fun ColorTheme.colorScheme(darkTheme: Boolean) =
  when (this) {
    ColorTheme.DEFAULT -> if (darkTheme) DarkColorScheme else LightColorScheme
    ColorTheme.OCEAN -> if (darkTheme) OceanDarkColorScheme else OceanLightColorScheme
    ColorTheme.VIOLET -> if (darkTheme) VioletDarkColorScheme else VioletLightColorScheme
    ColorTheme.CORAL -> if (darkTheme) CoralDarkColorScheme else CoralLightColorScheme
  }

fun ColorTheme.previewColors(): List<Color> =
  when (this) {
    ColorTheme.DEFAULT -> listOf(Color(0xFF356757), Color(0xFFD5E8E0), Color(0xFF111715))
    ColorTheme.OCEAN -> listOf(Color(0xFF245F77), Color(0xFFC9E7FA), Color(0xFF0D1418))
    ColorTheme.VIOLET -> listOf(Color(0xFF684095), Color(0xFFECDDFF), Color(0xFF17121D))
    ColorTheme.CORAL -> listOf(Color(0xFF914D3F), Color(0xFFFFDAD3), Color(0xFF1B1210))
  }
