
## 🟢 **Ejemplo Básico**  
🔹 **Objetivo:** Crear un `Box` con un color de fondo, bordes redondeados y un poco de elevación.  
📖 **Clases clave:**  
- `Box { ... }` → Contenedor  
- `Modifier.background(color)` → Fondo  
- `Modifier.border(width, color, shape)` → Bordes  
- `Modifier.padding(value)` → Espaciado interno  
- `Modifier.shadow(elevation)` → Sombra  

### ✨ **Código**
```kotlin
@Composable
fun BasicStyledBox() {
    Box(
        modifier = Modifier
            .size(150.dp) // Tamaño del Box
            .background(Color.LightGray, shape = RoundedCornerShape(16.dp)) // Fondo y esquinas redondeadas
            .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(16.dp)) // Borde
            .padding(16.dp) // Espaciado interno
            .shadow(8.dp, shape = RoundedCornerShape(16.dp)) // Sombra
    ) {
        Text(
            text = "Caja Simple",
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Center),
            color = Color.Black
        )
    }
}
```

🔹 **Explicación:**  
✅ `background(Color.LightGray, shape = RoundedCornerShape(16.dp))` → Fondo gris con bordes redondeados.  
✅ `border(2.dp, Color.DarkGray, RoundedCornerShape(16.dp))` → Borde oscuro de 2dp.  
✅ `padding(16.dp)` → Margen interno para separar el texto.  
✅ `shadow(8.dp, RoundedCornerShape(16.dp))` → Agrega elevación para efecto 3D.  

---

## 🔴 **Ejemplo Complejo**  
🔹 **Objetivo:** Crear un `Box` con un `Column` dentro, incluir una imagen redonda, un texto estilizado y un gradiente de fondo.  
📖 **Clases clave:**  
- `Box { ... }` → Contenedor  
- `Brush.linearGradient(...)` → Gradiente de color  
- `Modifier.clip(CircleShape)` → Forma redonda  
- `Modifier.padding(value)` → Margen interno  

### ✨ **Código**
```kotlin
@Composable
fun ComplexStyledBox() {
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
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape) // Imagen circular
                    .border(4.dp, Color.White, CircleShape) // Borde blanco
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Hola, Compose!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
```

🔹 **Explicación:**  
✅ `background(brush = Brush.linearGradient(...))` → Fondo con gradiente de colores.  
✅ `clip(CircleShape)` → Imagen con forma circular.  
✅ `border(4.dp, Color.White, CircleShape)` → Borde blanco alrededor de la imagen.  
✅ `Column { ... }` → Acomoda elementos verticalmente dentro del `Box`.  
✅ `align(Alignment.Center)` → Centra el contenido dentro del `Box`.  

---

## 🎯 **Comparación**
| Característica         | Ejemplo Básico | Ejemplo Complejo |
|----------------------|--------------|----------------|
| **Color de fondo**  | Fijo (LightGray) | Gradiente (Azul-Cyan) |
| **Bordes**         | Borde simple | Imagen con borde circular |
| **Sombra**         | Sí | No |
| **Contenido**       | Solo `Text` | `Image` + `Text` en `Column` |

---

¿Qué te parece? ¿Quieres que agregue más detalles o variaciones? 😃