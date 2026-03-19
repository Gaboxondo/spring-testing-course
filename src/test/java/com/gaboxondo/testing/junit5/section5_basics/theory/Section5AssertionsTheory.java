package com.gaboxondo.testing.junit5.section5_basics.theory;

import com.gaboxondo.testing.model.Owner;
import com.gaboxondo.testing.service.OwnerService;
import org.junit.jupiter.api.*;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * TEORÍA: Sección 5 - Aserciones, Excepciones, Timeouts y Asunciones.
 * 
 * Basado en: Section 5 - Lecciones 47 a 56.
 * 
 * DETALLE FINO:
 * - 'assertAll' (Grouped Assertions) usa lambdas para ejecutar TANTAS aserciones como sea posible.
 *   Si una falla, el test CONTINÚA ejecutando las demás para darte un reporte completo de errores.
 * - 'assertThrows' devuelve el objeto Exception capturado para permitirte validar el mensaje 
 *   o el historial de causas de la excepción.
 * 
 * REFERENCIAS:
 * - Lógica de negocio en: 'src/main/java/com/gaboxondo/testing/service/OwnerService.java'
 * - Modelos en: 'src/main/java/com/gaboxondo/testing/model/'
 */
@DisplayName("Teoría: Aserciones y Control de Flujo")
class Section5AssertionsTheory {

    OwnerService ownerService = new OwnerService();

    @Test
    @DisplayName("🧪 Demo 1: Aserciones agrupadas (assertAll)")
    void groupedAssertionsDemo() {
        Owner owner = new Owner("Paco", "García");
        
        // assertAll permite que todos los tests se ejecuten incluso si uno falla.
        // Muy útil para no detener el build al primer fallo de una serie de validaciones.
        assertAll("Validación de Owner",
            () -> assertEquals("Paco", owner.getFirstName(), "El nombre falló"),
            () -> assertEquals("García", owner.getLastName(), "El apellido falló")
        );
    }

    @Test
    @DisplayName("🧪 Demo 2: Gestión de Excepciones (assertThrows)")
    void exceptionsDemo() {
        // Validamos que el sistema responde correctamente a errores.
        assertThrows(IllegalArgumentException.class, () -> {
            ownerService.save(null);
        }, "Debería lanzar error si el objeto es nulo");
    }

    @Test
    @DisplayName("🧪 Demo 3: Control de Tiempos (assertTimeout)")
    void timeoutsDemo() {
        // Validamos que el proceso no exceda el tiempo máximo permitido.
        assertTimeout(Duration.ofMillis(600), () -> {
            ownerService.slowProcess();
        });
    }

    @Test
    @DisplayName("🧪 Demo 4: Asunciones (assumeTrue)")
    void assumptionsDemo() {
        // En lugar de fallar (Test Fail), el test se ABORTA (Status: Skipped)
        // si no se cumple la condición.
        assumeTrue("DESARROLLO".equalsIgnoreCase(System.getenv("ENV")));
        
        System.out.println("Este código solo se llega a ver si ENV = DESARROLLO");
    }
}
