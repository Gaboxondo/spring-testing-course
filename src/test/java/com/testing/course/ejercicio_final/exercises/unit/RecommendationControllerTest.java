package com.testing.course.ejercicio_final.exercises.unit;

import com.testing.course.ejercicio_final.controller.RecommendationController;
import com.testing.course.ejercicio_final.service.RecommendationService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RecommendationController.class)
@DisplayName("Ejercicio: RecommendationController (Unit Test)")
class RecommendationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RecommendationService recommendationService;

    @Test
    @Disabled("TODO: Validar el JSON de respuesta")
    void shouldReturnRecommendation() throws Exception {
        // TODO: Simular respuesta del servicio y validar con jsonPath
    }
}
