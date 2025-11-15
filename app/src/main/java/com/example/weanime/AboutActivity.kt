package com.example.weanime

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weanime.ui.theme.WeAnimeTheme

class AboutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeAnimeTheme {
                AboutScreen(onEmailClick = { sendEmail() })
            }
        }
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf("weanime@support.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Información sobre la aplicación WeAnime")
            putExtra(Intent.EXTRA_TEXT, "Hola, estoy interesad@ en obtener más información sobre la app.")
        }
        startActivity(intent)
    }
}

@Composable
fun AboutScreen(onEmailClick: () -> Unit) {

    // Animación kawaii del logo
    val logoScale by rememberInfiniteTransition().animateFloat(
        initialValue = 1f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(1400, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Fondo degradado kawaii
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFF5F7),
                        Color.White
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {

            // LOGO con animación
            Image(
                painter = painterResource(id = R.drawable.logo_weanime),
                contentDescription = "Logo WeAnime",
                modifier = Modifier
                    .size(160.dp)
                    .graphicsLayer(
                        scaleX = logoScale,
                        scaleY = logoScale
                    )
            )

            Spacer(modifier = Modifier.height(28.dp))

            // TÍTULO rosa
            Text(
                text = "WeAnime",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            // SUBTÍTULO
            Text(
                text = "Red social para fans del anime.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Versión 1.0",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(40.dp))

            // ICONO DE CONTACTO SIMPLE Y BONITO
            IconButton(onClick = onEmailClick) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Contacto",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(46.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Contacto",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
