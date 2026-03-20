package com.testing.course.junit5.section1_intro.theory;

import org.junit.jupiter.api.*;

/**
 * <h1>TEORÍA: El Ciclo de Vida en JUnit 5</h1>
 * 
 * <p><b>Qué hace:</b> Gestiona el orden de ejecución de los métodos de configuración 
 * y de limpieza (Before/After) en relación con los métodos de test.</p>
 * 
 * <p><b>Por qué existe:</b> Garantiza que cada test se ejecute en un entorno limpio 
 * y aislado, evitando contaminaciones cruzadas (test side-effects) entre las ejecuciones.</p>
 * 
 * <h2>Anotaciones de Ciclo de Vida:</h2>
 * <ul>
 *   <li><b>@BeforeAll:</b> Ejecución única antes de iniciar la clase. Debe ser estático.</li>
 *   <li><b>@BeforeEach:</b> Ejecución individual antes de cada @Test. Ideal para instanciación.</li>
 *   <li><b>@AfterEach:</b> Limpieza tras cada @Test.</li>
 *   <li><b>@AfterAll:</b> Limpieza única final. Debe ser estático.</li>
 * </ul>
 */
@DisplayName("Sección 1 - L1: Ciclo de Vida y Estandarización")
class L1_LifecycleTheory {

    @BeforeAll
    static void setupAll() {
        System.out.println("1. @BeforeAll: Preparación de infraestructura pesada (ej: Docker, DB).");
    }

    @BeforeEach
    void setupEach() {
        System.out.println("  2. @BeforeEach: Inicializando objetos de negocio para el siguiente test.");
    }

    @Test
    @DisplayName("✅ Demo: Primer Test de Evaluación")
    void firstTest() {
        System.out.println("    - Ejecutando Test Funcional 1");
    }

    @Test
    @DisplayName("✅ Demo: Segundo Test de Evaluación")
    void secondTest() {
        System.out.println("    - Ejecutando Test Funcional 2");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("  3. @AfterEach: Limpiando memoria volátil.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("4. @AfterAll: Cierre final de conexiones.");
    }
}
