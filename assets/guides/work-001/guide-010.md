Aquí tienes dos ejemplos detallados para el **Ejercicio 10: Temas Claro/Oscuro** en Jetpack Compose.  

---

## 🟢 **Ejemplo Básico**: Cambio Automático según el Sistema  
En este ejemplo, la app detecta automáticamente si el sistema está en modo claro u oscuro y cambia los colores en consecuencia.

### 🔹 **Código**
```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyThemeApp()
        }
    }
}

@Composable
fun MyThemeApp() {
    val isDarkTheme = isSystemInDarkTheme() // Detecta el tema del sistema
    MaterialTheme(
        colors = if (isDarkTheme) darkColors() else lightColors()
    ) {
        MyScreen()
    }
}

@Composable
fun MyScreen() {
    val colors = MaterialTheme.colors

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Modo Actual: ${if (isSystemInDarkTheme()) "Oscuro 🌙" else "Claro ☀️"}",
            color = colors.onBackground,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyThemeApp()
}
```

### 🔹 **Explicación**  
✔️ `isSystemInDarkTheme()` detecta si el sistema está en modo oscuro o claro.  
✔️ `MaterialTheme` cambia dinámicamente los colores según el tema del sistema.  
✔️ `colors.background` y `colors.onBackground` aseguran que los colores cambien de forma automática.  

---

## 🔴 **Ejemplo Complejo**: Cambio Manual con `Switch`  
Este ejemplo permite al usuario cambiar entre tema claro y oscuro usando un `Switch`.

### 🔹 **Código**
```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThemeSwitcherApp()
        }
    }
}

@Composable
fun ThemeSwitcherApp() {
    var isDarkMode by remember { mutableStateOf(false) }

    MaterialTheme(
        colors = if (isDarkMode) darkColors() else lightColors()
    ) {
        ThemeSwitcherScreen(isDarkMode) { isDarkMode = it }
    }
}

@Composable
fun ThemeSwitcherScreen(isDarkMode: Boolean, onThemeChange: (Boolean) -> Unit) {
    val colors = MaterialTheme.colors

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Tema: ${if (isDarkMode) "Oscuro 🌙" else "Claro ☀️"}",
            fontSize = 24.sp,
            color = colors.onBackground
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Switch(
            checked = isDarkMode,
            onCheckedChange = onThemeChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Yellow,
                checkedTrackColor = Color.DarkGray
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewThemeSwitcher() {
    ThemeSwitcherApp()
}
```

### 🔹 **Explicación**  
✔️ Usa `remember { mutableStateOf(false) }` para almacenar el estado del tema.  
✔️ Un `Switch` permite cambiar entre claro y oscuro de forma manual.  
✔️ `onThemeChange` es una función lambda que actualiza el estado.  
✔️ `colors.background` y `colors.onBackground` garantizan un cambio uniforme de colores.  

---

## 🎯 **Diferencias entre Ambos Ejemplos**
| Característica        | Básico                         | Complejo                    |
|----------------------|-----------------------------|----------------------------|
| Cambio de tema      | Automático según el sistema | Manual con un `Switch`    |
| Personalización    | Limitada                      | Más flexible               |
| Estado controlado  | No                           | Sí (`mutableStateOf`)      |

🔹 **¿Cuál elegir?**  
✔️ Si solo quieres que el tema cambie según el sistema → **Ejemplo básico**  
✔️ Si necesitas que el usuario pueda cambiar el tema manualmente → **Ejemplo complejo**  

---

📌 ¿Quieres que agregue persistencia para recordar el tema incluso después de cerrar la app? 😃