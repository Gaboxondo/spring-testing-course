package com.testing.course.ejercicio_final.controller;

import com.testing.course.ejercicio_final.model.VetRecommendation;
import com.testing.course.ejercicio_final.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>CONTROLADOR: RecommendationController</h1>
 * 
 * <p>Expone el endpoint final de recomendación.</p>
 */
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{vetId}")
    public VetRecommendation getRecommendation(@PathVariable Long vetId, @RequestParam String species) {
        return recommendationService.getRecommendationForVet(vetId, species);
    }

    @GetMapping("/audit/{vetId}")
    public long getAuditCount(@PathVariable Long vetId) {
        return recommendationService.getRequestCountForVet(vetId);
    }
}
