package com.demo.bookclubkmp.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.bookclubkmp.android.MyApplicationTheme

@Composable
fun UIPageHeader(text: String) {
    Surface(modifier = Modifier.padding(16.dp)) {
        Text(text, style = MaterialTheme.typography.displaySmall)
    }
}

@Preview
@Composable
fun  UIPageHeaderPreview() {
    MyApplicationTheme {
        UIPageHeader("Header")
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun  UIPageHeaderPreviewNight() {
    MyApplicationTheme {
        UIPageHeader("Header")
    }
}