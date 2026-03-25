package com.testing.course.spring.section8_features.theory;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * <h1>TEORÍA: Configuración de Test (@TestConfiguration)</h1>
 * 
 * <p><b>Qué hace:</b> Permite extender o sobrescribir Beans del contexto 
 * principal de Spring específicamente para un test.</p>
 * 
 * <p><b>Por qué existe:</b> A menudo necesitamos que en un test un Bean de 
 * integración (ej: cliente de API externa) se comporte de forma distinta, 
 * sin tener que cambiar la base de código de producción.</p>
 * 
 * <h2>Comportamiento Crítico:</h2>
 * <p>A diferencia de <code>@Configuration</code> normal, <code>@TestConfiguration</code> 
 * no inhabilita el escaneo automático, sino que se añade al contexto existente, 
 * por lo que suele requerir <code>@Primary</code> para priorizar el Bean de test.</p>
 */
@SpringBootTest
@DisplayName("Sección 8 - L2: Sobrescritura mediante TestConfiguration")
class L2_TestConfigurationTheory {

    // NOTA: Existe una opción más moderna y ágil para sobrescribir Beans 
    // sin @TestConfiguration ni @Primary, usando @MockitoSpyBean o @MockitoBean.
    // Consulta la teoría L4 para ver el ejemplo completo de MockitoSpyBean.
    @TestConfiguration 
    static class OverrideConfig {
        @Bean
        @Primary 
        public OwnerService mockOwnerService() {
            OwnerService mock = mock(OwnerService.class);
            when(mock.findByLastName("Override")).thenReturn(new Owner("Test", "Override"));
            return mock;
        }
    }

    @Autowired
    private OwnerService ownerService; 

    /**
     * <h2>DEMO: Verificación de Bean interceptado</h2>
     * <p>El test consulta al servicio y comprueba que ha recibido el mock 
     * configurado en la clase estática interna.</p>
     */
    @Test
    @DisplayName("🧪 Demo 14: Trabajo con Beans auxiliares de test")
    void testBeanOverride() {
        Owner found = ownerService.findByLastName("Override");
        assertEquals("Test", found.getFirstName());
    }
}
