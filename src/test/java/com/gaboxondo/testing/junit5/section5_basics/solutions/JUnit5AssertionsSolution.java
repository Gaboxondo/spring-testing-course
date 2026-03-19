package com.gaboxondo.testing.junit5.section5_basics.solutions;

import com.gaboxondo.testing.model.Owner;
import com.gaboxondo.testing.model.Pet;
import com.gaboxondo.testing.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución 1: Aserciones Estándar con Lógica de Negocio.
 * Basado en: Section 5: Testing Java with JUnit 5 - 47, 48.
 */
@DisplayName("Sección 5: Aserciones Estándar Dinámicas")
class JUnit5AssertionsSolution {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    @DisplayName("🧪 Validar guardado de Owner y búsqueda")
    void testStandardAssertionsWithService() {
        Owner owner = new Owner("Jose", "Ruiz");
        ownerService.save(owner);
        
        Owner savedOwner = ownerService.findByLastName("Ruiz");

        // SOLUCIÓN:
        assertNotNull(savedOwner, "El owner debería haberse guardado");
        assertEquals("Jose", savedOwner.getFirstName());
        assertEquals("Ruiz", savedOwner.getLastName());
    }

    @Test
    @DisplayName("🧪 Validar adición de mascota")
    void testAddPet() {
        Owner owner = new Owner("Maria", "Perex");
        Pet pet = new Pet("Bobby", "Dog");
        
        ownerService.addPetToOwner(owner, pet);

        // SOLUCIÓN:
        assertFalse(owner.getPets().isEmpty(), "La lista de mascotas no debería estar vacía");
        assertTrue(owner.getPets().contains("Bobby"), "La lista debería contener a Bobby");
    }
}
