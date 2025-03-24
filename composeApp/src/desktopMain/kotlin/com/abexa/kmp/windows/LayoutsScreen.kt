package com.abexa.kmp.windows

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
@Preview
fun simpleItemList() {
    loadPrimaryTheme {
        Row(Modifier.fillMaxWidth()) {
            Image(painter = painterResource(Res.drawable.compose_multiplatform), contentDescription = null, Modifier.size(50.dp).align(Alignment.CenterVertically))
            Column(Modifier.fillMaxWidth()) {
                Text("Title", style = MaterialTheme.typography.h1, modifier = Modifier.align(Alignment.Start).width(100.dp))
                Text("Description", style = MaterialTheme.typography.caption, modifier = Modifier.align(Alignment.Start).width(100.dp))
                Text("View more", style = MaterialTheme.typography.caption, modifier = Modifier.align(Alignment.End))
            }
        }
    }
}