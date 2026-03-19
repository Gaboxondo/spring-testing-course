package com.testing.course.spring.section6_properties.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Solución L4: Propiedades con @Value.
 */
@ExtendWith(SpringExtension.class)
@DisplayName("Solución L4: @Value con PropertySource")
class S1_PropertiesSolution {

    @Configuration
    // SOLUCIÓN:
    @PropertySource("classpath:exercise.properties")
    static class TestConfig {
    }

    // SOLUCIÓN:
    @Value("${app.name}")
    String appName;

    @Test
    void testValueInjection() {
        // SOLUCIÓN:
        assertEquals("TestingCourse", appName);
    }
}

