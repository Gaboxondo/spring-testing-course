package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.OwnerController;
import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Sección 2 - L3: Parámetros de Formulario y @MockBean.
 * 
 * ¿Cómo testear si un controlador usa servicios externos?
 * Usamos @MockBean. Reemplaza el Bean real en el contexto por un Mock de Mockito.
 */
@WebMvcTest(OwnerController.class)
@DisplayName("Sección 2 - L3: Parámetros y MockBean")
class L3_FormParametersTheory {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OwnerService ownerService; // Spring lo crea y lo inyecta en el controlador del test.

    @Test
    @DisplayName("🧪 Probar GET de un formulario")
    void testInitFindForm() throws Exception {
        mockMvc.perform(get("/owners/find"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/findOwners"))
            .andExpect(model().attributeExists("owner"));
    }

    @Test
    @DisplayName("🧪 Probar POST de creación (Redirección)")
    void testProcessCreationFormSuccess() throws Exception {
        // Al enviar un POST, podemos simular los campos del formulario.
        mockMvc.perform(post("/owners/new")
                .param("firstName", "John")
                .param("lastName", "Doe"))
            .andExpect(status().is3xxRedirection()); // Se espera una redirección al ID
    }
}

