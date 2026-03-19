package com.testing.course.spring.section1_context.theory;

import com.testing.course.spring.config.HearingConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Sección 1 - L5: Propiedades en Testing (@TestPropertySource).
 * 
 * Podemos inyectar valores desde archivos de propiedades específicos del Test 
 * para simular configuraciones sin cambiar application.properties.
 */
@TestPropertySource(properties = {"testing.property=TestValue"})
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L5: Inyección de Propiedades")
class L5_TestPropertiesTheory {

    @Value("${testing.property}")
    String testProperty;

    @Test
    @DisplayName("🧪 Verificar la inyección de propiedades inline")
    void testPropertyInjection() {
        assertEquals("TestValue", testProperty);
    }
}

