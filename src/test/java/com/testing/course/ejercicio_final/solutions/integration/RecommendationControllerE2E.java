package com.testing.course.ejercicio_final.solutions.integration;

import com.testing.course.ejercicio_final.model.VetRecommendation;
import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Solución: Recommendation E2E (Full Integration)")
class RecommendationControllerE2E {

    @RegisterExtension
    static WireMockExtension apiServer = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("pet.safety.api.url", apiServer::baseUrl);
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @MockitoBean
    private VetRepository vetRepository;

    @Test
    @DisplayName("🧪 Flujo E2E: Controller -> Service -> RepoMock + ClientReal -> Wiremock")
    void fullE2EFlow() {
        // MOCK Repo
        Vet vet = new Vet("Santi", "Muni");
        when(vetRepository.findById(10L)).thenReturn(Optional.of(vet));

        // STUB Wiremock
        apiServer.stubFor(get(urlEqualTo("/alerts?species=horse"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[]")));

        // CALL Controller
        VetRecommendation result = restTemplate.getForObject("/api/recommendations/10?species=horse", VetRecommendation.class);

        // VERIFY
        assertEquals("Santi Muni", result.getVetName());
        assertEquals("HIGH", result.getRecommendationLevel());
        assertTrue(result.getHealthAlerts().isEmpty());
    }

    private void assertTrue(boolean condition) {
        org.junit.jupiter.api.Assertions.assertTrue(condition);
    }
}
