package com.abexa.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.abexa.kmp.windows.simpleItemList
import com.abexa.kmp.windows.simpleProportionalColumn

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "kmpdesktop",
        resizable = false
    ) {
        simpleItemList()
    }
}