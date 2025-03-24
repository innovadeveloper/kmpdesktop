
---

## 🟢 **Ejemplo Básico**: Header, Body y Footer con `weight`
📌 **Objetivo:** Crear un layout con un `Column`, dividiendo el espacio en:  
- **Header (20%)** con un fondo azul  
- **Body (60%)** con un fondo verde  
- **Footer (20%)** con un fondo rojo  

📖 **Clases clave:**  
- `Column` → Contenedor vertical  
- `Modifier.weight(fracción)` → Controla el tamaño relativo  

### 🔹 Código:
```kotlin
@Composable
fun BasicLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Header", color = Color.White, fontSize = 20.sp)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Body", color = Color.White, fontSize = 20.sp)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Footer", color = Color.White, fontSize = 20.sp)
        }
    }
}
```

### 🖼️ **Resultado:**
Este código genera una pantalla con tres secciones de diferente altura, respetando las proporciones definidas con `weight`.

---

## 🔵 **Ejemplo Complejo**: Layout con Header, Sidebar, Content y Footer
📌 **Objetivo:**  
- **Header (15%)**  
- **Contenido principal dividido en:**  
  - **Sidebar (25%)** a la izquierda  
  - **Content (75%)** al lado derecho  
- **Footer (10%)**  

📖 **Nuevas Clases clave:**  
- `Row` → Contenedor horizontal  
- `weight` aplicado en una `Row` para dividir sidebar y contenido  

### 🔹 Código:
```kotlin
@Composable
fun AdvancedLayout() {
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
```

### 🖼️ **Resultado:**
Este diseño agrega una distribución más compleja con una barra lateral (`Sidebar`) dentro de un `Row`, mostrando cómo `weight` puede aplicarse tanto en `Column` como en `Row`.

---

## 🎯 **Diferencias Clave entre Ambos Ejemplos**
| Característica       | Ejemplo Básico 🟢 | Ejemplo Complejo 🔵 |
|----------------------|----------------|----------------|
| **Estructura** | `Column` simple con 3 secciones | `Column` + `Row` para sidebar y contenido |
| **Elementos** | Header, Body, Footer | Header, Sidebar, Content, Footer |
| **Uso de `weight`** | Solo en `Column` | En `Column` y `Row` |
| **Dificultad** | Fácil 🚀 | Más avanzada 🎯 |

Ambos ejemplos son útiles según la complejidad del layout que necesites. ¿Quieres que le agreguemos más estilos o interactividad? 😃