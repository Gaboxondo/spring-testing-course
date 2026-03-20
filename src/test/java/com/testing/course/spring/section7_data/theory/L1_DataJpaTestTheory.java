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
 * <h1>TEORÍA: Tests de Persistencia (@DataJpaTest)</h1>
 * 
 * <p><b>Qué hace:</b> Levanta un entorno de persistencia mínimo que incluye 
 * una base de datos embebida (normalmente H2), escaneo de entidades y repositorios.</p>
 * 
 * <p><b>Por qué existe:</b> Permite validar que las consultas SQL personales (@Query) 
 * o las derivadas por nombre (Query Methods) funcionan realmente sobre el motor de base de datos.</p>
 * 
 * <h2>Transaccionalidad:</h2>
 * <p>Por defecto, <code>@DataJpaTest</code> marca cada método de test como 
 * <b>@Transactional</b> y realiza un Rollback al finalizar, manteniendo la DB impecable.</p>
 */
@DataJpaTest
@DisplayName("Sección 7 - L1: Persistencia Real con H2")
class L1_DataJpaTestTheory {

    @Autowired
    private OwnerRepository ownerRepository;

    /**
     * <h2>DEMO: Ciclo de vida de una Entidad</h2>
     * <p>Guardamos un objeto y verificamos que el ID ha sido generado por el 
     * motor de base de datos antes de recuperarlo.</p>
     */
    @Test
    @DisplayName("🧪 Demo 11: Guardado y búsqueda por Query Method")
    void testSaveAndFind() {
        ownerRepository.save(new Owner("Maria", "Perez"));
        
        Owner found = ownerRepository.findByLastName("Perez")
            .orElseThrow();
            
        assertEquals("Maria", found.getFirstName());
    }
}
