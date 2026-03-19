package com.testing.course.spring.section2_mvc.solutions;

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
 * Solución L8: Validación de Formularios en MVC.
 */
@WebMvcTest(OwnerController.class)
class S2_FormValidationSolution {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OwnerService ownerService;

    @Test
    void testFormPostInvalidData() throws Exception {
        // SOLUCIÓN:
        mockMvc.perform(post("/owners/new")
                .param("firstName", "")
                .param("lastName", ""))
            .andExpect(status().isOk())
            .andExpect(model().hasErrors())
            .andExpect(view().name("owners/createOrUpdateOwnerForm"));
    }
}

