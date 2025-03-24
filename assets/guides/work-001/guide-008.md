**Ejercicio 8 (Botones con Efectos en Jetpack Compose)**:

---

## 🔹 **Ejemplo Básico: Botón con Ripple Effect y Esquinas Redondeadas**
Este ejemplo muestra un botón con un texto, esquinas redondeadas y el efecto ripple predeterminado.

### 📝 **Código**
```kotlin
@Composable
fun SimpleRoundedButton() {
    Button(
        onClick = { /* Acción al hacer clic */ },
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp)), // Esquinas redondeadas
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.White
        )
    ) {
        Text(text = "Presionar", fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSimpleRoundedButton() {
    SimpleRoundedButton()
}
```

### 🎯 **Explicación**
- `Button(onClick = { ... })` → Define un botón con acción al hacer clic.
- `Modifier.clip(RoundedCornerShape(12.dp))` → Aplica esquinas redondeadas.
- `ButtonDefaults.buttonColors()` → Personaliza colores de fondo y texto.
- `Text(text = "Presionar")` → Muestra el texto dentro del botón.

---

## 🔥 **Ejemplo Complejo: Botón con Ícono, Animación y Personalización de Ripple**
Este ejemplo agrega:
✅ Un **ícono dentro del botón**  
✅ **Cambio de color al presionar**  
✅ **Efecto ripple personalizado**  
✅ **Animación de escala en la pulsación**  

### 📝 **Código**
```kotlin
@Composable
fun AnimatedIconButton() {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f,
        animationSpec = tween(durationMillis = 200)
    )

    Button(
        onClick = { isPressed = !isPressed },
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(50)) // Hace que el botón sea ovalado
            .scale(scale), // Aplica animación de escala
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isPressed) Color.Green else Color.Red,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(defaultElevation = 8.dp), // Elevación del botón
        interactionSource = remember { MutableInteractionSource() }.also { interactionSource ->
            LaunchedEffect(interactionSource) {
                interactionSource.interactions.collect { interaction ->
                    if (interaction is PressInteraction.Press) {
                        isPressed = true
                    } else if (interaction is PressInteraction.Release) {
                        isPressed = false
                    }
                }
            }
        },
        contentPadding = PaddingValues(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ThumbUp,
            contentDescription = "Like",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = if (isPressed) "Liked" else "Like", fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAnimatedIconButton() {
    AnimatedIconButton()
}
```

### 🎯 **Explicación**
- `var isPressed by remember { mutableStateOf(false) }` → Estado para saber si el botón está presionado.
- `animateFloatAsState(...)` → Anima la escala del botón para dar un efecto de presión.
- `Modifier.scale(scale)` → Aplica la animación de escala.
- `ButtonDefaults.buttonColors(...)` → Cambia el color del botón dinámicamente.
- `Icon(imageVector = Icons.Default.ThumbUp, ...)` → Muestra un icono dentro del botón.
- `interactionSource` → Detecta interacciones para cambiar el color del botón.

---

### ✅ **Diferencias Clave entre Ambos Ejemplos**
| Característica           | Básico 🟢 | Complejo 🔥 |
|-------------------------|----------|------------|
| **Botón redondeado**    | ✅        | ✅          |
| **Cambio de color**     | ❌        | ✅          |
| **Ícono dentro**        | ❌        | ✅          |
| **Animación de escala** | ❌        | ✅          |
| **Ripple personalizado**| ❌        | ✅          |

---

Estos ejemplos te dan una base para hacer botones más dinámicos en Jetpack Compose. 🚀  
Si quieres más variantes, dime y lo ampliamos. 😃