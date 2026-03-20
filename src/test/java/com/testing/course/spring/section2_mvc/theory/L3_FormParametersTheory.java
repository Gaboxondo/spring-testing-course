package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.OwnerController;
import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * <h1>TEORÍA: Aislamiento Web y Sustitución de Capas (@MockitoBean)</h1>
 * 
 * <p><b>Qué hace:</b> Explica cómo testear controladores MVC de forma aislada, 
 * sustituyendo las dependencias reales (servicios) por simulacros controlados.</p>
 * 
 * <p><b>Por qué existe:</b> Al usar <code>@WebMvcTest</code>, Spring Boot <u>NO</u> 
 * carga los servicios ni los repositorios. Si el controlador los necesita y no los 
 * proporcionamos, el contexto de Spring fallará al arrancar (unsatisfied dependency).</p>
 * 
 * <h2>El Superpoder de @MockitoBean:</h2>
 * <ul>
 *   <li>Crea un Mock de Mockito y lo registra en el ApplicationContext del test.</li>
 *   <li>Sustituye cualquier implementación real por este simulacro.</li>
 *   <li>Permite definir <b>stubs</b> (respuestas programadas) para que el controlador 
 *   pueda continuar su flujo lógico sin base de datos real.</li>
 * </ul>
 */
@WebMvcTest(OwnerController.class)
@DisplayName("Sección 2 - L3: Aislamiento MVC y Mocking de Servicios")
class L3_FormParametersTheory {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Sin @MockitoBean, el test daría error ya que OwnerController requiere 
     * inyectar un OwnerService en su constructor que @WebMvcTest no levanta.
     */
    @MockitoBean
    private OwnerService ownerService;

    /**
     * <h2>DEMO: Mocking y Redirección Dinámica</h2>
     * <p>En este ejemplo simulamos que el servicio 'asigna un ID' al guardar. 
     * Si no hiciéramos stubbing, <code>owner.getId()</code> devolvería null y 
     * la redirección fallaría en las expectativas del test.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: Simulación de flujo POST -> Service -> Redirect")
    void testProcessCreationFormSuccess() throws Exception {
        // GIVEN: Programamos el mock para que "asigne" un ID al objeto cuando se llame a save()
        doAnswer(invocation -> {
            Owner owner = invocation.getArgument(0);
            owner.setId(1L); // Simulamos la generación de ID de la DB
            return null;
        }).when(ownerService).save(any(Owner.class));

        // WHEN & THEN
        mockMvc.perform(post("/owners/new")
                .param("firstName", "John")
                .param("lastName", "Doe"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/owners/1")); // Verificamos que usó el ID de nuestro Stub
    }

    /**
     * <h2>DEMO: Verificación de Vista y Modelo</h2>
     * <p>Incluso sin interactuar con el servicio, necesitamos que el Service 
     * esté en el contexto (aunque sea como mock) para que el controlador sea estable.</p>
     */
    @Test
    @DisplayName("🧪 Demo 5: Carga básica de formulario GET")
    void testInitFindForm() throws Exception {
        mockMvc.perform(get("/owners/find"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/findOwners"))
            .andExpect(model().attributeExists("owner"));
    }
}
