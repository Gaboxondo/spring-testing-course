package com.testing.course.spring.section4_rest.solutions;

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
 * Solución L3: El API REST de Veterinarios.
 */
@WebMvcTest(VetRestController.class)
class S1_VetRestSolution {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VetRepository vetRepository;

    @Test
    void testGetVetsJson() throws Exception {
        // SOLUCIÓN:
        Vet vet = new Vet("James", "Herriot");
        when(vetRepository.findAll()).thenReturn(List.of(vet));

        mockMvc.perform(get("/api/vets"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].firstName", is("James")));
    }
}

