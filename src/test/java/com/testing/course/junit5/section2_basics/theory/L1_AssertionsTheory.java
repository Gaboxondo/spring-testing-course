package com.testing.course.junit5.section2_basics.theory;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.*;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * <h1>TEORÍA: Aserciones y Control de Errores</h1>
 * 
 * <p><b>Qué hace:</b> Define el núcleo de las evaluaciones de JUnit 5, desde 
 * comparaciones de igualdad básicas hasta aserciones de excepciones y tiempos de respuesta.</p>
 * 
 * <p><b>Por qué existe:</b> Sin aserciones un test no tiene valor; es la forma 
 * de declarar contractualmente qué comportamiento esperamos del código de producción.</p>
 * 
 * <h2>Tipos de Aserciones:</h2>
 * <ul>
 *   <li><b>Aserciones Básicas:</b> Validaciones directas de igualdad, nulidad y booleanos.</li>
 *   <li><b>AssertAll (Grouped):</b> Permite ver fallos múltiples en una sola pasada de test.</li>
 *   <li><b>AssertThrows:</b> El estándar para validar la gestión de errores (Exceptions).</li>
 *   <li><b>AssertTimeout:</b> Verifica contratos de tiempo (performance) sin bloquear la ejecución.</li>
 *   <li><b>Assume:</b> Aborta el test graciosamente si no se cumple el entorno (Skipped).</li>
 * </ul>
 */
@DisplayName("Sección 2 - L1: Aserciones, Excepciones y Timeouts")
class L1_AssertionsTheory {

    private final OwnerService ownerService = new OwnerService();

    /**
     * <h2>DEMO: Aserciones Básicas (Core Assertions)</h2>
     *
     * <p>Este método demuestra las validaciones más Atómicas de JUnit 5. Son el pilar
     * de cualquier test unitario.</p>
     *
     * <ul>
     *   <li>{@link org.junit.jupiter.api.Assertions#assertEquals(Object, Object)}: Compara igualdad mediante <code>equals()</code>.</li>
     *   <li>{@link org.junit.jupiter.api.Assertions#assertTrue(boolean)}: Valida que una condición lógica sea verdadera.</li>
     *   <li>{@link org.junit.jupiter.api.Assertions#assertNotNull(Object)}: Asegura que una referencia no sea nula.</li>
     * </ul>
     *
     * <p><b>Buenas prácticas:</b> Siempre incluye un mensaje descriptivo como último parámetro
     * para facilitar la depuración cuando el test falle en un entorno de CI.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Aserciones Atómicas")
    void basicAssertionsDemo() {
        String name = "Paco";
        Owner owner = new Owner(name, "García");

        // 1. Igualdad
        assertEquals("Paco", owner.getFirstName(), "El nombre del propietario debería coincidir");

        // 2. Nulidad
        assertNotNull(owner, "El objeto Owner no debería ser nulo");

        // 3. Condición lógica (booleana)
        assertTrue(owner.getFirstName().startsWith("P"), "El nombre debería empezar por 'P'");

        // 4. Desigualdad (Ejemplo rápido)
        assertNotEquals("Pepe", owner.getFirstName(), "El nombre no debería ser Pepe");
    }

    /**
     * <h2>DEMO: Aserciones Agrupadas (assertAll)</h2>
     * <p>Garantiza que todos los campos del propietario se validen, incluso si el 
     * primer campo ya presentaba un error cosmético.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Validación profunda (assertAll)")
    void groupedAssertionsDemo() {
        Owner owner = new Owner("Paco", "García");
        
        assertAll("Validación de estado del Owner",
            () -> assertEquals("Paco", owner.getFirstName(), "Nombre inválido"),
            () -> assertEquals("García", owner.getLastName(), "Apellido inválido")
        );
    }

    /**
     * <h2>DEMO: Validación de Fallos Controlados</h2>
     * <p>Utilizamos <code>assertThrows</code> para asegurar que el sistema no 
     * permite el guardado de objetos nulos lanzando la excepción adecuada.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Captura de Excepciones de negocio")
    void exceptionsDemo() {
        assertThrows(IllegalArgumentException.class, () -> {
            ownerService.save(null);
        }, "Debe protegerse contra entradas nulas");
    }

    /**
     * <h2>DEMO: Control de Rendimiento (Timeout)</h2>
     * <p>Verificamos que el procesamiento lento no supere el umbral SLA de 600ms.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: Aserción de Tiempo Límite")
    void timeoutsDemo() {
        assertTimeout(Duration.ofMillis(600), () -> {
            ownerService.slowProcess();
        });
    }
}
