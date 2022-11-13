package com.example.composecompositionlocaldemo.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.example.composecompositionlocaldemo.R

@Composable
fun TextSample() {
    MaterialTheme {
        Column {
            Text(text = "Uses MaterialTheme's provided alpha")
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = "Medium value provided for LocalContentAlpha")
                Text(text = "This Text also uses the medium value")
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                DescendantExample()
            }
            FruitText(2)
        }
    }
}

@Composable
fun DescendantExample() {
    Text(text = "This Text uses the disabled alpha now")
}

@Composable
fun FruitText(fruitSize: Int) {
    //LocalContext 上下文
    val resources = LocalContext.current.resources
    val fruitText = resources.getQuantityText(R.plurals.fruit_title, fruitSize)
    Text(text = "$fruitSize $fruitText")
}