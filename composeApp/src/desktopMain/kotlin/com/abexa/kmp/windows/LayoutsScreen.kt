package com.abexa.kmp.windows

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abexa.kmp.utils.*
import kmpdesktop.composeapp.generated.resources.Res
import kmpdesktop.composeapp.generated.resources.compose_multiplatform
import kmpdesktop.composeapp.generated.resources.happy_halloween
import kmpdesktop.composeapp.generated.resources.partizano
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun simpleProportionalColumn() {
    Column(Modifier.fillMaxSize()) {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Red))
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Green))
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Blue))
    }
}

@Composable
fun simpleProportionalRow() {
    Row(Modifier.fillMaxSize()) {
        Box(Modifier.weight(1f).fillMaxHeight().background(Color.Red))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color.Green))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color.Blue))
    }
}

@Composable
fun simpleItemList() {
    loadPrimaryTheme {
        Row(Modifier.width(200.dp)) {
            Image(
                painter = painterResource(Res.drawable.compose_multiplatform), contentDescription = null,
                Modifier.size(50.dp).align(Alignment.CenterVertically)
            )
            Column(Modifier.fillMaxWidth()) {
                Text(
                    "Title", style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.Start).width(100.dp)
                )
                Text(
                    "Description", style = MaterialTheme.typography.caption,
                    modifier = Modifier.align(Alignment.Start).width(100.dp)
                )
                Text(
                    "View more", style = MaterialTheme.typography.caption,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

// guide work 2
//Objetivo: Crear un layout con un Column, dividiendo el espacio en:
//Header (20%) con un fondo azul
//Body (60%) con un fondo verde
//Footer (20%) con un fondo rojo


@Composable
fun fractionProportionalLayout() {
    loadPrimaryTheme {
        Column(Modifier.fillMaxSize()) {
            Box(Modifier.weight(0.2f).fillMaxWidth().alpha(0.2f).background(Color.Blue))
            Box(Modifier.weight(0.6f).fillMaxWidth().alpha(0.2f).background(Color.Green))
            Box(Modifier.weight(0.2f).fillMaxWidth().alpha(0.2f).background(Color.Red))
        }
    }
}

@Composable
fun fractionProportionalLayout2() {
    loadPrimaryTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.15f)
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Header", color = Color.White, fontSize = 20.sp)
            }

            // Contenido con Sidebar y Body
            Row(modifier = Modifier.weight(0.75f)) {
                // Sidebar
                Box(
                    modifier = Modifier
                        .weight(0.25f)
                        .fillMaxHeight()
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Sidebar", color = Color.White, fontSize = 18.sp)
                }

                // Content
                Box(
                    modifier = Modifier
                        .weight(0.75f)
                        .fillMaxHeight()
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Content", color = Color.White, fontSize = 18.sp)
                }
            }

            // Footer
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.10f)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Footer", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Composable
@Preview
fun basicStyledBox() {
    loadPrimaryTheme {
        Box(
            modifier = Modifier
                .size(150.dp) // Tamaño del Box
                .background(Color.LightGray, shape = RoundedCornerShape(16.dp)) // Fondo y esquinas redondeadas
                .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(16.dp)) // Borde
                .padding(16.dp) // Espaciado interno
                .shadow(5.dp, shape = RoundedCornerShape(16.dp)) // Sombra
        ) {
            Text(
                text = "Caja Simple",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        }
    }
}

@Composable
fun basicStyledBox2() {
    loadPrimaryTheme {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            modifier = Modifier.size(150.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Caja Simple s",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}



@Composable
//@Preview
fun ComplexStyledBox() {
    loadPrimaryTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF2196F3), Color(0xFF00BCD4)) // Gradiente Azul-Cyan
                    ),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape) // Imagen circular
                        .border(4.dp, Color.White, CircleShape) // Borde blanco
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Hola, Compose!",
                    fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}