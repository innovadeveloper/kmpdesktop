Aquí tienes dos ejemplos detallados del **Ejercicio 11: Navegación entre Pantallas en Jetpack Compose**.  

- **Ejemplo Básico**: Navegación sencilla entre dos pantallas con `NavController`.  
- **Ejemplo Complejo**: Navegación con paso de argumentos y manejo del `BackStack`.  

---

## 🟢 **Ejemplo Básico: Navegación entre dos pantallas**
📌 **Objetivo**: Crear una aplicación con dos pantallas (`Inicio` y `Detalles`) y permitir la navegación entre ellas usando `NavController`.  

### **📜 Código Completo**
```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("details") { DetailScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Pantalla de Inicio") }) }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = { navController.navigate("details") }) {
                Text("Ir a Detalles")
            }
        }
    }
}

@Composable
fun DetailScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Pantalla de Detalles") }) }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = { navController.popBackStack() }) {
                Text("Volver")
            }
        }
    }
}
```

### **🔍 Explicación**
1. **`NavController`**: Maneja la navegación entre pantallas.  
2. **`NavHost`**: Define las rutas disponibles (`home`, `details`).  
3. **`composable("home")`** y **`composable("details")`**: Definen las pantallas de la app.  
4. **`navController.navigate("details")`**: Navega a la pantalla de detalles.  
5. **`navController.popBackStack()`**: Regresa a la pantalla anterior.  

✅ **Funcionalidad**: Al presionar el botón en `HomeScreen`, se navega a `DetailScreen`, y desde ahí se puede regresar.

---

## 🔴 **Ejemplo Complejo: Navegación con Argumentos y BackStack**
📌 **Objetivo**:  
- Pasar un argumento (`nombre`) de `HomeScreen` a `DetailScreen`.  
- Mantener el estado de la pantalla anterior cuando se regresa.  
- Manejar la pila de navegación (`BackStack`).  

### **📜 Código Completo**
```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable(
            "details/{nombre}",
            arguments = listOf(navArgument("nombre") { defaultValue = "Usuario" })
        ) { backStackEntry ->
            DetailScreen(
                navController,
                backStackEntry.arguments?.getString("nombre") ?: "Usuario"
            )
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Inicio") }) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Ingresa tu nombre") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (nombre.isNotBlank()) {
                    navController.navigate("details/$nombre")
                }
            }) {
                Text("Ir a Detalles")
            }
        }
    }
}

@Composable
fun DetailScreen(navController: NavController, nombre: String) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Detalles de $nombre") }) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Bienvenido, $nombre", style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Volver")
            }
        }
    }
}
```

### **🔍 Explicación**
1. **`arguments = listOf(navArgument("nombre") { defaultValue = "Usuario" })`**  
   - Define el argumento `nombre`, con un valor por defecto `"Usuario"`.  
2. **`backStackEntry.arguments?.getString("nombre") ?: "Usuario"`**  
   - Recupera el argumento pasado desde `HomeScreen`.  
3. **Formulario (`OutlinedTextField`) en `HomeScreen`**  
   - Permite ingresar un nombre y pasarlo a `DetailScreen`.  
4. **Manejo del BackStack**  
   - `navController.popBackStack()` regresa a `HomeScreen` sin perder el estado del texto ingresado.  

✅ **Funcionalidad**:  
- El usuario ingresa su nombre en `HomeScreen` y presiona el botón.  
- Se navega a `DetailScreen` mostrando el nombre ingresado.  
- Al volver atrás, el campo de texto mantiene su estado.  

---

### 📌 **Diferencias entre el Ejemplo Básico y Complejo**
| Característica  | Ejemplo Básico | Ejemplo Complejo |
|---------------|---------------|---------------|
| **Número de pantallas** | 2 (`home` y `details`) | 2 (`home` y `details/{nombre}`) |
| **Navegación** | Sin argumentos | Con argumentos dinámicos |
| **Manejo de BackStack** | Regresa sin estado | Mantiene el estado del campo de texto |
| **Interactividad** | Solo botones | Formulario con entrada de usuario |

---

Ambos ejemplos muestran la navegación en Jetpack Compose, desde un caso simple hasta uno más avanzado con paso de datos y estado persistente. ¿Quieres que agreguemos algo más, como navegación con animaciones o deep links? 🚀