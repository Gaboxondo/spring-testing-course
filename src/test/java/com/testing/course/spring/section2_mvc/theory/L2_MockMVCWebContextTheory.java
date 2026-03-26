package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.IndexController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * <h1>TEORÍA: Tests de Capa Web (@WebMvcTest)</h1>
 * 
 * <p><b>Qué hace:</b> Activa un "Slice Test" que carga únicamente los componentes 
 * de la capa web de Spring (filtros, seguridad, controladores) ignorando el resto.</p>
 * 
 * <p><b>Por qué existe:</b> Proporciona un equilibrio entre velocidad y realidad. 
 * A diferencia de <code>standaloneSetup</code>, aquí Spring gestiona la inyección 
 * y configuraciones complejas (como validadores globales o <b>convertidores JSON</b>) 
 * automáticamente.</p>
 * 
 * <h2>Diferencia con @SpringBootTest:</h2>
 * <p><code>@WebMvcTest</code> no arranca el servidor real ni escanea servicios 
 * o repositorios, pero es ideal para validar contratos de <b>APIs REST</b>.</p>
 */
@WebMvcTest(IndexController.class)
@DisplayName("Sección 2 - L2: MockMVC con Inyección de Contexto")
class L2_MockMVCWebContextTheory {

    @Autowired
    private MockMvc mockMvc;

    /**
     * <h2>DEMO: Petición mediante ApplicationContext</h2>
     * <p>Comprobamos que Spring es capaz de localizar el handler para la ruta física 
     * e inyectar el mockMvc configurado en el test.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Probar GET /index.html usando el slice WebMvc")
    void testIndexWebMvc() throws Exception {
        mockMvc.perform(get("/index.html"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
    }
}
