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
- **L1_HelloWorldExercise**: Tu primer test y aserción básica.
- **L2_HelloWorldSolution**: Solución al primer contacto.
- **L3_LifecycleTheory**: `@BeforeEach`, `@BeforeAll` y aislamiento.
- **L4_LifecycleExercise**: Práctica del ciclo de vida con `OwnerService`.
- **L5_LifecycleSolution**: Solución al sistema de ciclo de vida.

### 🧪 Sección 2: Aserciones y Control de Flujo (Basics)
- **L1_AssertionsTheory**: Repaso completo de aserciones.
- **L2_AssertionsExercise**: Validando el `OwnerService` y `Pet`.
- **L3_AssertionsSolution**: Solución a las aserciones básicas.
- **L4_GroupedAssertionsExercise**: Uso de `assertAll`.
- **L5_GroupedAssertionsSolution**: Solución a validación masiva.
- **L6_ExceptionsExercise**: Captura de errores con `assertThrows`.
- **L7_ExceptionsSolution**: Solución a aserción de fallos.
- **L8_TimeoutsExercise**: Control de rendimiento básico.
- **L9_TimeoutsSolution**: Solución a los tiempos de espera.
- **L10_AssumptionsExercise**: Saltando tests según el entorno.
- **L11_AssumptionsSolution**: Solución a suposiciones de variables.
- **L12_AnnotationsExercise**: Uso de `@Disabled` y etiquetas.
- **L13_AnnotationsSolution**: Solución a etiquetas y comentarios.

### 🏗️ Sección 3: Dominando JUnit 5 (Advanced)
- **L1_AdvancedTheory**: Técnicas avanzadas de estructura.
- **L2_TagAndNestedExercise**: Desafío de orden y etiquetas.
- **L3_TagAndNestedSolution**: Solución a la organización.
- **L4_TestInterfaceExercise**: Interfaces de test para reutilización.
- **L5_TestInterfaceSolution**: Solución a la abstracción.
- **L6_RepeatedAndDIExercise**: Inyección de dependencias en JUnit.
- **L7_RepeatedAndDISolution**: Solución a Repetidos y DI.
- **L8_ParameterizedExercise**: Desafío de Parametrizados (Value/CSV/Method).
- **L9_ParameterizedSolution**: Solución al poder de los datos.

### ⚙️ Sección 4: Ejecución de Tests con Maven
- **L1_ExecutionTheory**: Configuración de Surefire y Failsafe.
- **L2_SpecialtyIntegrationIT**: Ejemplo de Test de Integración real.
- **L3_MavenExecutionExercise**: Filtrado de tags y generación de reportes.
- **L4_MavenExecutionSolution**: Solución al ciclo de vida de Maven.

---

## 🎭 Desglose de Contenidos (Mockito)

### 🃏 Sección 1: Introducción a Mockito
- **L1_IntroTheory**: Conceptos base de Mocking.
- **L2_AnnotationTheory**: `@Mock` y `@InjectMocks` profesional.
- **L3_VerificationTheory**: Uso de `verify()` y Matchers.
- **L4_ManualMockingExercise**: Practica con `mock()` manual.
- **L5_ManualMockingSolution**: Solución al mocking inline.
- **L6_AnnotationMockingExercise**: Uso de anotaciones intensivo.
- **L7_AnnotationMockingSolution**: Solución al setup profesional.
- **L8_VerificationExercise**: Asegura las interacciones y el número de llamadas.
- **L9_VerificationSolution**: Solución a la verificación de flujo.

### 🎩 Sección 2: Advanced Mockito
- **L1_ExceptionsTheory**: Forzando errores controlados (`doThrow`).
- **L2_ExceptionMockingExercise**: Desafío de errores forzados.
- **L3_ExceptionMockingSolution**: Solución a fallos de persistencia.
- **L4_ArgumentCaptureTheory**: Captura de objetos complejos con `@Captor`.
- **L5_ArgumentCaptureExercise**: Desafío de validación de argumentos.
- **L6_ArgumentCaptureSolution**: Solución a la captura de datos.
- **L7_VerificationAdvancedTheory**: Orden cronológico (`InOrder`).
- **L8_VerificationAdvancedExercise**: Garantía de flujo y no-interacciones.
- **L9_VerificationAdvancedSolution**: Solución al control total de flujo.
- **L10_SyntaxStruggleTheory**: El duelo final: `when` vs `doReturn`.
- **L11_SyntaxStruggleExercise**: Evita los efectos secundarios en Spies.
- **L12_SyntaxStruggleSolution**: Solución a la sintaxis crítica.
- **L13_PartialMockTheory**: Spies y Mocks Parciales de métodos locales.
- **L14_PartialMockExercise**: Validación parcial en `OwnerService`.
- **L15_PartialMockSolution**: Solución al Partial Mocking.
- **L16_SpyMockingExercise**: Desafío final de espionaje integral.
- **L17_SpyMockingSolution**: Solución de cierre de Mockito.

---

## 🌱 Desglose de Contenidos (Spring Testing)

### 🌳 Sección 1: Spring Framework Context
Carga y gestión de dependencias en el contenedor de Spring.
- **L1_SpringContextTheory**: Inyección de Beans reales (`@ContextConfiguration`).
- **L2_PrimaryQualifierTheory**: Diferenciación de Beans (`@Primary`, `@Qualifier`).
- **L3_InnerClassConfigTheory**: Mocks en clases de configuración internas.
- **L4_ProfilesTheory**: Activando entornos con `@ActiveProfiles`.
- **L5_TestPropertiesTheory**: Inyección de propiedades de test.
- **L6_HearingExercise**: Desafío de configuración básica.
- **L7_HearingSolution**: Solución al desafío.
- **L8_ProfileExercise**: Desafío de perfiles Yanny/Laurel.
- **L9_ProfileSolution**: Solución al desafío.

### 🌐 Sección 2: Spring MVC Test (MockMVC)
Pruebas de controladores web sin levantar el servidor.
- **L1_MockMVCStandaloneTheory**: Setup ligero manual.
- **L2_MockMVCWebContextTheory**: Slice Testing con `@WebMvcTest`.
- **L3_FormParametersTheory**: Envío de datos de formulario y `@MockBean`.
- **L4_ValidationErrorsTheory**: Validación de errores y redirecciones.
- **L5_StandaloneIndexExercise**: Práctica de setup manual en el índice.
- **L6_StandaloneIndexSolution**: Solución al setup.
- **L7_FormValidationExercise**: Práctica de validación masiva.
- **L8_FormValidationSolution**: Solución a la validación.

### 🔌 Sección 3: Spring Boot Context
Tests de integración total con la magia de Boot.
- **L1_SpringBootTestTheory**: Levantando TODO el contexto con `@SpringBootTest`.
- **L2_BootIntegrationExercise**: Práctica de servicios reales.
- **L3_BootIntegrationSolution**: Solución al test de integración.

### 📡 Sección 4: REST Controller Tests
Validación de APIs JSON y clientes HTTP.
- **L1_JsonPathTheory**: Navegando por el JSON con selecciones dinámicas.
- **L2_VetRestExercise**: Práctica de validación REST.
- **L3_VetRestSolution**: Solución al API REST.
- **L6_TestRestTemplateTheory**: Peticiones HTTP reales al servidor en puerto aleatorio.

### ☁️ Sección 5: Testing con Wiremock
Simulación de APIs externas de terceros.
- **L1_WiremockTheory**: Setup básico de servidor Mock HTTP.
- **L2_WiremockRecordingTheory**: Uso pro de `@WireMockTest`.
- **L3_WiremockExercise**: Práctica de simulación de errores externos.
- **L4_WiremockSolution**: Solución al error simulado.

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
