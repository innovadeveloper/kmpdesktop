
## ✨ **Ejemplo Básico: Texto con Color y Tamaño Personalizado**
📌 **Objetivo:** Mostrar un texto con un color de fondo, color de fuente y tamaño personalizado.

### 🔹 **Código**
```kotlin
@Composable
fun BasicTextExample() {
    Text(
        text = "¡Hola, Jetpack Compose!",
        color = Color.White, // Color del texto
        fontSize = 20.sp, // Tamaño del texto
        modifier = Modifier
            .background(Color.Blue) // Fondo azul
            .padding(16.dp) // Espaciado interno
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBasicTextExample() {
    BasicTextExample()
}
```

### 📖 **Explicación**
- `Text(text = "...")`: Define un texto simple.
- `color = Color.White`: Cambia el color de la fuente.
- `fontSize = 20.sp`: Ajusta el tamaño del texto.
- `Modifier.background(Color.Blue)`: Cambia el color de fondo.
- `Modifier.padding(16.dp)`: Añade margen interno para separar el texto del borde.

---

## 🎨 **Ejemplo Complejo: Texto con Fuente Personalizada, Estilo y Sombra**
📌 **Objetivo:** Diseñar un texto con una fuente personalizada, diferentes estilos y un efecto de sombra.

### 🔹 **Código**
```kotlin
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpOffset

// Definiendo una fuente personalizada (debes colocar la fuente en res/font/)
val CustomFont = FontFamily(Font(R.font.roboto_bold))

@Composable
fun ComplexTextExample() {
    Text(
        text = "Texto con estilo avanzado en Compose",
        color = Color.White,
        fontSize = 24.sp,
        fontFamily = CustomFont, // Aplicar fuente personalizada
        fontWeight = FontWeight.Bold, // Negrita
        textAlign = TextAlign.Center, // Centrar texto
        textDecoration = TextDecoration.Underline, // Subrayado
        overflow = TextOverflow.Ellipsis, // Manejo de texto largo
        style = TextStyle(
            shadow = Shadow( // Agregar sombra al texto
                color = Color.Black, 
                offset = DpOffset(2.dp, 2.dp)
            )
        ),
        modifier = Modifier
            .background(
                Brush.linearGradient( // Fondo con degradado
                    colors = listOf(Color.Magenta, Color.Blue)
                )
            )
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewComplexTextExample() {
    ComplexTextExample()
}
```

### 📖 **Explicación**
- **Fuente personalizada:** `FontFamily(Font(R.font.roboto_bold))`
- **Estilos de texto:**
  - `fontWeight = FontWeight.Bold` → Negrita.
  - `textAlign = TextAlign.Center` → Centrado.
  - `textDecoration = TextDecoration.Underline` → Subrayado.
- **Manejo de texto largo:** `overflow = TextOverflow.Ellipsis`
- **Efecto de sombra:** `Shadow(color = Color.Black, offset = DpOffset(2.dp, 2.dp))`
- **Fondo con degradado:** `Brush.linearGradient(colors = listOf(Color.Magenta, Color.Blue))`

---

Estos ejemplos te muestran desde lo básico hasta cómo darle un estilo avanzado a un texto en Jetpack Compose. 🚀 ¿Quieres agregar alguna funcionalidad extra, como cambiar dinámicamente el texto? 😊