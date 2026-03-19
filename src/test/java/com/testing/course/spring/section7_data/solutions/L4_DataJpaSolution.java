package com.testing.course.spring.section7_data.solutions;

import com.testing.course.model.Owner;
import com.testing.course.repository.OwnerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@DisplayName("Sección 7 - L4: Solución DataJpa")
class L4_DataJpaSolution {

    @Autowired
    OwnerRepository ownerRepository;

    @Test
    @DisplayName("🧪 Solución: Guardar y Buscar por Apellido")
    void testSaveAndFindByLastName() {
        // GIVEN
        Owner owner = new Owner("Eduardo", "Blanco");
        ownerRepository.save(owner);

        // WHEN
        Owner found = ownerRepository.findByLastName("Blanco")
            .orElse(null);

        // THEN
        assertTrue(found != null);
        assertEquals("Eduardo", found.getFirstName());
    }
}
