package egsys.pokedex.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFAD1111),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFA51212),
    onPrimaryContainer = Color.White,
    inversePrimary = Color.White,
    secondary = Color(0xFFEE7B15),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFEE7B15),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFF15AEE7),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFF15AEE7),
    onTertiaryContainer = Color.White,
    background = Color(0xFF212121),
    onBackground = Color.White,
    surface = Color(0xFF303030),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF424242),
    onSurfaceVariant = Color.White,
    inverseOnSurface = Color.White,
    error = Color(0xFFE71D36),
    onError = Color.White,
    onErrorContainer = Color(0xFFE71D36),
    outline = Color(0xFFEFEFEF),
    outlineVariant = Color(0xFFDDDDDD),
    scrim = Color(0x66000000)
)


private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFF86C6C),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFF57373),
    onPrimaryContainer = Color.White,
    inversePrimary = Color.White,
    secondary = Color(0xFFEE7B15),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFEE7B15),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFF15AEE7),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFF15AEE7),
    onTertiaryContainer = Color.White,
    background = Color(0xFFFAFAFA),
    onBackground = Color.Black,
    surface = Color(0xFFFFFFFF),
    onSurface = Color.Black,
    surfaceVariant = Color(0xFFF5F5F5),
    onSurfaceVariant = Color.Black,
    inverseOnSurface = Color.Black,
    error = Color(0xFFE71D36),
    onError = Color.White,
    onErrorContainer = Color(0xFFE71D36),
    outline = Color(0xFFEFEFEF),
    outlineVariant = Color(0xFFDDDDDD),
    scrim = Color(0x66000000)
)


@Composable
fun PokedexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) DarkColorScheme else LightColorScheme
        }
        darkTheme -> DarkColorScheme

        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}