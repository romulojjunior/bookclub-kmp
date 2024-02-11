package com.demo.bookclubkmp.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.demo.bookclubkmp.android.R

@Composable
fun  UIBookCard(title: String, imageUrl: String? = null ) {
    Surface {
        Column(modifier = Modifier.width(140.dp).padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Card(modifier = Modifier
                .width(140.dp)
                .height(200.dp)) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Book cover",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                    placeholder = painterResource(id = R.drawable.connection_error),
                    error = painterResource(id = R.drawable.connection_error)
                )
            }
            Text(modifier = Modifier.padding(top = 8.dp),
                text = title,
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2)
        }
    }
}

@Preview
@Composable
fun  UIBookCardPreview() {
    MaterialTheme {
        UIBookCard(
            title = "Book Card title sample",
            imageUrl = "noUrl"
        )
    }
}