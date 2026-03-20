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
 * <h1>TEORÍA: Consumo de API como Cliente Real (TestRestTemplate)</h1>
 * 
 * <p><b>Qué hace:</b> Proporciona una variante de <code>RestTemplate</code> diseñada 
 * específicamente para realizar peticiones HTTP reales contra el servidor local 
 * levantado durante el test.</p>
 * 
 * <p><b>Por qué existe:</b> A diferencia de MockMVC (que simula el flujo interno), 
 * <code>TestRestTemplate</code> pasa por todo el stack de red, filtros de seguridad 
 * y motor de serialización real, garantizando la fidelidad máxima del test.</p>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Sección 4 - L2: Cliente HTTP con TestRestTemplate")
class L2_TestRestTemplateTheory {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * <h2>DEMO: Petición HTTP externa sobre servidor local</h2>
     * <p>Verificamos que el endpoint REST responde correctamente cuando se le 
     * consulta mediante un canal de red real.</p>
     */
    @Test
    @DisplayName("🧪 Demo 10: Invocación de API real sin Mocking")
    void testGetVetsRealHttp() {
        ResponseEntity<Vet[]> response = restTemplate.getForEntity("/api/vets", Vet[].class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody(), "El cuerpo de la respuesta no debe estar vacío");
    }
}
