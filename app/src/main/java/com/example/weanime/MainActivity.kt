package com.example.weanime

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weanime.ui.theme.WeAnimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeAnimeTheme {
                MainScreen(
                    onOpenAbout = {
                        startActivity(Intent(this, AboutActivity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(onOpenAbout: () -> Unit) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onOpenAbout) {
            Text("Abrir pantalla Sobre la App")
        }
    }
}
