package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.VetRestController;
import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * <h1>TEORÍA: WebTestClient en Spring MVC</h1>
 * 
 * <p>¿Y si pudiéramos tener la API fluida de un cliente HTTP real pero sin el coste de levantar 
 * un servidor Tomcat en un puerto real? ¡Podemos!</p>
 * 
 * <p>Aunque <b>WebTestClient</b> nació con WebFlux, Spring permite usarlo en proyectos MVC 
 * convencionales. Cuando lo usamos junto a {@code @WebMvcTest}, Spring configura internamente 
 * el cliente para que "dispare" contra MockMvc en lugar de contra la red.</p>
 * 
 * <p><b>Ventajas:</b></p>
 * <ul>
 *     <li><b>Sintaxis Moderna:</b> API fluida y declarativa (mucho más legible que los .andExpect de MockMvc).</li>
 *     <li><b>Velocidad:</b> Seguimos sin levantar un servidor real (usa MockMvc por debajo).</li>
 *     <li><b>Consistencia:</b> El mismo código de test te servirá si algún día migras a WebFlux.</li>
 *     <li><b>Poder de aserción:</b> Integración nativa con JsonPath de forma muy natural.</li>
 * </ul>
 */
@WebMvcTest(VetRestController.class)
@AutoConfigureWebTestClient
@DisplayName("Sección 2 - L7: WebTestClient en MVC")
class L7_WebTestClientMvcTheory {

    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private VetRepository vetRepository;

    /**
     * <h2>DEMO: Fluent API con WebTestClient</h2>
     * <p>Observa cómo las aserciones son mucho más legibles y encadenadas.</p>
     */
    @Test
    @DisplayName("🧪 WebTestClient: Sintaxis fluida sobre MockMvc")
    void testWithWebTestClient() {
        // GIVEN
        when(vetRepository.findAll()).thenReturn(List.of(new Vet("House", "MD")));

        // WHEN / THEN
        webTestClient.get().uri("/api/vets")
            .exchange() // Realiza la petición
            .expectStatus().isOk() // Aserción de estado
            .expectBody() // Aserción de cuerpo
            .jsonPath("$[0].firstName").isEqualTo("House")
            .jsonPath("$.length()").isEqualTo(1);
    }
}
