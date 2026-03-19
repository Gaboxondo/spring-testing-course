package com.gaboxondo.testing.junit5.section4_intro.theory;

import org.junit.jupiter.api.*;

/**
 * TEORÍA: El Ciclo de Vida en JUnit 5.
 * 
 * En JUnit 5, el ciclo de vida por defecto es PER_METHOD (se crea una nueva instancia 
 * de la clase de test para cada método @Test).
 */
@DisplayName("Teoría: Ciclo de Vida y Anotaciones Base")
class LifecycleTheoryTest {

    @BeforeAll
    static void setupAll() {
        System.out.println("1. @BeforeAll: Se ejecuta UNA VEZ antes de todos los tests. Debe ser estático.");
    }

    @BeforeEach
    void setupEach() {
        System.out.println("  2. @BeforeEach: Se ejecuta ANTES de CADA test individual. Ideal para inicializar objetos.");
    }

    @Test
    @DisplayName("✅ Demo Test 1")
    void firstTest() {
        System.out.println("    - Ejecutando Test 1");
    }

    @Test
    @DisplayName("✅ Demo Test 2")
    void secondTest() {
        System.out.println("    - Ejecutando Test 2");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("  3. @AfterEach: Se ejecuta DESPUÉS de CADA test. Ideal para limpiar recursos.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("4. @AfterAll: Se ejecuta UNA VEZ al final de todo. Debe ser estático.");
    }
}
