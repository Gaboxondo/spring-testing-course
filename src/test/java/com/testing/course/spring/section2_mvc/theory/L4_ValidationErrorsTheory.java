package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.OwnerController;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Sección 2 - L4: Errores de Validación.
 * 
 * Si un campo es obligatorio (@NotNull) y lo enviamos vacío, @Valid de Spring 
 * devuelve errores en el BindingResult.
 */
@WebMvcTest(OwnerController.class)
@DisplayName("Sección 2 - L4: Errores de Validación en MVC")
class L4_ValidationErrorsTheory {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OwnerService ownerService;

    @Test
    @DisplayName("🧪 Probar fallo de validación al enviar campos vacíos")
    void testProcessCreationFormFail() throws Exception {
        // Al enviar campos vacíos que en el 'model' tienen @NotNull/@NotEmpty...
        mockMvc.perform(post("/owners/new")
                .param("firstName", "")
                .param("lastName", ""))
            .andExpect(status().isOk()) // El servidor responde 200 porque vuelve al formulario.
            .andExpect(model().hasErrors()) // El modelo contiene errores de validación.
            .andExpect(view().name("owners/createOrUpdateOwnerForm"));
    }
}
