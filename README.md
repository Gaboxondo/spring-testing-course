# 🎓 Curso Maestro: Testing con Spring Boot (Junior Edition)

¡Bienvenido al repositorio oficial del curso **Spring Boot Testing: De Beginner a Guru (Adaptado)**! 🚀

Este proyecto ha sido diseñado para guiar a desarrolladores Junior a través del fascinante mundo del testing automatizado manejando un dominio real de una clínica veterinaria.

---

## 🗺️ Mapa de Ruta del Curso

Cada sección contiene tres pilares fundamentales:
*   **📖 Teoría (`theory/`)**: Ejemplos numerados para entender el concepto.
*   **🧩 Ejercicios (`exercises/`)**: Desafíos con `TODO` para completar.
*   **✅ Soluciones (`solutions/`)**: El código final esperado.

**Sigue el orden de los archivos `L1`, `L2`, `L3`... para no perderte.**

---

## 📦 Desglose de Contenidos (JUnit 5 Core)

### 🏗️ Sección 1: El Motor de JUnit 5
Fundamentos y ciclo de vida de los tests.
- **L1_HelloWorld**: Tu primer test y aserción básica.
- **L2_HelloWorldSolution**: Solución al primer contacto.
- **L3_LifecycleTheory**: `@BeforeEach`, `@BeforeAll` y el aislamiento de tests.
- **L4_LifecycleExercise**: Práctica del ciclo de vida con `OwnerService`.
- **L5_LifecycleSolution**: Solución al ciclo de vida.

### 🧪 Sección 2: Aserciones y Control de Flujo (Basics)
Uso intensivo de aserciones sobre lógica de negocio real.
- **L1_AssertionsTheory**: Repaso de todas las aserciones de JUnit 5.
- **L2_AssertionsExercise**: Validando el `OwnerService` y `Pet`.
- **L4_GroupedAssertions**: Validación masiva con `assertAll`.
- **L6_Exceptions**: Captura de errores con `assertThrows`.
- **L8_Timeouts**: Control de rendimiento con `assertTimeout`.
- **L10_Assumptions**: Saltando tests según el entorno.
- **L12_Annotations**: Uso de `@Disabled` y `@DisplayName`.

### 🏗️ Sección 3: Dominando JUnit 5 (Advanced)
Técnicas profesionales para tests mantenibles.
*   **Contenidos**: `@Nested` (L2), `@Tag`, `@ParameterizedTest` (L8) e inyección de dependencias (L6).
*   **Ubicación**: `src/test/java/com/testing/course/junit5/section3_advanced`.

### ⚙️ Sección 4: Ejecución de Tests con Maven
Plugins, ciclos de vida y reportes de calidad.
*   **L1_ExecutionTheory**: Maven Surefire vs Failsafe.
*   **L2_SpecialtyIntegrationIT**: Ejemplo de Test de Integración.
*   **L3_MavenExecutionExercise**: Filtrado por etiquetas y reportes HTML.
*   **Ubicación**: `src/test/java/com/testing/course/junit5/section4_execution`.

---

## 🎭 Desglose de Contenidos (Mockito)

### 🃏 Sección 1: Introducción a Mockito
Aislando la lógica de negocio simulando dependencias.
*   **L1_IntroTheory**: Mocks manuales e Inline.
*   **L2_AnnotationTheory**: `@Mock` y `@InjectMocks`.
*   **L3_VerificationTheory**: `verify()` y Matchers (`any`).
*   **L4_ManualMockingExercise**: Practica con `mock()` manual.
*   **L6_AnnotationMockingExercise**: Uso profesional de anotaciones.
*   **L8_VerificationExercise**: Asegura las interacciones y el número de llamadas.
*   **Ubicación**: `src/test/java/com/testing/course/mockito/section1_intro`.

### 🎩 Sección 2: Advanced Mockito
Validaciones profundas y casos complejos.
*   **L1_ExceptionsTheory**: Forzando errores en dependencias (`doThrow`).
*   **L2_ExceptionMockingExercise**: Practica la captura de excepciones.
*   **L4_ArgumentCaptureTheory**: Captura de objetos complejos con `@Captor`.
*   **L5_ArgumentCaptureExercise**: Desafío de validación de argumentos.
*   **L7_VerificationAdvancedTheory**: Orden de ejecución (`InOrder`) e interacciones nulas.
*   **L8_VerificationAdvancedExercise**: Garantía de flujo y validación de interacciones.
*   **L10_SyntaxStruggleTheory**: La batalla final: `when().thenReturn()` vs `doReturn().when()`.
*   **L11_SyntaxStruggleExercise**: Evita los efectos secundarios en Spies.
*   **L13_PartialMockTheory**: Mocks parciales con `@Spy` (Mockear métodos de la misma clase).
*   **L14_PartialMockExercise**: Validación parcial en `OwnerService`.
*   **L16_SpyMockingExercise**: Dominio del espionaje y mocks parciales.
*   **Ubicación**: `src/test/java/com/testing/course/mockito/section2_advanced`.

---

## 🛠️ Comandos Maestros de Maven

| Objetivo | Comando |
| :--- | :--- |
| **🚀 Ejecutar TODO** | `mvn test` |
| **🎯 Ejecutar LECCIÓN** | `mvn test -Dtest=L1_AssertionsTheory` |
| **🏗️ Integration Tests** | `mvn verify` |
| **📊 Reporte HTML** | `mvn surefire-report:report` |

> [!TIP]
> **Ahorro de Tiempo**: Utiliza siempre `-Dtest=NombreDeLaClase` para no ejecutar los tests de las lecciones superadas.

---

**Hecho con ❤️ por Antigravity (Powered by Google Deepmind).**
