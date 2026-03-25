package com.testing.course.spring.section4_rest.theory;

import com.testing.course.controller.VetRestController;
import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * <h1>TEORÍA: Validación de APIs REST con JsonPath</h1>
 * 
 * <p><b>Qué hace:</b> Permite inspeccionar la estructura y el contenido de un 
 * cuerpo de respuesta JSON utilizando una sintaxis de consulta similar a XPath.</p>
 * 
 * <p><b>Por qué existe:</b> En servicios REST, no basta con recibir un HTTP 200. 
 * Es vital verificar que los datos viajan en el formato esperado (nombres de campos, 
 * tipos de datos, longitud de listas) sin necesidad de deserializar el objeto a Java.</p>
 * 
 * <h2>Sintaxis Básica:</h2>
 * <ul>
 *   <li><b>$ :</b> Representa la raíz del documento JSON.</li>
 *   <li><b>$.campo :</b> Accede a una propiedad de un objeto.</li>
 *   <li><b>$[n] :</b> Accede al elemento de un array por su índice.</li>
 * </ul>
 */
@WebMvcTest(VetRestController.class)
@DisplayName("Sección 4 - L1: Navegación JSON con JsonPath")
class L1_JsonPathTheory {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VetRepository vetRepository;

    /**
     * <h2>DEMO: Verificación de lista de recursos</h2>
     * <p>Comprobamos que la API devuelve un array con un único veterinario y 
     * que sus atributos coinciden con los del mock.</p>
     */
    @Test
    @DisplayName("🧪 Demo 9: Validar array y campos anidados en JSON")
    void testGetVetsJson() throws Exception {
        Vet vet = new Vet("House", "M.D.");
        when(vetRepository.findAll()).thenReturn(List.of(vet));

        mockMvc.perform(get("/api/vets"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$", hasSize(1))) 
            .andExpect(jsonPath("$[0].firstName", is("House")))
            .andExpect(jsonPath("$[0].lastName", is("M.D.")));
    }
}
