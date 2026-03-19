package com.testing.course.spring.section4_rest.theory;

import com.testing.course.controller.VetRestController;
import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.DisplayName;
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
 * Sección 4 - L1: Probar REST con JsonPath.
 * 
 * ¿Cómo validamos que el JSON devuelto por una API REST es correcto?
 * Usamos JsonPath. Es como CSS Selectors pero para JSON.
 */
@WebMvcTest(VetRestController.class)
@DisplayName("Sección 4 - L1: REST con JsonPath")
class L1_JsonPathTheory {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VetRepository vetRepository;

    @Test
    @DisplayName("🧪 Verificar el contenido del JSON")
    void testGetVetsJson() throws Exception {
        // Configuramos el mock para devolver datos reales.
        Vet vet = new Vet("House", "M.D.");
        when(vetRepository.findAll()).thenReturn(List.of(vet));

        mockMvc.perform(get("/api/vets"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            // Usamos $[index] para navegar por la lista devuelta.
            .andExpect(jsonPath("$", hasSize(1))) 
            .andExpect(jsonPath("$[0].firstName", is("House")))
            .andExpect(jsonPath("$[0].lastName", is("M.D.")));
    }
}

