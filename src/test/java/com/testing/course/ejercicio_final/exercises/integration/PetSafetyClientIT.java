package com.testing.course.ejercicio_final.exercises.integration;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.testing.course.ejercicio_final.client.PetSafetyClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SpringBootTest
@DisplayName("Ejercicio: PetSafetyClient (Integration Test)")
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
    @Disabled("TODO: Configurar WireMockExtension y probar comunicación real")
    void shouldFetchAlertsFromWiremock() {
        // TODO: Stubear Wiremock, llamar al cliente y verificar
    }
}
