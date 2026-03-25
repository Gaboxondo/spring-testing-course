package com.testing.course.ejercicio_final.solutions.integration;

import com.testing.course.ejercicio_final.client.PetSafetyClient;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Solución: PetSafetyClient (Integration Test with Wiremock)")
class PetSafetyClientIT {

    @RegisterExtension
    static WireMockExtension wireMockServer = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("pet.safety.api.url", wireMockServer::baseUrl);
    }

    @Autowired
    private PetSafetyClient petSafetyClient;

    @Test
    @DisplayName("🧪 Interacción real HTTP contra Wiremock")
    void shouldFetchAlertsFromWiremock() {
        wireMockServer.stubFor(get(urlEqualTo("/alerts?species=bird"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[\"Avian Flu\"]")));

        List<String> alerts = petSafetyClient.getAlertsForSpecies("bird");

        assertEquals(1, alerts.size());
        assertEquals("Avian Flu", alerts.get(0));
    }
}
