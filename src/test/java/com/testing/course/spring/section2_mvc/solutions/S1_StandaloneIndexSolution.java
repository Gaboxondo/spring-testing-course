package com.testing.course.spring.section2_mvc.solutions;

import com.testing.course.controller.IndexController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Solución L6: Setup Standalone del Índice.
 */
class S1_StandaloneIndexSolution {

    IndexController indexController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // SOLUCIÓN:
        indexController = new IndexController();
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    void testIndexUrl() throws Exception {
        // SOLUCIÓN:
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
    }
}

