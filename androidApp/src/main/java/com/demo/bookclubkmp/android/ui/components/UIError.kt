package com.demo.bookclubkmp.android.ui.components

import com.demo.bookclubkmp.android.MyApplicationTheme

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.bookclubkmp.android.R

@Composable
fun UIError(
    title: String? = null,
    message: String? = null,
    onRetry: () -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.connection_error), contentDescription = "UI Error Image")
            Text(title ?: stringResource(R.string.error_generic_title), style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(16.dp))
            Text(message ?: stringResource(R.string.error_generic_description))
            Button(
                onClick = onRetry,
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Reload")
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
)
fun UIErrorPreview() {
    MyApplicationTheme {
        UIError(onRetry = {})
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun UIErrorNightPreview() {
    MyApplicationTheme {
        UIError(onRetry = {})
    }
}