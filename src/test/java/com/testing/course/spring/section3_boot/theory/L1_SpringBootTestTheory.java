package com.testing.course.spring.section3_boot.theory;

import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Sección 3 - L1: @SpringBootTest (Integración Total).
 * 
 * Es la anotación más potente y pesada. 
 * Levanta el contexto COMPLETO de tu aplicación (Beans, Repos, DB en memoria).
 */
@SpringBootTest
@DisplayName("Sección 3 - L1: @SpringBootTest")
class L1_SpringBootTestTheory {

    @Autowired
    OwnerService ownerService;

    @Test
    @DisplayName("🧪 Verificar que el servicio real está inyectado")
    void testProjectSetup() {
        // En este test de integración, tenemos TODO el poder de Spring Boot.
        assertNotNull(ownerService);
        assertTrue(ownerService.getOwnerCount() >= 0);
    }
}

