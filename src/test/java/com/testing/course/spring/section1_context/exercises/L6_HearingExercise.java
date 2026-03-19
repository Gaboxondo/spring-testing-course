package com.testing.course.spring.section1_context.exercises;

import com.testing.course.spring.config.HearingConfig;
import com.testing.course.spring.service.HearingInterpreter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio L6: El Contexto de Spring Veterinario.
 * 
 * Basado en: Section 1 - L1_SpringContextTheory.
 * 
 * OBJETIVO: Cargar el contexto real de Spring para probar el HearingInterpreter.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class}) // TODO: Configura la clase HearingConfig
class L6_HearingExercise {

    @Autowired
    HearingInterpreter hearingInterpreter; // TODO: Inyecta el bean con @Autowired

    @Test
    void testHearingLaurel() {
        // TODO: Comprueba que el resultado contiene "Laurel" (por defecto).
    }
}
