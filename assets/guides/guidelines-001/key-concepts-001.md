## 🔥 **Kotlin Multiplatform (KMP) – Características Clave** 🔥

Kotlin Multiplatform (KMP) es una herramienta poderosa para compartir código entre distintas plataformas como Android, iOS, Desktop, Web y más. Aparte de `expect`/`actual`, KMP ofrece muchas características que facilitan el desarrollo multiplataforma.

---

## 📌 **1️⃣ Jerarquía de fuentes (Source Sets)**
KMP organiza el código en distintos **source sets** para compartir o definir código específico por plataforma:

📂 **Estructura de un proyecto típico:**
```
├── commonMain/      ← Código compartido
│   ├── MyClass.kt  
│   ├── Utils.kt
│
├── androidMain/     ← Código específico de Android  
│   ├── MyClass.kt
│
├── iosMain/         ← Código específico de iOS  
│   ├── MyClass.kt
│
├── desktopMain/     ← Código específico de Desktop  
│   ├── MyClass.kt
│
├── jsMain/          ← Código específico de JavaScript  
│   ├── MyClass.kt
```
- `commonMain` contiene código reutilizable para todas las plataformas.
- Cada `xxxMain` contiene código específico para su plataforma.
- `expect`/`actual` se usa cuando una función/clase depende de una plataforma.

---

## 📌 **2️⃣ Librerías y compatibilidad con plataformas**
KMP permite compartir código para **múltiples targets**, soportando:  
✅ **Android**  
✅ **iOS** (mediante Kotlin/Native)  
✅ **JVM/Desktop** (Kotlin/JVM para apps de escritorio)  
✅ **JavaScript/Browser** (Kotlin/JS para web)  
✅ **WASM** (en desarrollo para WebAssembly)  
✅ **Linux/macOS/Windows** (mediante Kotlin/Native)

Ejemplo de configuración en `build.gradle.kts`:
```kotlin
kotlin {
    jvm()  // Para Android/Desktop
    ios()  // Para iOS
    js(IR) // Para JavaScript
    linuxX64() // Para Linux
    macosX64() // Para macOS
}
```

---

## 📌 **3️⃣ Interoperabilidad con otras plataformas**
KMP permite interactuar con código nativo de cada plataforma:

🔹 **Android:** Llamar código Java/Kotlin normalmente.  
🔹 **iOS:** Interoperar con Swift/Objective-C mediante Kotlin/Native.  
🔹 **JS:** Generar código JavaScript directamente.

Ejemplo de interoperabilidad con iOS (Swift):  
📌 **En `commonMain`**
```kotlin
expect class Platform {
    fun getPlatformName(): String
}
```
📌 **En `iosMain`**
```kotlin
import platform.UIKit.UIDevice

actual class Platform {
    actual fun getPlatformName(): String = UIDevice.currentDevice.systemName()
}
```
📌 **En Swift:**
```swift
let platformName = Platform().getPlatformName()
print(platformName) // "iOS"
```

---

## 📌 **4️⃣ Manejo de concurrencia con `coroutines`**
KMP soporta **Kotlin Coroutines** para manejar operaciones asíncronas en múltiples plataformas.

Ejemplo de `suspend` function en `commonMain`:
```kotlin
suspend fun fetchData(): String {
    return withContext(Dispatchers.IO) {
        "Data loaded"
    }
}
```
En iOS, coroutines deben ser lanzadas en el **Main Thread** para interactuar con UI:
```kotlin
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MyClass {
    private val scope = MainScope()
    
    fun loadData() {
        scope.launch {
            val data = fetchData()
            println(data)
        }
    }
}
```

---

## 📌 **5️⃣ Serialización multiplataforma**
Para trabajar con JSON, se usa `kotlinx.serialization`, compatible con todas las plataformas:

📌 **En `commonMain`**
```kotlin
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class User(val name: String, val age: Int)

fun serializeUser(user: User): String {
    return Json.encodeToString(User.serializer(), user)
}

fun deserializeUser(json: String): User {
    return Json.decodeFromString(User.serializer(), json)
}
```
Este código funciona sin cambios en **Android, iOS, JS y Desktop**.

---

## 📌 **6️⃣ Integración con Jetpack Compose Multiplatform (JCM)**
Con **Compose Multiplatform**, puedes escribir UI en `commonMain` y ejecutarla en Android, Desktop y Web.

Ejemplo de **UI compartida**:  
📌 **En `commonMain`**
```kotlin
@Composable
fun MyScreen() {
    Column {
        Text("Hola desde Compose Multiplatform")
        Button(onClick = { /* Acción */ }) {
            Text("Click me")
        }
    }
}
```
📌 **En `androidMain`**
```kotlin
setContent {
    MyScreen()
}
```
📌 **En `desktopMain`**
```kotlin
Window(onCloseRequest = ::exitApplication) {
    MyScreen()
}
```

---

## 📌 **7️⃣ Uso de KMP en librerías**
Muchas librerías están preparadas para KMP, por ejemplo:
- `kotlinx.coroutines` → Soporte para asincronía.
- `kotlinx.serialization` → JSON multiplataforma.
- `ktor` → Cliente HTTP compatible con todas las plataformas.
- `sqldelight` → Base de datos multiplataforma con SQLite.
- `multiplatform-settings` → Almacenamiento de preferencias.

Ejemplo de uso de **Ktor** en `commonMain`:
```kotlin
val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

suspend fun fetchApiData(): String {
    return client.get("https://api.example.com/data")
}
```

---

## 🚀 **Conclusión**
Kotlin Multiplatform es una herramienta potente que permite compartir código entre múltiples plataformas, reduciendo la duplicación y manteniendo código específico cuando es necesario.

🔹 **`expect` y `actual` permiten manejar diferencias entre plataformas.**  
🔹 **Jerarquía de fuentes (`commonMain`, `androidMain`, etc.) organiza el código.**  
🔹 **Interoperabilidad con Swift, Java, JS y otras plataformas.**  
🔹 **Soporte para concurrencia con Coroutines y Serialización con kotlinx.**  
🔹 **Jetpack Compose Multiplatform permite compartir UI entre plataformas.**

**📢 ¿Quieres enfocarte en algún aspecto en particular de KMP?** 🚀