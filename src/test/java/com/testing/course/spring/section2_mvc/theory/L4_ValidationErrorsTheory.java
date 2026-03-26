package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.OwnerController;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * <h1>TEORÍA: Validación de Entrada en la Capa Web</h1>
 * 
 * <p><b>Qué hace:</b> Comprueba el comportamiento del controlador cuando recibe 
 * datos que no cumplen las reglas de anotación (Validation API @NotNull, @Size).</p>
 * 
 * <p><b>Por qué existe:</b> Es fundamental asegurar que las reglas de negocio 
 * declaradas en las entidades se aplican correctamente en la frontera HTTP, 
 * evitando que datos corruptos lleguen a la capa de servicio.</p>
 * 
 * <h2>Detección de Errores:</h2>
 * <p>MockMVC permite usar <code>model().hasErrors()</code> para verificar que 
 * el <code>BindingResult</code> de Spring ha capturado las violaciones de integridad.</p>
 */
@WebMvcTest(OwnerController.class)
@DisplayName("Sección 2 - L4: Gestión de Errores en Formularios")
class L4_ValidationErrorsTheory {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OwnerService ownerService;

    /**
     * <h2>DEMO: Re-visualización de formulario tras error</h2>
     * <p>Al enviar campos obligatorios vacíos, el controlador debe devolver 
     * el mismo formulario con los mensajes de error inyectados en el modelo.</p>
     */
    @Test
    @DisplayName("🧪 Demo 6: Verificación de errores de validación (POST)")
    void testProcessCreationFormFail() throws Exception {
        mockMvc.perform(post("/owners/new")
                .param("firstName", "") // Inválido: @NotEmpty
                .param("lastName", ""))
            .andExpect(status().isOk()) // Vuelve al formulario (no hay redirect)
            .andExpect(model().hasErrors())
            //.andExpect( jsonPath( "$.roles",hasSize(2) ) ) se ve en la seccion 4
            .andExpect(view().name("owners/createOrUpdateOwnerForm"));
    }
}
