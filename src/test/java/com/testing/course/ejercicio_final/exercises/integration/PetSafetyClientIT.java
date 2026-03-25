package com.testing.course.ejercicio_final.exercises.integration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Ejercicio: PetSafetyClient (Integration Test)")
class PetSafetyClientIT {

    // TODO: Configurar Wiremock (RegisterExtension)
    // TODO: Configurar URL dinámica (DynamicPropertySource)
    // TODO: Inyectar el cliente

    @Test
    @Disabled("TODO: Realizar comunicación real con Wiremock")
    void shouldFetchAlertsFromWiremock() {
        // TODO: Stubear Wiremock y verificar que el cliente recibe los datos
    }
}
