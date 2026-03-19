package com.testing.course.junit5.section5_basics.solutions;

import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución 5: Control de Tiempo en Servicios.
 * Basado en: Section 5: Testing Java with JUnit 5 - 54.
 */
@DisplayName("Sección 5: Timeouts en Lógica de Negocio")
class TimeoutsSolution {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    @DisplayName("🧪 Validar tiempo de ejecución de proceso lento")
    void testTimeoutOfService() {
        // SOLUCIÓN: El test fallará si el método 'slowProcess' tarda más de 600ms.
        // Como sabemos que tarda 500ms, este test debería pasar.
        assertTimeout(Duration.ofMillis(600), () -> {
            ownerService.slowProcess();
            System.out.println("El proceso no ha excedido el límite.");
        });
    }

    @Test
    @DisplayName("🧪 Validar timeout preemptivo (con detención inmediata)")
    void testTimeoutPreemptivelyOfService() {
        // SOLUCIÓN: Si tardara mas de 100ms se detendrá de inmediato y reportará fallo.
        assertThrows(AssertionError.class, () -> {
            assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
                ownerService.slowProcess();
            });
        }, "Debería fallar porque el proceso dura 500ms");
    }
}
