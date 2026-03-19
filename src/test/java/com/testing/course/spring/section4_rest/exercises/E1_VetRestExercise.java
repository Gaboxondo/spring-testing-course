package com.testing.course.spring.section4_rest.exercises;

import com.testing.course.controller.VetRestController;
import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * Ejercicio L2: El API REST de Veterinarios.
 * 
 * Basado en: Section 4 - L1_JsonPathTheory.
 * 
 * OBJETIVO: Testear que el endpoint devuelve un JSON con los datos esperados.
 */
@WebMvcTest(VetRestController.class)
class E1_VetRestExercise {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VetRepository vetRepository; // TODO: Mockea el repositorio

    @Test
    void testGetVetsJson() throws Exception {
        // TODO: Configura el mock para quefindAll() devuelva una lista con un Vet("James", "Herriot").
        // TODO: Llama a "/api/vets" y comprueba:
        // - Status 200
        // - Content type JSON
        // - El primer elemento del JSON tiene firstName "James" usando jsonPath.
    }
}

