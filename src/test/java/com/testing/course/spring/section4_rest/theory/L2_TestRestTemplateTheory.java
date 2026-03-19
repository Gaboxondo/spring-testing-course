package com.testing.course.spring.section4_rest.theory;

import com.testing.course.model.Vet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Sección 4 - L6: TestRestTemplate (HTTP Real).
 * 
 * ¿Quieres probar TODO el flujo real incluyendo el servidor (Tomcat)?
 * Levantamos un servidor en un puerto aleatorio y usamos TestRestTemplate 
 * para hacer peticiones externas reales al servidor interno.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Sección 4 - L6: TestRestTemplate Real HTTP")
class L2_TestRestTemplateTheory {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName("🧪 Probar la API REST como cliente externo")
    void testGetVetsRealHttp() {
        // En este test, NO hay MockMvc ni nada simulado. Es una petición HTTP real.
        ResponseEntity<Vet[]> response = restTemplate.getForEntity("/api/vets", Vet[].class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // El resultado dependerá de los datos inyectados por defecto en tu DB.
    }
}

