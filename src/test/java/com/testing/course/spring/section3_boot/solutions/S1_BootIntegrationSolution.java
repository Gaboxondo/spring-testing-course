package com.testing.course.spring.section3_boot.solutions;

import com.testing.course.service.VetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución L3: Integración Total en la Clínica.
 */
@SpringBootTest
class S1_BootIntegrationSolution {

    @Autowired
    VetService vetService;

    @Test
    void testVetServiceIsReal() {
        // SOLUCIÓN:
        assertNotNull(vetService);
        assertNotNull(vetService.findAll());
    }
}

