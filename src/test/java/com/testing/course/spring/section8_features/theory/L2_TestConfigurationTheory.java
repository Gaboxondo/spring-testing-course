package com.testing.course.spring.section8_features.theory;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Sección 8 - L2: Sobrescribiendo beans con @TestConfiguration.
 * 
 * Si queremos cambiar un Bean por una configuración especial de test, 
 * usamos @TestConfiguration.
 * 
 * NOTA: Esta anotación añade cosas al contexto principal, 
 * pudiendo incluso sobrescribir beans con @Primary.
 */
@SpringBootTest
@DisplayName("Sección 8 - L2: @TestConfiguration")
class L2_TestConfigurationTheory {

    @TestConfiguration // Indica configuración específica para este test.
    static class OverrideConfig {
        @Bean
        @Primary // Fuerza a que este sea el Service que se inyecte aquí.
        public OwnerService mockOwnerService() {
            OwnerService mock = mock(OwnerService.class);
            when(mock.findByLastName("Override")).thenReturn(new Owner("Test", "Override"));
            return mock;
        }
    }

    @Autowired
    OwnerService ownerService; // Recibe el bean inyectado por @TestConfiguration.

    @Test
    @DisplayName("🧪 Verificar bean sobrescrito por @TestConfiguration")
    void testBeanOverride() {
        Owner found = ownerService.findByLastName("Override");
        assertEquals("Test", found.getFirstName());
    }
}

