package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.IndexController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Sección 2 - L2: MockMVC con Slice Testing (@WebMvcTest).
 * 
 * En lugar de un setup manual, Spring Boot nos ofrece @WebMvcTest.
 * Activa la magia de Spring para inyectar un MockMvc ya configurado con 
 * el contexto web necesario para el controlador indicado.
 */
@WebMvcTest(IndexController.class)
@DisplayName("Sección 2 - L2: MockMVC con @WebMvcTest")
class L2_MockMVCWebContextTheory {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("🧪 Probar GET /index usando el contexto de Spring")
    void testIndexWebMvc() throws Exception {
        mockMvc.perform(get("/index.html"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
    }
}

