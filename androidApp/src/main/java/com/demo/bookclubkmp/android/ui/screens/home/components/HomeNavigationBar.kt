package com.demo.bookclubkmp.android.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.demo.bookclubkmp.android.MyApplicationTheme
import com.demo.bookclubkmp.android.R

@Composable
fun HomeNavigationBar(
    tabIndex: Int,
    onTabSelected: (index: Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.primary
    ) {

        NavigationBarItem(
            label = {
                Text(text = stringResource(id = R.string.nav_books))
            },
            selected = tabIndex == 0,
            onClick = { onTabSelected(0)},
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Localized description"
                )
            })

        NavigationBarItem(
            label = {
                Text(text = stringResource(id = R.string.nav_search))
            },
            selected = tabIndex == 1,

            onClick = {
                onTabSelected(1)
            }, icon = {
                Icon(Icons.Filled.Search, contentDescription = "Localized description")
            })
    }
}

@Composable
@Preview
fun HomeNavigationBarPreview() {
    MyApplicationTheme {
        HomeNavigationBar(tabIndex = 0, onTabSelected = {})
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun HomeNavigationBarNightPreview() {
    MyApplicationTheme {
        HomeNavigationBar(tabIndex = 0, onTabSelected = {})
    }
}