---
marp: true
theme: default
paginate: true
backgroundColor: #ffffff
color: #333333
header: "🎓 Master en Testing con Spring Boot (Junior Edition)"
footer: "Hecho por Antigravity (Powered by Google Deepmind)"
---

# 🎓 Master en Testing con Spring Boot
## De Beginner a Guru (Junior Edition)

**JUnit 5, Maven y Mockito.**

---

# 🚀 ¿Por qué testeamos?

- **Confianza**: Saber que el código funciona antes de que el usuario lo vea.
- **Resilioencia**: Evitar regresiones al cambiar el código.
- **Documentación**: El mejor manual de uso son los tests.
- **Diseño**: Si es difícil de testear, el código está mal diseñado.

---

# 🏗️ Bloque 1: El Motor de JUnit 5

### El Ciclo de Vida (Lifecycle)
1. **@BeforeEach**: Prepárate para cada test (ej. limpiar lista).
2. **@AfterEach**: Limpia el entorno tras cada test.
3. **@BeforeAll / @AfterAll**: Una sola vez (ej. conectar a una DB real en IT).

**Recuerda**: Los métodos de test NO deben depender unos de otros.

---

# 🧪 Bloque 2: Aserciones y Control

- **Standard**: `assertEquals(esperado, real)`.
- **Grouped (`assertAll`)**: "Prueba masiva". No se detiene en el primer fallo.
- **Exceptions (`assertThrows`)**: Asegúrate de que el sistema falla cuando debe (ej. Nombres vacíos).
- **Timeouts**: Garantiza que tu lógica no sea lenta.

---

# ⚙️ Condicionales y Suposiciones

- **Assumptions (`assumeTrue`)**: "Si estoy en Windows, corre este test; si no, sáltalo".
- **Condicionales**: `@EnabledOnOs`, `@EnabledOnJre`, `@EnabledIfSystemProperty`.

Usa esto para optimizar la batería de tests según el entorno.

---

# 🏗️ Bloque 3: Dominando JUnit 5 (Advanced)

### Estructura y Tags
- **@Nested**: Agrupa tests relacionados (ej. "Tests de Búsqueda").
- **@Tag**: "Añade etiquetas". Filtra en Maven con `-Dgroups="smoke"`.

---

# 📊 Tests Parametrizados

Escribe un test, ejecútalo 100 veces con datos distintos.
- **@ValueSource**: Una lista de Strings/Ints.
- **@CsvSource**: Tablas de datos directamente en el código.
- **@MethodSource**: El poder total: una lista de argumentos generada programáticamente.

---

# ⚙️ Bloque 4: Maven & El Ciclo de Vida

### Unit vs Integration
- **Unit Tests (`*Test.java`)**: Rápidos, asilados, corren con **Maven Surefire**.
- **IT Tests (`*IT.java`)**: Concurren con la infraestructura, corren con **Maven Failsafe**.

**Comando Rey**: `mvn verify` (Corre unitarios e integración).

---

# 🃏 Bloque 5: Introducción a Mockito

### ¿Qué es un Mock?
- Una "caja vacía" que simula ser un objeto real.
- **@Mock**: Define el simulacro.
- **@InjectMocks**: Inyecta los simulacros automáticamente.
- **@ExtendWith(MockitoExtension.class)**: Activa Mockito en JUnit.

---

# 🎩 Bloque 6: Mockito Avanzado

### Técnicas Ninja:
1. **doThrow()**: Simula fallos en métodos `void`.
2. **ArgumentCaptor**: "Atrapa" el objeto enviado al mock para validarlo.
3. **InOrder**: Asegúrate de que las llamadas ocurren en el orden exacto.

---

# ⚔️ El Duelo Final: `when` vs `doReturn`

**Pitfall de Junior:**
- `when(spy.metodo()).thenReturn("X")` -> ¡Llamas al método REAL antes de atraparlo!
- `doReturn("X").when(spy).metodo()` -> ¡Intercepta sin ejecutar el código real!

**Consejo**: Usa siempre `doReturn` si trabajas con Spies.

---

# 🕵️ @Spy: El Mock Parcial

- **@Mock**: Devuelve `null`.
- **@Spy**: Devuelve el resultado REAL (a menos que lo "pises").
- Úsalo cuando necesites probar una clase donde un método público llama a otro método público de la misma clase.

---

# 🚀 ¡A Volar!

Has pasado de no saber nada a dominar:
- La base de JUnit 5.
- La ejecución profesional con Maven.
- La simulación maestra con Mockito.

**Hecho con ❤️ por Antigravity (Powered by Google Deepmind).**
