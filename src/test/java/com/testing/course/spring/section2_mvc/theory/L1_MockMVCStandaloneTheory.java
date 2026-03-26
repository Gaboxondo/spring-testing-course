package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.controller.IndexController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * <h1>TEORÍA: configuración Standalone de MockMVC</h1>
 * 
 * <p><b>Qué hace:</b> Permite testear un controlador de Spring MVC de forma aislada 
 * instanciándolo manualmente y configurando MockMVC sin cargar el contexto de Spring.</p>
 * 
 * <p><b>Por qué existe:</b> Es la forma más rápida y pura de testear la lógica de 
 * un controlador (rutas, nombres de vistas, códigos de estado, <b>o incluso APIs REST</b>) 
 * sin la sobrecarga de arrancar el servidor embebido (Tomcat/Jetty) ni el ApplicationContext.</p>
 * 
 * <h2>Modo Standalone:</h2>
 * <p>Se utiliza <code>MockMvcBuilders.standaloneSetup(controlador)</code>. Solo registra 
 * la infraestructura mínima necesaria para procesar peticiones HTTP simuladas contra ese Bean.</p>
 */
@DisplayName("Sección 2 - L1: MockMVC Standalone (Sin Contexto)")
class L1_MockMVCStandaloneTheory {

    private IndexController indexController;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
        // Configuración manual del entorno de ejecución de peticiones
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    /**
     * <h2>DEMO: Petición GET básica</h2>
     * <p>Simulamos el acceso a la raíz y comprobamos que el controlador devuelve 
     * el nombre de la plantilla HTML 'index'.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Probar GET /index con MockMvc")
    void testIndex() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
    }

    /**
     * <h2>DEMO: Gestión de Errores Críticos (500)</h2>
     * <p>Verificamos que las excepciones no capturadas se traducen en errores de servidor.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Simulación de error interno (500)")
    void testOups() throws Exception {
        mockMvc.perform(get("/oups"))
            .andExpect(status().isInternalServerError());
    }
}
