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
- **S1_HelloWorldSolution**: Solución al primer contacto.
- **L3_LifecycleTheory**: `@BeforeEach`, `@BeforeAll` y aislamiento.
- **L4_LifecycleExercise**: Práctica del ciclo de vida con `OwnerService`.
- **S2_LifecycleSolution**: Solución al sistema de ciclo de vida.

### 🧪 Sección 2: Aserciones y Control de Flujo (Basics)
- **L1_AssertionsTheory**: Repaso completo de aserciones.
- **E1_AssertionsExercise**: Validando el `OwnerService` y `Pet`.
- **S1_AssertionsSolution**: Solución a las aserciones básicas.
- **E2_GroupedAssertionsExercise**: Uso de `assertAll`.
- **S2_GroupedAssertionsSolution**: Solución a validación masiva.
- **E3_ExceptionsExercise**: Captura de errores con `assertThrows`.
- **S3_ExceptionsSolution**: Solución a aserción de fallos.
- **E4_TimeoutsExercise**: Control de rendimiento básico.
- **S4_TimeoutsSolution**: Solución a los tiempos de espera.
- **E5_AssumptionsExercise**: Saltando tests según el entorno.
- **S5_AssumptionsSolution**: Solución a suposiciones de variables.
- **E6_AnnotationsExercise**: Uso de `@Disabled` y etiquetas.
- **S6_AnnotationsSolution**: Solución a etiquetas y comentarios.

### 🏗️ Sección 3: Dominando JUnit 5 (Advanced)
- **L1_AdvancedTheory**: Técnicas avanzadas de estructura.
- **E1_TagAndNestedExercise**: Desafío de orden y etiquetas.
- **S1_TagAndNestedSolution**: Solución a la organización.
- **E2_TestInterfaceExercise**: Interfaces de test para reutilización.
- **S2_TestInterfaceSolution**: Solución a la abstracción.
- **E3_RepeatedAndDIExercise**: Inyección de dependencias en JUnit.
- **S3_RepeatedAndDISolution**: Solución a Repetidos y DI.
- **E4_ParameterizedExercise**: Desafío de Parametrizados (Value/CSV/Method).
- **S4_ParameterizedSolution**: Solución al poder de los datos.

### ⚙️ Sección 4: Ejecución de Tests con Maven
- **L1_ExecutionTheory**: Configuración de Surefire y Failsafe.
- **L2_SpecialtyIntegrationIT**: Ejemplo de Test de Integración real.
- **E1_MavenExecutionExercise**: Filtrado de tags y generación de reportes.
- **S1_MavenExecutionSolution**: Solución al ciclo de vida de Maven.

---

## 🎭 Desglose de Contenidos (Mockito)

### 🃏 Sección 1: Introducción a Mockito
- **L1_IntroTheory**: Conceptos base de Mocking.
- **L2_AnnotationTheory**: `@Mock` y `@InjectMocks` profesional.
- **L3_VerificationTheory**: Uso de `verify()` y Matchers.
- **E1_ManualMockingExercise**: Practica con `mock()` manual.
- **S1_ManualMockingSolution**: Solución al mocking inline.
- **E2_AnnotationMockingExercise**: Uso de anotaciones intensivo.
- **S2_AnnotationMockingSolution**: Solución al setup profesional.
- **E3_VerificationExercise**: Asegura las interacciones y el número de llamadas.
- **S3_VerificationSolution**: Solución a la verificación de flujo.

### 🎩 Sección 2: Advanced Mockito
- **L1_ExceptionsTheory**: Forzando errores controlados (`doThrow`).
- **E1_ExceptionMockingExercise**: Desafío de errores forzados.
- **S1_ExceptionMockingSolution**: Solución a fallos de persistencia.
- **L2_ArgumentCaptureTheory**: Captura de objetos complejos con `@Captor`.
- **E2_ArgumentCaptureExercise**: Desafío de validación de argumentos.
- **S2_ArgumentCaptureSolution**: Solución a la captura de datos.
- **L3_VerificationAdvancedTheory**: Orden cronológico (`InOrder`).
- **E3_VerificationAdvancedExercise**: Garantía de flujo y no-interacciones.
- **S3_VerificationAdvancedSolution**: Solución al control total de flujo.
- **L4_SyntaxStruggleTheory**: El duelo final: `when` vs `doReturn`.
- **E4_SyntaxStruggleExercise**: Evita los efectos secundarios en Spies.
- **S4_SyntaxStruggleSolution**: Solución a la sintaxis crítica.
- **L5_PartialMockTheory**: Spies y Mocks Parciales de métodos locales.
- **E5_PartialMockExercise**: Validación parcial en `OwnerService`.
- **S5_PartialMockSolution**: Solución al Partial Mocking.
- **E6_SpyMockingExercise**: Desafío final de espionaje integral.
- **S6_SpyMockingSolution**: Solución de cierre de Mockito.

---

## 🌱 Desglose de Contenidos (Spring Testing)

### 🌳 Sección 1: Spring Framework Context
Carga y gestión de dependencias en el contenedor de Spring.
- **L1_SpringContextTheory**: Inyección de Beans reales (`@ContextConfiguration`).
- **L2_PrimaryQualifierTheory**: Diferenciación de Beans (`@Primary`, `@Qualifier`).
- **L3_InnerClassConfigTheory**: Mocks en clases de configuración internas.
- **L4_ProfilesTheory**: Activando entornos con `@ActiveProfiles`.
- **L5_TestPropertiesTheory**: Inyección de propiedades de test.
- **E1_HearingExercise**: Desafío de configuración básica.
- **S1_HearingSolution**: Solución al desafío.
- **E2_ProfileExercise**: Desafío de perfiles Yanny/Laurel.
- **S2_ProfileSolution**: Solución al desafío.
- **L6_MockitoExtensionTheory**: Mockito Puro vs Contexto Spring.
- **E3_CustomExtensionExercise**: Práctica: Crea tu propia extensión Maven.
- **S3_CustomExtensionSolution**: Solución a la extensión.

### 🌐 Sección 2: Spring MVC Test (MockMVC)
Pruebas de controladores web sin levantar el servidor.
- **L1_MockMVCStandaloneTheory**: Setup ligero manual.
- **L2_MockMVCWebContextTheory**: Slice Testing con `@WebMvcTest`.
- **L3_FormParametersTheory**: Envío de datos de formulario y `@MockBean`.
- **L4_ValidationErrorsTheory**: Validación de errores y redirecciones.
- **E1_StandaloneIndexExercise**: Práctica de setup manual en el índice.
- **S1_StandaloneIndexSolution**: Solución al setup.
- **E2_FormValidationExercise**: Práctica de validación masiva.
- **S2_FormValidationSolution**: Solución a la validación.

### 🔌 Sección 3: Spring Boot Context
Tests de integración total con la magia de Boot.
- **L1_SpringBootTestTheory**: Levantando TODO el contexto con `@SpringBootTest`.
- **E1_BootIntegrationExercise**: Práctica de servicios reales.
- **S1_BootIntegrationSolution**: Solución al test de integración.

### 📡 Sección 4: REST Controller Tests
Validación de APIs JSON y clientes HTTP.
- **L1_JsonPathTheory**: Navegando por el JSON con selecciones dinámicas.
- **E1_VetRestExercise**: Práctica de validación REST.
- **S1_VetRestSolution**: Solución al API REST.
- **L2_TestRestTemplateTheory**: Peticiones HTTP reales al servidor en puerto aleatorio.

### ☁️ Sección 5: Testing con Wiremock
Simulación de APIs externas de terceros.
- **L1_WiremockTheory**: Setup básico de servidor Mock HTTP.
- **L2_WiremockRecordingTheory**: Uso pro de `@WireMockTest`.
- **E1_WiremockExercise**: Práctica de simulación de errores externos.
- **S1_WiremockSolution**: Solución al error simulado.

### 🛠️ Sección 6: Configuration & Properties
Control de infraestructuras y configuración.
- **L1_ValueAnnotationTheory**: Inyección de propiedades del sistema.
- **L2_YamlPropertyTheory**: Lectura avanzada de YAML con **Custom Factory**.
- **E1_PropertiesExercise**: Desafío de inyección de propiedades.
- **S1_PropertiesSolution**: Solución a la inyección.

### 💾 Sección 7: Data & Repositories (JPA/H2)
Persistencia de datos y simulación de BBDD.
- **L1_DataJpaTestTheory**: Slice Testing de Repositorios con `@DataJpaTest` y H2.
- **L2_MockBeanRepositoryTheory**: Testing de Servicios simulando la BBDD con `@MockBean`.
- **E1_DataJpaExercise**: Práctica: Guardar y Buscar por Apellido.
- **S1_DataJpaSolution**: Solución al desafío de persistencia.

### 🚀 Sección 8: Spring Boot Test Features
Trucos avanzados de la magia de Boot.
- **L1_WebEnvironmentTheory**: Entornos Web: `MOCK` vs `RANDOM_PORT`.
- **L2_TestConfigurationTheory**: Sobrescribiendo Beans en ejecución con `@TestConfiguration`.
- **L3_LocalServerPortTheory**: Recuperación del puerto dinámico real.

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


