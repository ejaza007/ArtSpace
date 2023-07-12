package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.surfaceColorAtElevation
import java.lang.RuntimeException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceScreen() {
    var result by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (result) {
            1 -> ArtDisplay(
                imageResource = R.drawable.artwork1,
                textResource = "Leonardo Da Vinci (1503)",
                titleResource = "Mona Lisa "
            )
            2 -> ArtDisplay(
                imageResource = R.drawable.artwork2,
                textResource = "Vincent Van Gogh (1898)",
                titleResource = "Starry Night"
            )
            3 -> ArtDisplay(
                imageResource = R.drawable.artwork4,
                textResource = "Rene Magritte (1928)",
                titleResource = "The Lovers"
            )
            4 -> ArtDisplay(
                imageResource = R.drawable.artwork5,
                textResource = "Edward Munch (1893)",
                titleResource = "The Scream"
            )
            5 -> ArtDisplay(
                imageResource = R.drawable.artwork6,
                textResource = "Sandro Botticelli (1480)",
                titleResource = "Birth of Venus"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Button(
                onClick = {
                    if (result == 1) {
                        result = 1
                    } else {
                        result--
                    }
                },
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            ) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    if (result == 5) {
                        result = 1
                    } else {
                        result++
                    }
                },
                modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun ArtDisplay(imageResource: Int, textResource: String, titleResource: String) {
    ElevatedCard(
        modifier = Modifier.padding(16.dp)

    ) {

    }
    Card(
        modifier = Modifier
            .padding(16.dp)
            .border(
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.onSurface),
                shape = RectangleShape
            )
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = titleResource,
                style = MaterialTheme.typography.displayMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = textResource,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
