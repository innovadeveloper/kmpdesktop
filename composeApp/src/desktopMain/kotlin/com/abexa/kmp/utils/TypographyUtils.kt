package com.abexa.kmp.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kmpdesktop.composeapp.generated.resources.Res
import kmpdesktop.composeapp.generated.resources.happy_halloween
import org.jetbrains.compose.resources.Font
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kmpdesktop.composeapp.generated.resources.fledglingsb
import kmpdesktop.composeapp.generated.resources.partizano

@Composable
fun textStyleTitle() : TextStyle {
    return TextStyle(
        fontFamily = FontFamily(Font(Res.font.partizano)),
        fontSize = 22.sp,
        lineHeight = 26.sp, // Espaciado entre líneas
        letterSpacing = 2.sp // Espaciado entre letras
    )
}

@Composable
fun textStyleSubtitle() : TextStyle {
    return TextStyle(
        fontFamily = FontFamily(Font(Res.font.fledglingsb)),
        fontSize = 18.sp,
        lineHeight = 26.sp, // Espaciado entre líneas
        letterSpacing = 2.sp // Espaciado entre letras
    )
}

@Composable
fun textStyleCaption() : TextStyle {
    return TextStyle(
        fontFamily = FontFamily(Font(Res.font.fledglingsb)),
        fontSize = 16.sp,
        lineHeight = 26.sp, // Espaciado entre líneas
        letterSpacing = 2.sp // Espaciado entre letras
    )
}

@Composable
fun typographyApp() : Typography {
    val title = FontFamily(Font(Res.font.partizano))
    val captionFamily = FontFamily(Font(Res.font.fledglingsb))
    return Typography(defaultFontFamily = captionFamily,
        h1 = TextStyle(fontFamily = title, fontWeight = FontWeight.Bold, fontSize = 20.sp),
        caption = TextStyle(fontFamily = captionFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp),)
}

@Composable
fun loadPrimaryTheme(content : @Composable () -> Unit) {
    MaterialTheme(typography = typographyApp()){
        content()
    }
}