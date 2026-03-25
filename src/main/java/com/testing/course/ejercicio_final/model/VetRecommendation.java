package com.testing.course.ejercicio_final.model;

import java.util.List;

/**
 * <h1>MODELO: VetRecommendation</h1>
 * 
 * <p>Representa una recomendación de veterinario enriquecida con alertas de salud externas.</p>
 */
public class VetRecommendation {
    private String vetName;
    private List<String> healthAlerts;
    private String recommendationLevel;

    public VetRecommendation() {}

    public VetRecommendation(String vetName, List<String> healthAlerts, String recommendationLevel) {
        this.vetName = vetName;
        this.healthAlerts = healthAlerts;
        this.recommendationLevel = recommendationLevel;
    }

    public String getVetName() { return vetName; }
    public void setVetName(String vetName) { this.vetName = vetName; }
    public List<String> getHealthAlerts() { return healthAlerts; }
    public void setHealthAlerts(List<String> healthAlerts) { this.healthAlerts = healthAlerts; }
    public String getRecommendationLevel() { return recommendationLevel; }
    public void setRecommendationLevel(String recommendationLevel) { this.recommendationLevel = recommendationLevel; }
}
