package com.demo.bookclubkmp.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.demo.bookclubkmp.android.MyApplicationTheme
import com.demo.bookclubkmp.android.R

@Composable
fun  UIAvatarCard(name: String, avatarUrl: String? = null ) {
    Surface {
        Column(modifier = Modifier
            .width(140.dp)
            .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = avatarUrl,
                contentDescription = "Avatar picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally),
                placeholder = painterResource(id = R.drawable.connection_error),
                error = painterResource(id = R.drawable.connection_error)
            )
            Text(modifier = Modifier.padding(top = 8.dp),
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2)
        }
    }
}

@Preview
@Composable
fun  UIAvatarCardPreview() {
    MyApplicationTheme {
        UIAvatarCard(
            name = "User Name",
            avatarUrl = "noUrl"
        )
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun UIAvatarCardNightPreview() {
    MyApplicationTheme {
        UIAvatarCard(
            name = "User Name",
            avatarUrl = "noUrl"
        )
    }
}