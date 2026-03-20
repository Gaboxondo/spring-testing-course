package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.OwnerController;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * <h1>TEORÍA: Formularios y Sustitución de Beans (@MockBean)</h1>
 * 
 * <p><b>Qué hace:</b> Enseña cómo simular el envío de datos de un formulario web 
 * (POST) y cómo "puentear" servicios reales con mocks integrados en Spring.</p>
 * 
 * <p><b>Por qué existe:</b> Un controlador MVC suele depender de servicios de negocio. 
 * <code>@MockBean</code> permite que Spring inyecte automáticamente un mock de Mockito 
 * en el controlador que estamos testeando, manteniendo el aislamiento.</p>
 * 
 * <h2>Envío de Parámetros:</h2>
 * <p>Utilizamos el método <code>.param("key", "value")</code> para simular los 
 * input fields de un formulario HTML real.</p>
 */
@WebMvcTest(OwnerController.class)
@DisplayName("Sección 2 - L3: MockBean y Parámetros HTTP")
class L3_FormParametersTheory {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    /**
     * <h2>DEMO: Carga de formularios de búsqueda</h2>
     * <p>Validamos que la ruta GET prepara el modelo y devuelve la vista de búsqueda.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: Verificación de atributos del modelo")
    void testInitFindForm() throws Exception {
        mockMvc.perform(get("/owners/find"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/findOwners"))
            .andExpect(model().attributeExists("owner"));
    }

    /**
     * <h2>DEMO: Envío de POST con Redirección</h2>
     * <p>Simulamos el alta de un usuario y comprobamos que el controlador responde 
     * con una redirección HTTP 3xx típica tras un guardado exitoso.</p>
     */
    @Test
    @DisplayName("🧪 Demo 5: Simulación de POST exitoso")
    void testProcessCreationFormSuccess() throws Exception {
        mockMvc.perform(post("/owners/new")
                .param("firstName", "John")
                .param("lastName", "Doe"))
            .andExpect(status().is3xxRedirection());
    }
}
