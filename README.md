# 🎓 Curso Maestro: Testing con Spring Boot (Junior Edition)

¡Bienvenido al repositorio oficial del curso **Spring Boot Testing: De Beginner a Guru (Adaptado)**! 🚀

Este proyecto ha sido diseñado para guiar a desarrolladores Junior a través del fascinante mundo del testing automatizado. No usaremos "placeholders" ni ejemplos vacíos; utilizaremos un dominio real basado en una clínica veterinaria para aplicar conceptos de **JUnit 5**, **AssertJ** y, próximamente, **Mockito**.

---

## 🗺️ Mapa de Ruta del Curso

El curso está organizado en bloques incrementales de dificultad. Cada bloque contiene tres pilares fundamentales:
*   **📖 Teoría (`theory/`)**: Ejemplos listos para ejecutar y entender el concepto base.
*   **🧩 Ejercicios (`exercises/`)**: Desafíos con `TODO` diseñados para que el alumno complete el código.
*   **✅ Soluciones (`solutions/`)**: El código final esperado para validar tus avances.

---

## 📦 Desglose de Contenidos (JUnit 5 Core)

### 🏗️ Sección 4: El Motor de JUnit 5
Fundamentos y ciclo de vida. Es la base sobre la que construiremos todo.
- **Lección 38**: Hola Mundo y primera aserción.
- **Lección 39/40**: El ciclo de vida (`@BeforeEach`, `@BeforeAll`, etc.) y la instancia del test.
- **Lección 41**: Ejecución remota y CLI.

### 🧪 Sección 5: Aserciones y Control de Flujo (Basics)
Aquí es donde el testing se vuelve "real" al usar `OwnerService`.
- **Aserciones Estándar**: `assertEquals`, `assertTrue`, `assertNotNull`.
- **Grouped Assertions**: Uso de `assertAll` para validaciones masivas (Multiple failures).
- **Exceptions**: `assertThrows` para validar errores de negocio (Ej: nombres vacíos).
- **Timeouts**: `assertTimeout` para pruebas de rendimiento básico.
- **Assumptions**: Cómo saltar tests según el sistema operativo o variables de entorno.

### 🏗️ Sección 6: Dominando JUnit 5 (Advanced)
Técnicas avanzadas para escribir tests limpios, mantenibles y profesionales.
*   **Temas**: `@Nested`, `@Tag`, `@ParameterizedTest` (ValueSource, CsvSource, MethodSource) e inyección de dependencias (`TestInfo`, `TestReporter`).
*   **Ubicación**: `src/test/java/com/gaboxondo/testing/junit5/section6_advanced`.

### ⚙️ Sección 7: Ejecución de Tests con Maven
Domina las herramientas de ejecución, plugins y reportes. Sin Gradle, enfocado 100% en el ecosistema Maven.
*   **Convención IT**: Diferenciación entre tests unitarios (`*Test.java`) y de integración (`*IT.java`).
*   **Plugins**: Maven Surefire vs Maven Failsafe.
*   **Reportes**: Generación de reportes HTML para visualización de calidad.
*   **Ubicación**: `src/test/java/com/gaboxondo/testing/junit5/section7_execution`.

### 🃏 Sección 9: Empezando con Mockito
Introducción al mundo de los objetos simulados (Mocks) para aislar la lógica de negocio.
*   **Conceptos**: Mocking Inline vs Anotaciones (`@Mock`, `@InjectMocks`).
*   **Manejo**: Programación conductual (`when(...).thenReturn(...)`) y verificación de interacciones (`verify`).
*   **Matchers**: Uso de `any()` y validación por número de llamadas (`times`).
*   **Ubicación**: `src/test/java/com/gaboxondo/testing/mockito/section9_intro`.

### 🎩 Sección 11: Advanced Mockito
Técnicas ninja para casos complejos y validaciones profundas.
*   **Captura**: Uso de `@Captor` para inspeccionar objetos pasados a dependencias.
*   **Excepciones**: Programación de errores en mocks (`doThrow`).
*   **Orden y Tiempo**: Verificaciones cronológicas (`InOrder`) y límites de ejecución (`timeout`).
*   **Espionaje**: Diferencias entre Mock y Spy (`@Spy`).
*   **Ubicación**: `src/test/java/com/gaboxondo/testing/mockito/section11_advanced`.

---

## 🛠️ Comandos Maestros de Maven

Para dominar este repositorio desde la terminal, utiliza estos comandos estratégicos:

| Objetivo | Comando |
| :--- | :--- |
| **🚀 Ejecutar TODO** | `mvn test` (Usa este comando en CI o antes de un commit) |
| **🎯 Ejecutar LECCIÓN** | `mvn test -Dtest=NombreClase` (Evita ejecutar tests de secciones pasadas) |
| **🏗️ Integration Tests** | `mvn verify` (Busca solo clases terminadas en IT.java) |
| **📊 Reporte HTML** | `mvn surefire-report:report` |
| **🏷️ Filtrar Tag** | `mvn test -Dgroups="smoke"` |

> [!TIP]
> **Ahorro de Tiempo**: Durante el curso, utiliza siempre `-Dtest=NombreDeLaClase` para no ejecutar los tests de las lecciones que ya has superado. Maven por defecto escanea todo el proyecto.


---

## ⚙️ Requisitos Técnicos
Para asegurar la compatibilidad total del curso, necesitamos:
- **Java 25 (LTS)**: Aprovechando las últimas mejoras del lenguaje.
- **Maven 3.9+**: Gestor de dependencias y ciclo de vida.
- **IDE Recomendado**: IntelliJ IDEA o VS Code (con Java Extension Pack).

---

## 🐕 El Dominio: Clínica Veterinaria (Pet Clinic)
Estamos testeando un sistema que gestiona:
- **Owners / Pets**: Clientes de la clínica y sus mascotas.
- **VetService**: Gestión de veterinarios inyectando `VetRepository`.
- **VisitService**: Registro de visitas médicas inyectando `VisitRepository`.

### 🃏 El Poder de Mockito
En las secciones 9 y 11 aprendemos a:
*   **Aislar Servicios**: Probamos `VetService` y `VisitService` simulando sus bases de datos (`Repositories`) para que los tests sean rápidos y predecibles.
*   **Capturar Datos**: Validamos que la lógica de negocio no altere los objetos antes de guardarlos.
*   **Forzar Errores**: Simulamos fallos de disco o validación para ver cómo reacciona nuestro código.

---

*Este curso está en constante evolución. Sigue los commits para actualizaciones de **Sección 9: Mockito**.*

**Hecho con ❤️ por Antigravity (Powered by Google Deepmind) para Gaboxondo.**
