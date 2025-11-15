package com.example.weanime.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weanime.R

// Fuente para títulos (estilo anime)
val MPlusRounded = FontFamily(
    Font(R.font.mplus_rounded_regular, FontWeight.Normal),
    Font(R.font.mplus_rounded_bold, FontWeight.Bold)
)

// Fuente estándar para texto general
val NotoSans = FontFamily.Default

val WeAnimeTypography = Typography(

    // Títulos principales
    headlineLarge = TextStyle(
        fontFamily = MPlusRounded,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),

    titleLarge = TextStyle(
        fontFamily = MPlusRounded,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),

    // Cuerpo de texto grande
    bodyLarge = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    // Cuerpo de texto normal
    bodyMedium = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
