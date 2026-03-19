package com.gaboxondo.testing.junit5.section5_basics.solutions;

import com.gaboxondo.testing.model.Owner;
import com.gaboxondo.testing.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución 4: Validando Excepciones en el Servicio.
 * Basado en: Section 5: Testing Java with JUnit 5 - 53.
 */
@DisplayName("Sección 5: Gestión de Excepciones Dinámicas")
class ExceptionsSolution {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    @DisplayName("🧪 Error al guardar Owner sin nombre")
    void testExpectedExceptionOnSave() {
        Owner owner = new Owner("", "Zapatero"); // Nombre vacío

        // SOLUCIÓN:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ownerService.save(owner);
        }, "Guardar un owner sin nombre debería haber lanzado IllegalArgumentException");

        assertEquals("El nombre es obligatorio", exception.getMessage());
    }

    @Test
    @DisplayName("🧪 Error al guardar Owner nulo")
    void testExpectedExceptionOnNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ownerService.save(null);
        });
    }
}
