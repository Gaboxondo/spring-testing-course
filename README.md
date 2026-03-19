# 🚀 Curso de Testing con Spring Boot (Juniors)

¡Bienvenidos al curso de **Spring Boot Testing**! Este repositorio es tu laboratorio práctico para aprender a escribir tests automáticos desde cero hasta un nivel profesional.

---

## 🎯 Guía del Estudiante: Cómo avanzar por el curso
El curso está estructurado en tres niveles para que puedas progresar de forma lógica:
1.  **Teoría (`theory/`)**: Código de ejemplo para seguir las explicaciones del profesor.
2.  **Ejercicios (`exercises/`)**: Plantillas con `TODO` para que pongas en práctica lo aprendido.
3.  **Soluciones (`solutions/`)**: El código final esperado para comparar tus resultados.

---

## 🚦 Roadmap del Curso (JUnit 5 Puro)

### 📦 Sección 4: Introducción a JUnit 5
Aprende los fundamentos básicos del motor de ejecución y el ciclo de vida.
*   **Temas**: `@BeforeEach`, `@BeforeAll`, `@AfterEach`, `@AfterAll`, `@Test` y `@Disabled`.
*   **Ubicación**: `src/test/java/com/gaboxondo/testing/junit5/section4_intro`.

### 🧪 Sección 5: JUnit 5 Basics
Domina las aserciones y el manejo de errores.
*   **Temas**: `assertAll`, `assertThrows` (excepciones), `assertTimeout` (rendimiento), `assumeTrue` (asunciones condicionales).
*   **Lógica Real**: Empezamos a usar `OwnerService` para probar comportamientos reales.
*   **Ubicación**: `src/test/java/com/gaboxondo/testing/junit5/section5_basics`.

### 🏗️ Sección 6: Advanced JUnit Testing
Organización y eficiencia para grandes proyectos.
*   **Temas**: `@Nested`, `@Tag`, `@ParameterizedTest` (ValueSource, CsvSource, MethodSource) e inyección de dependencias (`TestInfo`, `TestReporter`).
*   **Ubicación**: `src/test/java/com/gaboxondo/testing/junit5/section6_advanced`.

---

## 🛠️ Comandos de Maven Esenciales

Para moverte por el curso, necesitarás ejecutar tests de forma específica. Aquí tienes los comandos clave:

### 1. Ejecutar todos los tests del proyecto
```bash
mvn test
```

### 2. Ejecutar una clase de test específica (Teoría o Ejercicio)
```bash
# Ejemplo: Ejecutar la teoría de la sección 4
mvn test -Dtest=LifecycleTheoryTest

# Ejemplo: Ejecutar tu ejercicio de aserciones
mvn test -Dtest=JUnit5AssertionsExercise
```

### 3. Ejecutar tests por Etiquetas (@Tag)
En la Sección 6 aprenderás a etiquetar tests. Puedes filtrar la ejecución así:
```bash
# Ejecutar solo tests marcados como "smoke"
mvn test -Dgroups="smoke"

# Excluir tests marcados como "persistence"
mvn test -DexcludedGroups="persistence"
```

### 4. Ejecutar un único método dentro de un test
```bash
mvn test -Dtest=OwnerServiceTest#testSaveOwner
```

---

## 🛠️ Estructura del Proyecto
*   `src/main/java`: Contiene los modelos (`Owner`, `Pet`, `Vet`) y servicios (`OwnerService`) que estamos testeando.
*   `src/test/java`: Contiene todo el material didáctico.

---

## 📡 Tecnologías Incluidas
*   **Java 25 (LTS)**
*   **Spring Boot 3.5.3**
*   **Maven 3.9.14**
*   **JUnit 5 (Jupiter)**: Motor de ejecución de tests.

---
*Hecho con ❤️ para la comunidad de desarrolladores junior por Antigravity (Powered by Google Deepmind)*
