package com.testing.course.spring.section6_properties.exercises;

import org.junit.jupiter.api.Disabled;
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
 * Ejercicio L3: Propiedades con @Value.
 * 
 * OBJETIVO: Crea una clase interna de configuración (@Configuration) que cargue 
 * un archivo de propiedades ".yaml" desde el classpath y comprueba 
 * que @Value inyecta el valor correctamente.
 */

// TODO: Crea un archivo "exercise.yaml" en src/test/resources con las propiedades correspondientes
@ExtendWith(SpringExtension.class)
@DisplayName("Ej L3: Test de @Value con PropertySource")
@Disabled("Ejercicio pendiente de resolver")
class E1_PropertiesExercise {

    @Configuration
    // TODO: Usa @PropertySource para apuntar a "classpath:exercise.yaml" y usa el YamlPropertySourceFactory
    static class TestConfig {
    }

    // TODO: Inyecta el valor de "app.name" usando @Value
    String appName;

    @Test
    void testValueInjection() {
        // TODO: Comprueba que appName vale "TestingCourse"
        // assertEquals("TestingCourse", appName);
    }
}

