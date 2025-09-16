package com.example.togglecardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.togglecardapp.ui.theme.ToggleCardAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToggleCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ToggleCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ToggleCard( modifier: Modifier = Modifier) {
    // Remember and save the toggle state across recompositions and config changes
    var toggled by rememberSaveable { mutableStateOf(false) }

    // Column to center content vertically and horizontally filling the whole screen
    Column(
        modifier = Modifier
            .fillMaxSize(), // Fill entire screen
        verticalArrangement = Arrangement.Center, // Center Vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center Horizontally
    )
    {
        Card(
            onClick = { toggled = !toggled } // Handle click

        ) {
            Text(
                text = if (toggled) "Kotlin was created by JetBrains!" else "Tap to see a fun fact!",
                modifier = Modifier.padding(40.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToggleCardAppTheme {
        ToggleCard()
    }
}