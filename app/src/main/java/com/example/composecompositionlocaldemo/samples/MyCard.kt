package com.example.composecompositionlocaldemo.samples

import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Elevations(val elevation: Dp = 0.dp)

val LocalElevations = compositionLocalOf { Elevations() }

object CardElevation {
    val high: Elevations
        get() = Elevations(10.dp)
    val low: Elevations
        get() = Elevations(5.dp)
}

@Composable
fun MyCard(
    elevation: Dp = LocalElevations.current.elevation,
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    Card(
        elevation = elevation,
        modifier = Modifier.size(200.dp),
        backgroundColor = backgroundColor,
        content = content
    )
}