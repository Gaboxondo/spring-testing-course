package com.testing.course.junit5.section2_basics.solutions;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución 2: Aserciones Agrupadas y Dependientes Dinámicas.
 * Basado en: Section 5: Testing Java with JUnit 5 - 49, 50.
 */
class GroupedAssertionsSolution {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    void testGroupedAssertions() {
        Owner owner = new Owner("Beatriz", "Sánchez");
        owner.setCity("Madrid");
        owner.setTelephone("678554443");
        ownerService.save(owner);
        
        Owner saved = ownerService.findByLastName("Sánchez");

        // SOLUCIÓN:
        assertAll("Owner Logic Grouped",
            () -> assertEquals("Beatriz", saved.getFirstName(), "Nombre fallido"),
            () -> assertEquals("Sánchez", saved.getLastName(), "Apellido fallido")
        );

        // Dependent assertions (un assertAll dentro de otro)
        assertAll("Contact Info",
            () -> assertAll("City Check",
                () -> assertNotNull(saved.getCity(), "City no grabada"),
                () -> assertEquals("Madrid", saved.getCity())
            ),
            () -> assertAll("Telephone Check",
                () -> assertNotNull(saved.getTelephone(), "Telefono no grabado"),
                () -> assertEquals("678554443", saved.getTelephone())
            )
        );
    }
}
