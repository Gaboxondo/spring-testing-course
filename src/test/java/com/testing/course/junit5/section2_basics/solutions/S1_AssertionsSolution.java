package com.testing.course.junit5.section2_basics.solutions;

import com.testing.course.model.Owner;
import com.testing.course.model.Pet;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución 1: Aserciones Estándar de JUnit 5.
 * 
 * <p>En esta solución se muestran las aserciones básicas para validar
 * el estado de los objetos y resultados de servicios.</p>
 */
@DisplayName("Solución 1: Aserciones Estándar")
class S1_AssertionsSolution {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    @DisplayName("🧪 Validar guardado de Owner y búsqueda (Aserciones simples)")
    void testStandardAssertionsWithService() {
        Owner owner = new Owner("Jose", "Ruiz");
        ownerService.save(owner);
        
        Owner savedOwner = ownerService.findByLastName("Ruiz");

        // SOLUCIÓN:
        assertNotNull(savedOwner, "El owner debería haberse guardado");
        assertEquals("Jose", savedOwner.getFirstName(), "El nombre no coincide");
        assertEquals("Ruiz", savedOwner.getLastName(), "El apellido no coincide");
    }

    @Test
    @DisplayName("🧪 Validar adición de mascota (assertTrue/assertFalse)")
    void testAddPetSimple() {
        Owner owner = new Owner("Maria", "Perez");
        Pet pet = new Pet("Bobby", "Dog");
        
        ownerService.addPetToOwner(owner, pet);

        // SOLUCIÓN:
        assertFalse(owner.getPets().isEmpty(), "La lista de mascotas no debería estar vacía");
        assertTrue(owner.getPets().contains("Bobby"), "La lista debería contener a Bobby");
    }
}


