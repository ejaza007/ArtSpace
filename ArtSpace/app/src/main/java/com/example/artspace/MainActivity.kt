package com.example.artspace

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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




@Composable
fun ArtSpaceLayout() {

    var result by remember{
    mutableStateOf(1)}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {


        when (result) {


            1 -> ArtDisplay(
                imageResource = R.drawable.artwork1,
                textResource = stringResource(id = R.string.app_name),
                titleResource = stringResource(
                    id = R.string.test_paint
                )
            )

            2 -> ArtDisplay(
                imageResource = R.drawable.artwork2,
                textResource = stringResource(id = R.string.app_name),
                titleResource = stringResource(
                    id = R.string.test_paint
                )
            )

            3 -> ArtDisplay(
                imageResource = R.drawable.artwork3,
                textResource = stringResource(id = R.string.test_paint),
                titleResource = stringResource(
                    id = R.string.app_name
                )
            )

            4 -> ArtDisplay(
                imageResource = R.drawable.artwork3,
                textResource = stringResource(id = R.string.test_paint),
                titleResource = stringResource(
                    id = R.string.app_name
                )
            )

            5 -> ArtDisplay(
                imageResource = R.drawable.artwork3,
                textResource = stringResource(id = R.string.test_paint),
                titleResource = stringResource(
                    id = R.string.app_name
                )
            )


        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
           verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        {

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

    Card(
        modifier = Modifier
            .padding(16.dp)
            .shadow(4.dp, RectangleShape)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        )
        {


            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .border(
                        border = BorderStroke(
                            2.dp,
                            MaterialTheme.colorScheme.onSurface
                        ), shape = RectangleShape
                    )
                    .height(350.dp)
                    .width(300.dp)
                    .shadow(elevation = 4.dp, shape = RectangleShape)
                    .padding(20.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            Card(modifier = Modifier.padding(horizontal = 20.dp, vertical = 100.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {

                }

                Text(
                    text = titleResource,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.displayMedium

                    )
                Text(
                    text = textResource,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodySmall
                )


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}