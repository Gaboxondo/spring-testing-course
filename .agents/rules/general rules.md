---
trigger: always_on
---

# 🧠 Reglas del Agente - Tests y Flujo de Trabajo

## Documentacion oficial de lo tratado en el curso

- ten siempre como referencia estas URLs de doc oficial
  - https://docs.junit.org/5.5.0/user-guide/
  - https://javadoc.io/doc/org.mockito/mockito-core/latest/org.mockito/org/mockito/Mockito.html
  - https://docs.spring.io/spring-boot/reference/testing/index.html
## 📌 Control de cambios
- Siempre realiza `git commit` y `git push` después de aplicar cambios.
- Si creas archivos temporales (por ejemplo, `.txt` para lectura de datos), asegúrate de eliminarlos una vez finalizado su uso.

## 📚 Estructura de los cursos de testing
Los cursos de testing están organizados en 3 capítulos principales:

- `junit5`
- `mockito`
- `spring`

Cada capítulo contiene varias secciones, y cada sección sigue esta estructura:

- `/theory`
- `/exercises`
- `/solutions`

### 🧩 Convenciones de nomenclatura

#### Teoría
- Los archivos de teoría están prefijados como:
  - `L1`, `L2`, `L3`, ...
- El orden es secuencial y refleja la progresión del contenido.

#### Ejercicios
- Los ejercicios están nombrados como:
  - `EX1`, `EX2`, `EX3`, ...

#### Soluciones
- Las soluciones están nombradas como:
  - `S1`, `S2`, `S3`, ...
- Regla importante: el número del ejercicio (`EX`) y su solución (`S`) debe coincidir.

### 🔢 Organización y numeración del contenido
- Cuando se añadan nuevos ficheros de teoría, ejercicios o soluciones, se debe analizar cuál es la posición lógica dentro del curso.
- No se deben añadir automáticamente como los últimos (`Lx`, `EXx`, `Sx`) si el contenido es más básico o previo a otros ya existentes.
- La numeración debe reflejar una progresión pedagógica correcta (de lo más básico a lo más avanzado).
- Si es necesario, se deben reorganizar numeraciones existentes para mantener coherencia en el aprendizaje.

## 🧪 Aislamiento de los tests
- Los tests deben crearse de forma completamente aislada en cada sección.
- Un test, ejercicio o solución de una sección no debe depender de clases, configuraciones o recursos pensados para otra sección.
- Si para una sección se necesitan clases adicionales de código de producción, deben crearse específicamente para esa sección.
- No se deben modificar clases compartidas o ya existentes si ese cambio puede afectar al comportamiento de otros tests.
- Debe priorizarse el aislamiento y la independencia de cada sección frente a la reutilización que pueda introducir acoplamiento o efectos laterales.

## 📝 Documentación del código
- Todos los métodos y clases en Java deben incluir documentación detallada (JavaDoc).
- La documentación debe explicar:
  - Qué hace el método o clase.
  - Por qué existe.
  - Cómo se usa.
- Es recomendable incluir explicaciones adicionales de anotaciones, incluso si no están directamente relacionadas con testing.
- Se prioriza siempre **más contexto y claridad** frente a documentación mínima.

## 🚫 Tests vacíos o incompletos
- Cualquier test que:
  - No contenga lógica
  - Sea un placeholder
  - Corresponda a un ejercicio no resuelto

Debe marcarse como `@Disabled` para evitar que afecte a la ejecución completa de:

`mvn clean install`

## ✅ Validación de tests
- Se debe comprobar siempre que los tests de teoría (`theory`) y soluciones (`solutions`):
  - Compilan correctamente.
  - Se ejecutan sin errores.
- Ningún test de teoría o solución debe romper el build.
- El proyecto debe poder ejecutar correctamente `mvn clean install` en todo momento.


## ✅ Dificultad de los ejercicios
- Los ejercicios deben de ser medianamente complejos, no solo ejercicios simples iguales que lo que se muestra en la teoria

## Actualizacion del repo remoto

- acuerdate siempre de hacer git add, commit y push al repo remoto

## ✅ Buenas prácticas adicionales
- Mantener consistencia en nombres y estructura.
- Evitar dejar código temporal o artefactos innecesarios en el repositorio.
- Asegurar que el build siempre pasa antes de hacer push.
