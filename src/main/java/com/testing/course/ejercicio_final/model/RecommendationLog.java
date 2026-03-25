package com.testing.course.ejercicio_final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecommendationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vetId;
    private String species;

    public RecommendationLog() {}

    public RecommendationLog(Long vetId, String species) {
        this.vetId = vetId;
        this.species = species;
    }

    public Long getId() { return id; }
    public Long getVetId() { return vetId; }
    public String getSpecies() { return species; }
}
