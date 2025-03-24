- 📌 **Ejemplo básico**: Mostrar una imagen con bordes redondeados.  
- 🚀 **Ejemplo complejo**: Imagen con filtros de color, animaciones y superposición de íconos.  

---

## **📌 Ejemplo Básico: Imagen con Bordes Redondeados**  
🔹 **Objetivo**: Cargar una imagen desde los recursos y darle bordes redondeados.  
🔹 **Clases clave**:  
- `Image()` → Muestra imágenes.  
- `painterResource()` → Carga imágenes desde `res/drawable`.  
- `Modifier.clip()` → Aplica esquinas redondeadas.  

### **Código**:
```kotlin
@Composable
fun BasicImageExample() {
    Image(
        painter = painterResource(id = R.drawable.sample_image), // Imagen desde recursos
        contentDescription = "Imagen redondeada",
        modifier = Modifier
            .size(150.dp) // Tamaño de la imagen
            .clip(RoundedCornerShape(20.dp)) // Bordes redondeados
            .border(2.dp, Color.Gray, RoundedCornerShape(20.dp)) // Borde gris
    )
}

@Preview
@Composable
fun PreviewBasicImageExample() {
    BasicImageExample()
}
```

### **Explicación**:
1. `painterResource(id = R.drawable.sample_image)` → Carga una imagen desde los recursos.  
2. `Modifier.size(150.dp)` → Define el tamaño de la imagen.  
3. `Modifier.clip(RoundedCornerShape(20.dp))` → Recorta la imagen con esquinas redondeadas.  
4. `Modifier.border(2.dp, Color.Gray, RoundedCornerShape(20.dp))` → Añade un borde gris.  

📌 **Resultado esperado**: Una imagen cuadrada de 150x150 con bordes redondeados y borde gris.

---

## **🚀 Ejemplo Complejo: Imagen con Filtro de Color, Animación y Superposición de Ícono**  
🔹 **Objetivo**:  
- Mostrar una imagen con un efecto de tinte (filtro de color).  
- Agregar un ícono superpuesto en la esquina.  
- Aplicar animación al presionar.  

🔹 **Clases clave**:  
- `ColorFilter.tint()` → Aplica un filtro de color a la imagen.  
- `Box()` → Contenedor que permite superponer elementos.  
- `AnimatedVisibility()` → Animación al presionar.  

### **Código**:
```kotlin
@Composable
fun AdvancedImageExample() {
    var isClicked by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.BottomEnd, // Alinea el ícono en la esquina inferior derecha
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(30.dp)) // Bordes redondeados
            .background(Color.LightGray)
            .clickable { isClicked = !isClicked } // Cambia el estado al hacer clic
    ) {
        Image(
            painter = painterResource(id = R.drawable.sample_image),
            contentDescription = "Imagen con filtro",
            colorFilter = if (isClicked) ColorFilter.tint(Color.Blue.copy(alpha = 0.5f)) else null, // Aplica tinte azul al presionar
            modifier = Modifier.matchParentSize() // Ajusta tamaño al del Box
        )

        // Animación del ícono al presionar
        AnimatedVisibility(visible = isClicked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Icono de check",
                tint = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp)
                    .background(Color.Green, CircleShape)
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewAdvancedImageExample() {
    AdvancedImageExample()
}
```

### **Explicación**:
1. **Imagen con tinte azul al presionar**:  
   - `colorFilter = if (isClicked) ColorFilter.tint(Color.Blue.copy(alpha = 0.5f)) else null`  
   - Si se presiona, aplica un filtro azul con 50% de transparencia.  

2. **Superposición de ícono animado**:  
   - `AnimatedVisibility(visible = isClicked) { Icon(...) }`  
   - Muestra un `Check` blanco en fondo verde cuando se presiona.  

3. **Efecto de clic en `Box()`**:  
   - `Modifier.clickable { isClicked = !isClicked }`  
   - Cambia el estado para alternar el filtro y la visibilidad del ícono.  

📌 **Resultado esperado**:  
- Imagen de 200x200 con bordes redondeados.  
- Al tocar, la imagen se vuelve azulada y aparece un ícono de ✔️ en la esquina.  
- Al tocar nuevamente, el efecto desaparece.  

---

### 📢 **Conclusión**:
✅ **Ejemplo básico** → Aprende a mostrar imágenes con bordes redondeados.  
✅ **Ejemplo complejo** → Agrega tintes, íconos superpuestos y animaciones interactivas.  

¿Te gustaría otro nivel de complejidad, como cargar imágenes desde URL con `Coil`? 🚀