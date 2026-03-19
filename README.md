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

---

## 🛠️ Comandos Maestros de Maven

Para dominar este repositorio desde la terminal, utiliza estos comandos estratégicos:

| Objetivo | Comando |
| :--- | :--- |
| **Ejecurar Unit Tests** | `mvn test` |
| **Ejecutar Integration Tests** | `mvn verify` |
| **Generar Reporte HTML** | `mvn surefire-report:report` |
| **Compilar sin Testear** | `mvn compile -DskipTests` |
| **Ejecutar una teoría** | `mvn test -Dtest=AdvancedJUnit5Theory` |
| **Ejecutar un ejercicio** | `mvn test -Dtest=ParameterizedExercise` |
| **Filtrar por Etiqueta** | `mvn test -Dgroups="smoke"` |
| **Excluir por Etiqueta** | `mvn test -DexcludedGroups="slow"` |
| **Hacer Push (Profesor)** | `git push origin main` |

---

## ⚙️ Requisitos Técnicos
Para asegurar la compatibilidad total del curso, necesitamos:
- **Java 25 (LTS)**: Aprovechando las últimas mejoras del lenguaje.
- **Maven 3.9+**: Gestor de dependencias y ciclo de vida.
- **IDE Recomendado**: IntelliJ IDEA o VS Code (con Java Extension Pack).

---

## 🐕 El Dominio: Clínica Veterinaria (Pet Clinic)
Estamos testeando un sistema que gestiona:
- **Owners**: Clientes de la clínica con validaciones de contacto.
- **Pets**: Mascotas asociadas a los clientes.
- **OwnerService**: Nuestro motor de búsqueda y persistencia en memoria.

---
*Este curso está en constante evolución. Sigue los commits para actualizaciones de **Sección 9: Mockito**.*

**Hecho con ❤️ por Antigravity (Powered by Google Deepmind) para Gaboxondo.**
