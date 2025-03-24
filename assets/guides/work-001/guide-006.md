Aquí tienes dos ejemplos detallados del **Ejercicio 6: EditTexts Personalizados en Jetpack Compose**.  

- **Ejemplo básico:** Un `TextField` con un estilo simple.  
- **Ejemplo complejo:** Un `OutlinedTextField` con íconos, validación y personalización avanzada.  

---

## 🟢 **Ejemplo Básico: TextField Simple**  
Este ejemplo muestra un campo de texto simple con un borde estándar y sin funcionalidades adicionales.

### 🔹 **Código**
```kotlin
@Composable
fun BasicTextFieldExample() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Ingrese su nombre") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 18.sp
        )
    )
}
```

### 📌 **Explicación**
- Se usa `TextField` para capturar texto.  
- `remember { mutableStateOf("") }` almacena el estado del texto.  
- `label = { Text("Ingrese su nombre") }` define un texto guía.  
- `textStyle` personaliza el color y tamaño del texto.  
- `modifier.fillMaxWidth()` hace que el campo ocupe todo el ancho disponible.  

---

## 🔴 **Ejemplo Complejo: OutlinedTextField con Íconos, Validación y Estilos Avanzados**  
Este ejemplo agrega:
✔ Un borde resaltado (`OutlinedTextField`).  
✔ Un ícono dentro del campo.  
✔ Validación en tiempo real.  
✔ Un contador de caracteres.  

### 🔹 **Código**
```kotlin
@Composable
fun AdvancedTextFieldExample() {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                isError = it.length > 10 // Máximo 10 caracteres permitidos
            },
            label = { Text("Usuario") },
            placeholder = { Text("Ingrese su usuario") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "User Icon")
            },
            trailingIcon = {
                if (isError) {
                    Icon(imageVector = Icons.Default.Warning, contentDescription = "Error", tint = Color.Red)
                }
            },
            isError = isError,
            textStyle = TextStyle(fontSize = 16.sp),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        if (isError) {
            Text(
                text = "Máximo 10 caracteres permitidos",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }

        Text(
            text = "${text.length}/10",
            fontSize = 12.sp,
            color = if (isError) Color.Red else Color.Gray,
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 4.dp)
        )
    }
}
```

### 📌 **Explicación**
- Se usa `OutlinedTextField` para un diseño más destacado.  
- `leadingIcon` coloca un ícono a la izquierda (ícono de usuario).  
- `trailingIcon` muestra un ícono de advertencia si el usuario excede el límite de caracteres.  
- `isError` cambia el borde del `TextField` a rojo cuando la validación falla.  
- Se muestra un mensaje de error en rojo si el texto excede los 10 caracteres.  
- Un contador indica la cantidad de caracteres ingresados.  

---

## 🔥 **Conclusión**
El **ejemplo básico** es ideal para capturar texto sin restricciones.  
El **ejemplo complejo** ofrece personalización, validación y mejoras en UX.  

👉 ¿Quieres agregar más funciones, como ocultar la contraseña en un campo `password`? 😃