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

## 📅 Agenda del Curso (9:30 - 14:30)

Este curso se imparte de forma **remota/telemática**. A continuación, la estimación de tiempos para cubrir todo el temario:

| Bloque | Horario | Contenido Clave | Metodología |
| :--- | :--- | :--- | :--- |
| **1. JUnit 5** | 09:30 - 10:30 | Assertions, Ciclo de vida y Excepciones. | Teoría + Práctica |
| **2. Mockito** | 10:30 - 11:30 | Mocks, Verify, Spy y ArgumentCaptor. | Teoría + Práctica |
| ☕ **Descanso** | 11:30 - 11:50 | Pausa para café. | - |
| **3. Spring Test** | 11:50 - 13:15 | MockMvc, @SpringBootTest y @MockitoBean. | Teoría + Práctica |
| **4. Avanzado** | 13:15 - 13:45 | @MockitoSpyBean y Wiremock basics. | Teoría + Práctica |
| 🏆 **Reto Final** | 13:45 - 14:30 | Proyecto real: Recomendación + Auditoría. | Desafío Final |

### 💡 Consejos para la Sesión Remota
- **Puntualidad con Git**: Mantén tu repositorio actualizado (`git pull`) antes de empezar cada bloque.
- **Entorno Preparado**: Ejecuta `mvn clean install` antes del inicio para descargar todas las dependencias.
- **Dudas en Tiempo Real**: Usa el chat o levanta la mano. No esperes a la resolución final si tienes errores locales.
- **Foco en el Reto Final**: El objetivo de los últimos 45 minutos es integrar todo. Es normal encontrar dificultades, ¡no te rindas!

---

## 📦 JUnit 5 Core: Desglose de Contenidos

### 🏗️ Sección 1: El Motor de JUnit 5
- **L1_HelloWorldExercise**: Tu primer test y aserción básica.
- **L3_LifecycleTheory**: `@BeforeEach`, `@BeforeAll` y aislamiento.
- **L4_LifecycleExercise**: Práctica del ciclo de vida con `OwnerService`.

### 🧪 Sección 2: Aserciones y Control de Flujo (Basics)
- **L1_AssertionsTheory**: Repaso completo de aserciones.
- **E1_AssertionsExercise**: Validando el `OwnerService` y `Pet`.
- **E2_GroupedAssertionsExercise**: Uso de `assertAll`.
- **E3_ExceptionsExercise**: Captura de errores con `assertThrows`.
- **E4_TimeoutsExercise**: Control de rendimiento básico.
- **E5_AssumptionsExercise**: Saltando tests según el entorno.
- **E6_AnnotationsExercise**: Uso de `@Disabled` y etiquetas.

### 🏗️ Sección 3: Dominando JUnit 5 (Advanced)
- **L1_AdvancedTheory**: Técnicas avanzadas de estructura.
- **E1_TagAndNestedExercise**: Desafío de orden y etiquetas.
- **E2_TestInterfaceExercise**: Interfaces de test para reutilización.
- **E3_RepeatedAndDIExercise**: Inyección de dependencias en JUnit.
- **E4_ParameterizedExercise**: Desafío de Parametrizados (Value/CSV/Method).

### ⚙️ Sección 4: Ejecución de Tests con Maven
- **L1_ExecutionTheory**: Configuración de Surefire y Failsafe.
- **L2_SpecialtyIntegrationIT**: Ejemplo de Test de Integración real.
- **E1_MavenExecutionExercise**: Filtrado de tags y generación de reportes.

---

## 🎭 Mockito: Desglose de Contenidos

### 🃏 Sección 1: Introducción a Mockito
- **L1_IntroTheory**: Conceptos base de Mocking.
- **L2_AnnotationTheory**: `@Mock` y `@InjectMocks` profesional.
- **L3_VerificationTheory**: Uso de `verify()` y Matchers basics.
- **L4_MatchersTheory**: Argument Matchers avanzados (`any`, `eq`, `anyString`).
- **E1_ManualMockingExercise**: Practica con `mock()` manual.
- **E2_AnnotationMockingExercise**: Uso de anotaciones intensivo.
- **E3_VerificationExercise**: Asegura las interacciones y el número de llamadas.
- **E4_MatchersExercise**: Reto: Stubs flexibles y la regla de mezcla de Matchers.

### 🎩 Sección 2: Spies y Partial Mocking
- **L1_SpyTheory**: Teoría fundamental de Spies, `doReturn` vs `when`.
- **L2_AdvancedSpyTheory**: Diferencia entre `@Spy` y `Mockito.spy()` manual.
- **L3_SpyDeepDiveTheory**: Funcionamiento interno (Shadow Copies), Clases Abstractas y Métodos Finales.
- **E1_SpyExercise**: Simulación de API con stubbing parcial.
- **E2_LegacySpyExercise**: Testeando código legado y efectos secundarios (auditoría).
- **E3_SpyCollections**: Espionaje de listas reales y vigilancia de flujos.
- **E4_SpyDeepDiveExercise**: Reto avanzado: el mecanismo de copiado y abstracciones.

### 🛡️ Sección 3: Advanced Mockito
- **L1_ExceptionsTheory**: Forzando errores controlados (`doThrow`).
- **L2_ArgumentCaptureTheory**: Captura de objetos complejos con `@Captor`.
- **L3_VerificationAdvancedTheory**: Orden cronológico (`InOrder`).
- **L4_SyntaxStruggleTheory**: El duelo final: `when` vs `doReturn`.
- **L5_PartialMockTheory**: Spies y Mocks Parciales de métodos locales.
- **L6_MockStaticTheory**: Mocking de métodos estáticos y lógica Singleton.
- **L7_AnswersTheory**: Respuestas dinámicas con `AdditionalAnswers.returnsFirstArg()`.
- **L8_MockedConstructionTheory**: Mocking de constructores (`new Object()`) en código legado.
- **L9_LambdaMatchersTheory**: Verificaciones complejas con predicados Lambda (`argThat`).
- **E1 a E10**: Ejercicios correspondientes de excepciones, captura, constructores y lógica avanzada.

---

## 🌱 Spring Testing: Desglose de Contenidos

### 🌳 Sección 1: Spring Framework Context
Carga y gestión de dependencias en el contenedor de Spring.
- **L1_SpringContextTheory**: Inyección de Beans reales (`@ContextConfiguration`).
- **L2_PrimaryQualifierTheory**: Diferenciación de Beans (`@Primary`, `@Qualifier`).
- **L3_InnerClassConfigTheory**: Mocks en clases de configuración internas.
- **L4_ProfilesTheory**: Activando entornos con `@ActiveProfiles`.
- **L5_TestPropertiesTheory**: Inyección de propiedades de test.
- **E1_HearingExercise**: Desafío de configuración básica.
- **E2_ProfileExercise**: Desafío de perfiles Yanny/Laurel.
- **L6_MockitoExtensionTheory**: Mockito Puro vs Contexto Spring.
- **E3_CustomExtensionExercise**: Práctica: Crea tu propia extensión Maven.

### 🌐 Sección 2: Spring MVC Test (MockMVC)
Pruebas de controladores web sin levantar el servidor.
- **L1_MockMVCStandaloneTheory**: Setup ligero manual.
- **L2_MockMVCWebContextTheory**: Slice Testing con `@WebMvcTest`.
- **L3_FormParametersTheory**: Envío de datos de formulario y `@MockBean`.
- **L4_ValidationErrorsTheory**: Validación de errores y redirecciones.
- **E1_StandaloneIndexExercise**: Práctica de setup manual en el índice.
- **E2_FormValidationExercise**: Práctica de validación masiva.

### 🔌 Sección 3: Spring Boot Context
Tests de integración total con la magia de Boot.
- **L1_SpringBootTestTheory**: Levantando TODO el contexto con `@SpringBootTest`.
- **E1_BootIntegrationExercise**: Práctica de servicios reales.

### 📡 Sección 4: REST Controller Tests
Validación de APIs JSON y clientes HTTP.
- **L1_JsonPathTheory**: Navegando por el JSON con selecciones dinámicas.
- **E1_VetRestExercise**: Práctica de validación REST.
- **L2_TestRestTemplateTheory**: Peticiones HTTP reales al servidor en puerto aleatorio.

### ☁️ Sección 5: Testing con Wiremock
Simulación de APIs externas de terceros.
- **L1_WiremockTheory**: Setup básico de servidor Mock HTTP.
- **L2_WiremockRecordingTheory**: Uso pro de `@WireMockTest`.
- **E1_WiremockExercise**: Práctica de simulación de errores externos.

### 🛠️ Sección 6: Configuration & Properties
Control de infraestructuras y configuración.
- **L1_ValueAnnotationTheory**: Inyección de propiedades del sistema.
- **L2_YamlPropertyTheory**: Lectura avanzada de YAML con **Custom Factory**.
- **L3_MockingValueTheory**: Mockear @Value sin levantar contexto.
- **E1_PropertiesExercise**: Desafío de inyección de propiedades.
- **E2_MockingValueExercise**: Desafío de simulación de propiedades.

### 💾 Sección 7: Data & Repositories (JPA/H2)
Persistencia de datos y simulación de BBDD.
- **L1_DataJpaTestTheory**: Slice Testing de Repositorios con `@DataJpaTest` y H2.
- **L2_MockBeanRepositoryTheory**: Testing de Servicios simulando la BBDD con `@MockBean`.
- **E1_DataJpaExercise**: Práctica: Guardar y Buscar por Apellido.

### 🚀 Sección 8: Spring Boot Test Features
Trucos avanzados de la magia de Boot.
- **L1_WebEnvironmentTheory**: Entornos Web: `MOCK` vs `RANDOM_PORT`.
- **L2_TestConfigurationTheory**: Sobrescribiendo Beans en ejecución con `@TestConfiguration`.
- **L3_LocalServerPortTheory**: Recuperación del puerto dinámico real.
- **L4_MockitoSpyBeanTheory**: Sobrescritura ágil de Beans con la nueva API de Spring.
- **E1_RandomPortExercise**: Práctica de entorno web y puerto dinámico.

### 🏆 Reto Final: Proyecto de Integración Real
- **FinalExercise (unit/ & integration/)**: Un proyecto completo con Controller, Service y Cliente API.
  - **Unit Tests**: Uso de `MockitoExtension`, `@InjectMocks` y `@WebMvcTest`.
  - **Integration Tests**: Uso de `WireMockExtension`, `@SpringBootTest` y `@DynamicPropertySource`.

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
