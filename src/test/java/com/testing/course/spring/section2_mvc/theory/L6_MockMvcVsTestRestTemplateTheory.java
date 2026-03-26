package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <h1>TEORÍA: ¿MockMvc o TestRestTemplate?</h1>
 * 
 * <p><b>Contexto Actual:</b> En el desarrollo moderno de Spring Boot, el modelo tradicional 
 * de Model y View para devolver HTML ha sido desplazado por APIs REST que devuelven JSON. 
 * Por ello, testing de controladores ya no solo va de "vistas", sino de "contratos de red".</p>
 * 
 * <p><b>Diferencia Clave:</b></p>
 * <ul>
 *     <li><b>MockMvc:</b> Testea el controlador "desde dentro". No levanta servidor HTTP. 
 *     Es rápido y permite mockear servicios fácilmente para ver cómo el Controller 
 *     reacciona ante distintos retornos.</li>
 *     <li><b>TestRestTemplate:</b> Testea la aplicación "desde fuera" como un cliente real. 
 *     Requiere levantar un puerto real. Valida serialización real y filtros de red.</li>
 * </ul>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayName("Sección 2 - L6: MockMvc vs TestRestTemplate")
class L6_MockMvcVsTestRestTemplateTheory {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockitoBean
    private VetRepository vetRepository;

    /**
     * <h2>DEMO: Test Interno con MockMvc</h2>
     * <p>Simulamos la petición sin pasar por la red. Es ideal para lógica de negocio 
     * en el controlador y respuestas rápidas.</p>
     */
    @Test
    @DisplayName("🧪 MockMvc: Testeo interno (Mocked)")
    void testWithMockMvc() throws Exception {
        when(vetRepository.findAll()).thenReturn(List.of(new Vet("House", "MD")));

        mockMvc.perform(get("/api/vets"))
            .andExpect(status().isOk());
    }

    /**
     * <h2>DEMO: Test Externo con TestRestTemplate</h2>
     * <p>Realizamos una petición HTTP real contra el servidor levantado. 
     * Garantiza que el puerto está abierto y el JSON se envía físicamente por el cable.</p>
     */
    @Test
    @DisplayName("🧪 TestRestTemplate: Testeo externo (Real HTTP)")
    void testWithRestTemplate() {
        when(vetRepository.findAll()).thenReturn(List.of(new Vet("House", "MD")));

        ResponseEntity<Vet[]> response = restTemplate.getForEntity("/api/vets", Vet[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Vet[] body = response.getBody();
        assertNotNull(body, "El cuerpo de la respuesta no debería ser nulo");
        assertEquals(1, body.length);
        assertEquals("House", body[0].getFirstName());
    }
}
