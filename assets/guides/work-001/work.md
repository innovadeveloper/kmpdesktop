## 📌 **Configuración Inicial**
Antes de empezar, asegúrate de agregar las dependencias necesarias en tu `build.gradle` (nivel de módulo):

```kotlin
dependencies {
    implementation("androidx.compose.ui:ui:1.6.0") // UI principal
    implementation("androidx.compose.material:material:1.6.0") // Material Design
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0") // Previsualización en el editor
    implementation("androidx.navigation:navigation-compose:2.7.6") // Navegación
}
```
> **¿Por qué?**  
> - `ui` es la base de Jetpack Compose.  
> - `material` proporciona componentes prediseñados.  
> - `ui-tooling-preview` permite ver cambios en tiempo real.  
> - `navigation-compose` permite navegar entre pantallas.

---

## 🚀 **Ejercicios y Guías**

### 1️⃣ **Contenedores en Jetpack Compose**
📌 **Conceptos:** `Column`, `Row`, `Box`, `ConstraintLayout`  
🔹 **Ejercicio:** Diseña una pantalla con un `Column` (vertical) que tenga un `Row` dentro con 3 elementos.  
📖 **Clases clave:**  
- `Column { ... }` → Contenedor vertical  
- `Row { ... }` → Contenedor horizontal  
- `Box { ... }` → Para superposiciones  
- `ConstraintLayout { ... }` → Diseño flexible con restricciones  

---

### 2️⃣ **Uso de `weight` para Distribución en Layouts**
📌 **Conceptos:** `Modifier.weight()`  
🔹 **Ejercicio:** Crea un layout con un `Column` que tenga un `header (20%)`, `body (60%)` y `footer (20%)`.  
📖 **Clases clave:**  
- `Modifier.weight(fraction)` para repartir espacio proporcionalmente.  

---

### 3️⃣ **Estilizando Contenedores**
📌 **Conceptos:** `Modifier.background()`, `Modifier.padding()`, `Modifier.border()`  
🔹 **Ejercicio:** Diseña un `Box` con bordes redondeados, color de fondo y elevación.  
📖 **Clases clave:**  
- `Modifier.background(color)`  
- `Modifier.border(width, color, shape)`  
- `Modifier.padding(value)`  

---

### 4️⃣ **Widgets Personalizados**
📌 **Conceptos:** `Card`, `LazyColumn`, `Checkbox`, `RadioButton`, `Badge`  
🔹 **Ejercicio:** Crea una `CardView` con una lista de opciones seleccionables (`Checkbox` y `RadioButton`).  
📖 **Clases clave:**  
- `Card { ... }` para crear tarjetas  
- `LazyColumn { ... }` para listas  
- `Checkbox()`, `RadioButton()`  

---

### 5️⃣ **TextViews Personalizados**
📌 **Conceptos:** `Text`, `Color`, `FontFamily`, `TextStyle`  
🔹 **Ejercicio:** Diseña un texto con fuente personalizada, color de fondo y tamaño ajustado.  
📖 **Clases clave:**  
- `Text(text, style = TextStyle(...))`  

---

### 6️⃣ **EditTexts Personalizados**
📌 **Conceptos:** `TextField`, `OutlinedTextField`, `TextStyle`  
🔹 **Ejercicio:** Crea un `OutlinedTextField` con bordes personalizados y un ícono dentro.  
📖 **Clases clave:**  
- `TextField(value, onValueChange, modifier, ...)`  

---

### 7️⃣ **ImageView e Íconos Personalizados**
📌 **Conceptos:** `Image`, `Icon`, `painterResource`, `Modifier.clip()`  
🔹 **Ejercicio:** Muestra una imagen con bordes redondeados y cambia su color de fondo.  
📖 **Clases clave:**  
- `Image(painter = painterResource(id = ...))`  
- `Icon(imageVector = ..., tint = Color.Red)`  

---

### 8️⃣ **Botones con Efectos**
📌 **Conceptos:** `Button`, `IconButton`, `Modifier.clickable()`  
🔹 **Ejercicio:** Diseña un botón redondeado con efecto ripple al presionar.  
📖 **Clases clave:**  
- `Button(onClick = { ... })`  
- `Modifier.clip(RoundedCornerShape(50))`  

---

## 🔥 **Nivel Intermedio**

### 9️⃣ **Dialogs, Snackbars y FloatingActionButton**
📌 **Conceptos:** `AlertDialog`, `Snackbar`, `FloatingActionButton`  
🔹 **Ejercicio:** Muestra un `Dialog` al presionar un `FAB` y muestra un `Snackbar` tras cerrar.  
📖 **Clases clave:**  
- `AlertDialog(...)`  
- `Snackbar { ... }`  
- `FloatingActionButton(onClick = { ... })`  

---

### 🔟 **Temas Claro/Oscuro**
📌 **Conceptos:** `MaterialTheme`, `isSystemInDarkTheme()`  
🔹 **Ejercicio:** Implementa un switch para cambiar entre modo claro y oscuro.  
📖 **Clases clave:**  
- `MaterialTheme(...)`  
- `isSystemInDarkTheme()`  

---

### 1️⃣1️⃣ **Navegación entre Pantallas**
📌 **Conceptos:** `NavController`, `NavHost`, `NavGraph`  
🔹 **Ejercicio:** Crea una app con dos pantallas (`Inicio` y `Detalles`) y navega entre ellas.  
📖 **Clases clave:**  
- `NavController`  
- `NavHost(...)`  
- `composable(route) { ... }`  

---

Con estos ejercicios, aprenderás desde lo básico hasta una app con navegación y theming. ¿Quieres que los desarrolle con código completo? 😃