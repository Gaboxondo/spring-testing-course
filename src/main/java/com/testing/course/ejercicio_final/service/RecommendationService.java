package com.testing.course.ejercicio_final.service;

import com.testing.course.ejercicio_final.client.PetSafetyClient;
import com.testing.course.ejercicio_final.model.VetRecommendation;
import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <h1>SERVICIO: RecommendationService</h1>
 * 
 * <p>Orquesta la lógica de negocio combinando datos locales (Vets) y externos (Alertas).</p>
 */
@Service
public class RecommendationService {

    private final VetRepository vetRepository;
    private final PetSafetyClient petSafetyClient;

    public RecommendationService(VetRepository vetRepository, PetSafetyClient petSafetyClient) {
        this.vetRepository = vetRepository;
        this.petSafetyClient = petSafetyClient;
    }

    /**
     * Genera una recomendación para un veterinario específico basado en alertas actuales.
     */
    public VetRecommendation getRecommendationForVet(Long vetId, String petSpecies) {
        Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new IllegalArgumentException("Veterinario no encontrado"));

        List<String> alerts = petSafetyClient.getAlertsForSpecies(petSpecies);

        String level = alerts.isEmpty() ? "HIGH" : "CAUTION";
        
        return new VetRecommendation(vet.getFirstName() + " " + vet.getLastName(), alerts, level);
    }
}
