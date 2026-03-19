package com.testing.course.spring.section7_data.theory;

import com.testing.course.model.Owner;
import com.testing.course.repository.OwnerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Sección 7 - L1: Testing con @DataJpaTest.
 * 
 * Esta anotación es un "Slice Test" para la capa de persistencia.
 * 
 * CARACTERÍSTICAS:
 * 1. Configura una base de datos embebida (normalmente H2) automáticamente.
 * 2. Escanea solo @Entity y repositorios de Spring Data JPA.
 * 3. Es @Transactional: Cada test revierte sus cambios al finalizar (rollback).
 */
@DataJpaTest
@DisplayName("Sección 7 - L1: Repositorios con @DataJpaTest")
class L1_DataJpaTestTheory {

    @Autowired
    OwnerRepository ownerRepository;

    @Test
    @DisplayName("🧪 Guardar y recuperar un Owner en H2")
    void testSaveOwner() {
        Owner owner = new Owner("Jose", "Garcia");
        Owner saved = ownerRepository.save(owner);

        assertNotNull(saved.getId());
        assertEquals("Garcia", saved.getLastName());
    }

    @Test
    @DisplayName("🧪 Verificar que findByLastName funciona correctamente")
    void testFindByLastName() {
        ownerRepository.save(new Owner("Maria", "Perez"));
        
        Owner found = ownerRepository.findByLastName("Perez")
            .orElseThrow();
            
        assertEquals("Maria", found.getFirstName());
    }
}
