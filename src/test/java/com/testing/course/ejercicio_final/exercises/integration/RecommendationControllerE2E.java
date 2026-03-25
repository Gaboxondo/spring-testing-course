package com.testing.course.ejercicio_final.exercises.integration;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Ejercicio: Recommendation E2E")
class RecommendationControllerE2E {

    @RegisterExtension
    static WireMockExtension wireMockApi = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("pet.safety.api.url", wireMockApi::baseUrl);
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @MockitoBean
    private VetRepository vetRepository;

    @Test
    @Disabled("TODO: Flujo total Controller -> Service -> Client -> Wiremock")
    void fullE2EFlow() {
        // TODO: Simular repositorio y Wiremock, luego llamar via restTemplate
    }
}
