package com.example.rickandmortyapi.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.rickandmortyapi.domain.model.Characters

@Composable
fun CharacterItem(modifier: Modifier = Modifier, item: Characters, onItemclicked: (Int) -> Unit) {
    Row(
        modifier = modifier
            .clickable {
                onItemclicked(item.id)
            }
            .padding(start = 6.dp, top = 12.dp, bottom = 12.dp)
    ) {
        CharacterImageContainer(modifier = Modifier.size(64.dp)) {
            CharacterImage(item = item)

        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        ) {
            Text(text = item.name, style = MaterialTheme.typography.bodyLarge)
            CompositionLocalProvider(LocalContentColor provides LocalContentColor.current.copy(alpha = 0.4f)) {
                Text(text = item.specie, style = MaterialTheme.typography.bodyMedium)
            }
        }
        Divider(Modifier.padding(top = 10.dp))

    }

}

@Composable
fun CharacterImage(item: Characters) {
    Box {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current).data(item.image).size(Size.ORIGINAL)
                .build()
        )
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun CharacterImageContainer(modifier: Modifier, content: @Composable () -> Unit) {
    Surface(modifier = modifier.aspectRatio(1f), RoundedCornerShape(4.dp)) {
        content()
    }
}
