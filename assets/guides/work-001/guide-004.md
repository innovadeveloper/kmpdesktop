## 🟢 **Ejemplo Básico: Card con Checkbox y RadioButton**  
Un diseño simple con una `Card` que contiene un `Checkbox`, un `RadioButton`, y un `Text`.  

### 📌 **Características**  
✅ `Card` con borde y elevación.  
✅ `Row` para organizar los elementos.  
✅ `Checkbox` para seleccionar una opción.  
✅ `RadioButton` para marcar una opción única.  

### 📝 **Código**
```kotlin
@Composable
fun SimpleCard() {
    var isChecked by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )

            Text(
                text = "Opción 1",
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            RadioButton(
                selected = selectedOption,
                onClick = { selectedOption = !selectedOption }
            )
        }
    }
}

@Preview
@Composable
fun PreviewSimpleCard() {
    SimpleCard()
}
```
### 🎯 **Explicación**  
1. Se usa `Card` con `elevation` y `border`.  
2. `Row` para alinear `Checkbox`, `Text`, y `RadioButton`.  
3. `Spacer` ayuda a empujar `RadioButton` al final.  
4. Se usa `remember` para manejar el estado de selección.  

---

## 🔴 **Ejemplo Complejo: Lista de Opciones con `LazyColumn` y Badges**  
Un diseño más avanzado que muestra una lista de opciones en tarjetas con `Checkbox` y `Badge` que muestra la cantidad seleccionada.

### 📌 **Características**  
✅ `LazyColumn` para listas grandes.  
✅ `Card` estilizada con `Row` y `Column`.  
✅ `Checkbox` con estado dinámico.  
✅ `Badge` mostrando la cantidad de opciones seleccionadas.  

### 📝 **Código**
```kotlin
@Composable
fun AdvancedCardList() {
    val options = listOf("Java", "Kotlin", "Python", "JavaScript")
    val selectedOptions = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Badge con cantidad de seleccionados
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Lenguajes Seleccionados: ", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            if (selectedOptions.isNotEmpty()) {
                BadgeBox(count = selectedOptions.size)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de opciones
        LazyColumn {
            items(options) { option ->
                SelectableCard(option, selectedOptions)
            }
        }
    }
}

// Componente de Card seleccionable
@Composable
fun SelectableCard(option: String, selectedOptions: MutableList<String>) {
    val isSelected = selectedOptions.contains(option)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(1.dp, if (isSelected) Color.Blue else Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isSelected,
                onCheckedChange = {
                    if (isSelected) selectedOptions.remove(option)
                    else selectedOptions.add(option)
                }
            )

            Text(
                text = option,
                modifier = Modifier.padding(start = 8.dp),
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color.Blue else Color.Black
            )
        }
    }
}

// Componente de Badge
@Composable
fun BadgeBox(count: Int) {
    Box(
        modifier = Modifier
            .background(Color.Red, shape = CircleShape)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(text = count.toString(), color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAdvancedCardList() {
    AdvancedCardList()
}
```
---

### 🎯 **Explicación**  
1. **`LazyColumn`** muestra una lista dinámica de tarjetas.  
2. **`selectedOptions`** almacena las opciones seleccionadas en una lista mutable.  
3. **`SelectableCard`** maneja el estado y cambia el borde y color del texto si está seleccionado.  
4. **`BadgeBox`** muestra la cantidad de opciones seleccionadas.  

---

### 🔥 **Diferencias entre el Básico y el Complejo**  
| 🔹 Característica | 🟢 Básico | 🔴 Complejo |
|------------------|----------|------------|
| `Card` simple | ✅ | ✅ |
| `Checkbox` | ✅ | ✅ |
| `RadioButton` | ✅ | ❌ |
| `LazyColumn` (lista dinámica) | ❌ | ✅ |
| `Badge` con contador | ❌ | ✅ |
| `MutableStateList` para selección múltiple | ❌ | ✅ |
| Cambios de color dinámicos | ❌ | ✅ |

---

Ambos ejemplos muestran el poder de Jetpack Compose para construir UI de forma declarativa. 🚀 ¿Quieres que amplíe algo más? 😃