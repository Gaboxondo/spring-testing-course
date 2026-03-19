package com.testing.course.spring.section1_context.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.spring.config.HearingConfig;
import com.testing.course.spring.service.HearingInterpreter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio L8: El Desafío Yanny (Perfiles).
 * 
 * Basado en: Section 1 - L4_ProfilesTheory.
 * 
 * OBJETIVO: Activar el perfil "yanny" para ignorar el @Primary de Laurel.
 */
@ActiveProfiles("yanny") // TODO 1: Activa el perfil "yanny"
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@Disabled("Ejercicio pendiente de resolver")
class E2_ProfileExercise {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    void testHearingYanny() {
        // TODO 2: Comprueba que el resultado contiene "Yanny".
    }
}


