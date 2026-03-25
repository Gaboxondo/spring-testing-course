package com.testing.course.ejercicio_final.solutions.unit;

import com.testing.course.ejercicio_final.controller.RecommendationController;
import com.testing.course.ejercicio_final.model.VetRecommendation;
import com.testing.course.ejercicio_final.service.RecommendationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecommendationController.class)
@DisplayName("Solución: RecommendationController (Web Layer Test)")
class RecommendationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RecommendationService recommendationService;

    @Test
    @DisplayName("🧪 Debe retornar el JSON correcto del servicio")
    void shouldReturnRecommendation() throws Exception {
        VetRecommendation rec = new VetRecommendation("Vet Name", List.of("Alert"), "CAUTION");
        when(recommendationService.getRecommendationForVet(1L, "dog")).thenReturn(rec);

        mockMvc.perform(get("/api/recommendations/1?species=dog"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vetName").value("Vet Name"))
                .andExpect(jsonPath("$.recommendationLevel").value("CAUTION"));
    }
}
