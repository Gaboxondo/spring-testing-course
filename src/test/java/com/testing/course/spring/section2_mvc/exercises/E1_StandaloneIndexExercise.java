package com.testing.course.spring.section2_mvc.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.controller.IndexController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Ejercicio L5: Setup Standalone del Índice.
 * 
 * Basado en: Section 2 - L1_MockMVCStandaloneTheory.
 * 
 * OBJETIVO: Configurar MockMvc manualmente y testear el IndexController.
 */
@Disabled("Ejercicio pendiente de resolver")
class E1_StandaloneIndexExercise {

    IndexController indexController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
        // TODO: Configura mockMvc usando MockMvcBuilders.standaloneSetup
        // mockMvc = ...
    }

    @Test
    void testIndexUrl() throws Exception {
        // TODO: Ejecuta una petición GET a "/" y comprueba status 200 y vista "index".
    }
}


