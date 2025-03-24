Aquí tienes dos ejemplos detallados del ejercicio 9, uno básico y otro más complejo.  

---

## **🟢 Ejemplo Básico: AlertDialog con un Botón**  
Este ejemplo muestra un `AlertDialog` cuando se presiona un botón y se oculta al cerrarlo.  

### **Código:**
```kotlin
@Composable
fun SimpleDialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Mostrar Diálogo")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Título del Diálogo") },
                text = { Text("Este es un diálogo simple con opciones.") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}
```

### **Explicación:**
- Se usa `remember { mutableStateOf(false) }` para controlar si el diálogo está visible o no.
- `AlertDialog` se muestra solo si `showDialog` es `true`.
- Tiene un título, un texto y dos botones (`Aceptar` y `Cancelar`).
- Al presionar cualquier botón, se oculta el diálogo.

---

## **🔴 Ejemplo Complejo: Diálogo con Entrada de Texto, Snackbar y FloatingActionButton**  
Este ejemplo incluye:
✅ Un `FloatingActionButton` para abrir el diálogo.  
✅ Un `AlertDialog` con un `TextField` para ingresar datos.  
✅ Un `Snackbar` que muestra el texto ingresado.  

### **Código:**
```kotlin
@Composable
fun AdvancedDialogExample() {
    var showDialog by remember { mutableStateOf(false) }
    var userInput by remember { mutableStateOf("") }
    var snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Abrir diálogo")
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Presiona el botón flotante para abrir el diálogo")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Introduce tu nombre") },
                text = {
                    Column {
                        Text("Escribe tu nombre abajo:")
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = userInput,
                            onValueChange = { userInput = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog = false
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Hola, $userInput!")
                        }
                    }) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}
```

### **Explicación:**
- `FloatingActionButton` muestra el diálogo cuando se presiona.
- `TextField` dentro del `AlertDialog` permite al usuario ingresar texto.
- `Snackbar` aparece con un saludo cuando el usuario presiona "Aceptar".
- Se usa `Scaffold` para manejar el `FloatingActionButton` y el `SnackbarHost`.

---

Estos ejemplos te enseñan a manejar diálogos simples y avanzados con Jetpack Compose. ¿Te gustaría añadir más interacción o estilos personalizados? 😃