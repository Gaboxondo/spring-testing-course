package com.testing.course.spring.section2_mvc.exercises;

import com.testing.course.controller.OwnerController;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Ejercicio L7: Validación de Formularios en MVC.
 * 
 * Basado en: Section 2 - L4_ValidationErrorsTheory.
 * 
 * OBJETIVO: Testear que el sistema detecta errores al enviar datos vacíos.
 */
@WebMvcTest(OwnerController.class)
class L7_FormValidationExercise {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OwnerService ownerService; // Necesario para cargar el controlador del test.

    @Test
    void testFormPostInvalidData() throws Exception {
        // TODO: Envía un POST a "/owners/new" con campos lastName vacío y firstName vacío.
        // TODO: Comprueba que el status sea 200 (Vuelve al formulario).
        // TODO: Comprueba que el modelo contenga errores de validación.
        // TODO: Comprueba que la vista se mantenga en "owners/createOrUpdateOwnerForm".
    }
}
