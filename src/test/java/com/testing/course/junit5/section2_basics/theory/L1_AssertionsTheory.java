package com.testing.course.junit5.section2_basics.theory;

import com.testing.course.model.Owner;
import com.testing.course.model.Pet;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.*;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * <h1>TEORÍA: Aserciones, Excepciones, Timeouts y Asunciones</h1>
 * 
 * <p>Esta sección profundiza en las herramientas de control 
 * de flujo de tests proporcionadas por JUnit 5, desde lo más básico a lo avanzado.</p>
 * 
 * <h2>Principios Clave:</h2>
 * <ul>
 *   <li><b>Aserciones Simples:</b> <code>assertEquals</code>, <code>assertTrue</code>, 
 *   <code>assertNotNull</code>, etc. Son la base de cualquier test.</li>
 *   <li><b>AssertAll (Grouped Assertions):</b> Permite agrupar múltiples aserciones. 
 *   Si una falla, las demás se siguen ejecutando, proporcionando un informe completo.</li>
 *   <li><b>AssertThrows:</b> El mecanismo idiomático de JUnit 5 para validar 
 *   que el código lanza la excepción esperada ante entradas incorrectas.</li>
 *   <li><b>AssertTimeout:</b> Controla que un bloque de código no exceda un tiempo máximo 
 *   de ejecución, vital para SLAs de rendimiento.</li>
 *   <li><b>Asunciones (Assumptions):</b> Permiten abortar un test (Skipped) en lugar de 
 *   fallarlo si el entorno no es el adecuado (p.ej., perfil de CI/CD incorrecto).</li>
 * </ul>
 * 
 * @see org.junit.jupiter.api.Assertions
 * @since 1.0
 */
@DisplayName("Teoría: Aserciones y Control de Flujo")
class L1_AssertionsTheory {

    private final OwnerService ownerService = new OwnerService();

    /**
     * TAREA DEMO 1: Aserciones simples.
     * <p>Muestra el uso de las aserciones más comunes para validar estados simples.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Aserciones simples (assertEquals, assertTrue, assertNotNull)")
    void simpleAssertionsDemo() {
        String name = "JUnit 5";
        Owner owner = new Owner("Paco", "García");
        
        // assertEquals: Compara igualdad
        assertEquals("JUnit 5", name, "Los nombres deberían ser iguales");
        
        // assertTrue / assertFalse: Valida condiciones booleanas
        assertTrue(name.startsWith("J"), "Debería empezar por J");
        
        // assertNotNull / assertNull: Valida si un objeto existe o no
        assertNotNull(owner, "El objeto owner no debería ser nulo");
    }

    /**
     * TAREA DEMO 2: Aserciones agrupadas.
     * <p>Usa <code>assertAll</code> para validar múltiples propiedades de un objeto 
     * sin detener la ejecución al primer error. Esto es más avanzado que las aserciones simples.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Aserciones agrupadas (assertAll)")
    void groupedAssertionsDemo() {
        Owner owner = new Owner("Paco", "García");
        
        // assertAll permite que todos los tests se ejecututen incluso si uno falla.
        // Si usamos assertEquals seguidos (sin assertAll), el test se para en el primer fallo.
        assertAll("Validación de campos del Owner",
            () -> assertEquals("Paco", owner.getFirstName(), "El nombre no coincide"),
            () -> assertEquals("García", owner.getLastName(), "El apellido no coincide")
        );
    }

    /**
     * TAREA DEMO 3: Gestión de Excepciones.
     * <p>Muestra cómo validar que el servicio <code>OwnerService</code> lanza 
     * <code>IllegalArgumentException</code> cuando se le pasa un objeto nulo.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Gestión de Excepciones (assertThrows)")
    void exceptionsDemo() {
        // Validamos que el sistema responde correctamente a errores de negocio.
        assertThrows(IllegalArgumentException.class, () -> {
            ownerService.save(null);
        }, "Debería lanzar IllegalArgumentException si el objeto es nulo");
    }

    /**
     * TAREA DEMO 4: Control de Tiempos.
     * <p>Asegura que el proceso lento no tarde más de 600 milisegundos mediante 
     * <code>assertTimeout</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: Control de Tiempos (assertTimeout)")
    void timeoutsDemo() {
        assertTimeout(Duration.ofMillis(600), () -> {
            ownerService.slowProcess();
        });
    }

    /**
     * TAREA DEMO 5: Asunciones.
     * <p>Ejemplo de test condicional que solo se ejecuta si la variable de entorno 
     * <code>ENV</code> es igual a <code>DESARROLLO</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 5: Asunciones (assumeTrue)")
    void assumptionsDemo() {
        // El test se marcará como 'Ignorado' (Skipped) si no se cumple la asunción.
        assumeTrue("DESARROLLO".equalsIgnoreCase(System.getenv("ENV")), 
            "Abortando: Solo se ejecuta en entorno de DESARROLLO");
        
        System.out.println("Lógica específica de entorno local ejecutada.");
    }
}

