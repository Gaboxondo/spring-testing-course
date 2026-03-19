package com.testing.course.spring.section3_boot.exercises;

import com.testing.course.service.VetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio L2: Integración Total en la Clínica.
 * 
 * Basado en: Section 3 - L1_SpringBootTestTheory.
 * 
 * OBJETIVO: Cargar el contexto completo de Spring Boot para probar servicios reales.
 */
@SpringBootTest // TODO: Añade la anotación necesaria para levantar el contexto de Boot
class E1_BootIntegrationExercise {

    @Autowired // TODO: Inyecta el VetService
    VetService vetService;

    @Test
    void testVetServiceIsReal() {
        // TODO: Comprueba que el service no es null y que devuelve veterinarios.
    }
}

