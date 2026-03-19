package com.testing.course.mockito.section2_advanced.theory;

import com.testing.course.model.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * TEORÍA SECCIÓN 11: Mocks vs Spies.
 * 
 * Basado en: Section 11 - Lección 134.
 * 
 * DETALLE FINO:
 * - @Mock: Crea un objeto con métodos que no hacen nada (devuelven null/0/false).
 * - @Spy: Crea una instancia que conserva el comportamiento real de los métodos (Real instance).
 *   Permite "pisar" solo los métodos que nos interese modificar (stubbing parcial).
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Teoría: Mockito Spies")
class L4_SpiesTheory {

    @Spy
    Owner owner = new Owner("Jose", "Ruiz");

    @Test
    @DisplayName("🧪 Demo 7: Spy vs Mock behaviour")
    void spyDemo() {
        // Un SPY llama al método real por defecto
        assertEquals("Jose", owner.getFirstName());

        // Podemos "pisar" el comportamiento real solo para el test
        doReturn("FalsoNombre").when(owner).getFirstName();

        assertEquals("FalsoNombre", owner.getFirstName());
        verify(owner).getFirstName();
    }
}
