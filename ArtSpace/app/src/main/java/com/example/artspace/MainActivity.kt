package com.example.artspace

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

class Artwork(val name: String, val artist: String, val image: Int)

@Composable
fun ArtSpaceLayout() {
    val artworkList = listOf(
        Artwork("Artwork 1", "Artist 1", R.drawable.artwork1),
        Artwork("Artwork 2", "Artist 2", R.drawable.artwork2),
        Artwork("Artwork 3", "Artist 3", R.drawable.artwork3)
    )

    var currentIndex = 0

    Column {
        ArtDisplay(artworkList[currentIndex])
        ArtTextField(artworkList[currentIndex])
        moveButton(artworkList.size, currentIndex) {
            currentIndex += it
            if (currentIndex < 0) {
                currentIndex = artworkList.size - 1
            } else if (currentIndex >= artworkList.size) {
                currentIndex = 0
            }
        }
    }
}

@Composable
fun ArtDisplay(artwork: Artwork) {
    val painter = painterResource(id = artwork.image)
    val contentDescription = null
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
        androidx.compose.foundation.Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ArtTextField(artwork: Artwork) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
        androidx.compose.material3.Text(text = artwork.name)
        androidx.compose.material3.Text(text = artwork.artist)
    }
}

@Composable
fun moveButton(maxSize: Int, currentIndex: Int, onMove: (Int) -> Unit) {

}


@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}
