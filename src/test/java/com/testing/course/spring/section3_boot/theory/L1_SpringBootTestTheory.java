package com.testing.course.spring.section3_boot.theory;

import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: Tests de Integración Completa (@SpringBootTest)</h1>
 * 
 * <p><b>Qué hace:</b> Levanta el <code>ApplicationContext</code> completo de la 
 * aplicación, emulando un entorno real de ejecución con todos los Beans, 
 * repositorios y configuraciones activas.</p>
 * 
 * <p><b>Por qué existe:</b> Es la prueba definitiva de que todas las piezas del 
 * rompecabezas (capas de datos, servicios, seguridad) encajan y funcionan juntas 
 * correctamente (End-to-End o Integración Ancha).</p>
 * 
 * <h2>Rendimiento:</h2>
 * <p>Es la anotación más pesada de Spring Testing. Debe usarse con moderación, 
 * priorizando Slices especificos (@WebMvcTest, @DataJpaTest) para tests más rápidos.</p>
 */
@SpringBootTest
@DisplayName("Sección 3 - L1: @SpringBootTest (Integración Total)")
class L1_SpringBootTestTheory {

    @Autowired
    private OwnerService ownerService;

    /**
     * <h2>DEMO: Verificación del motor de Spring Boot</h2>
     * <p>Comprobamos que las dependencias multinivel se han inyectado satisfactoriamente 
     * en el contexto de integración.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Verificar disponibilidad del contexto completo")
    void testProjectSetup() {
        assertNotNull(ownerService, "El ApplicationContext debe inyectar el servicio real");
    }
}
