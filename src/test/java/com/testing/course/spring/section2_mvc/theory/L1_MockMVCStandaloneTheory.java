package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.IndexController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Sección 2 - L1: MockMVC Standalone Setup.
 * 
 * ¿Cómo probamos un controlador de Spring MVC sin arrancar el servidor (Tomcat)?
 * Usamos MockMVC. El modo 'Standalone' es el más ligero: solo carga EL controlador.
 */
@DisplayName("Sección 2 - L1: MockMVC Standalone")
class L1_MockMVCStandaloneTheory {

    IndexController indexController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
        // Configuramos MockMvc manualmente pasándole el controlador real.
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    @DisplayName("🧪 Probar GET /index")
    void testIndex() throws Exception {
        // Ejecutamos la petición simulada.
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())         // HTTP 200
            .andExpect(view().name("index"));  // Debe devolver la vista "index"
    }

    @Test
    @DisplayName("🧪 Probar error 500 en /oups")
    void testOups() throws Exception {
        // Al lanzar una excepción no capturada en standalone, MockMvc espera un Internal Server Error.
        mockMvc.perform(get("/oups"))
            .andExpect(status().isInternalServerError());
    }
}

