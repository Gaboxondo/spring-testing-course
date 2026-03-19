package com.gaboxondo.testing.junit5.section7_execution.theory;

import com.gaboxondo.testing.model.Specialty;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TEORÍA: Maven Failsafe Plugin (Integration Test).
 * 
 * Convención: El sufijo 'IT' (Integration Test) hace que Maven 
 * asigne este test al plugin Failsafe durante el ciclo "verify".
 */
@DisplayName("Teoría: Failsafe Integration Test Demo")
class SpecialtyIntegrationIT {

    @Test
    @DisplayName("🧪 Test de Integración: specialty IT")
    void testIntegration() {
        // En tests de integración probaríamos llamadas a base de datos, API externa, etc.
        Specialty specialty = new Specialty("Odontología");
        assertNotNull(specialty.getName(), "La especialidad IT debería tener nombre");
        System.out.println("FAILSAFE: Ejecutando test de integración (más pesado)");
    }

    /**
     * COMANDO A PROBAR: 
     * mvn verify
     * 
     * Verás que este test NO se ejecuta en 'mvn test' pero SI en 'mvn verify'.
     */
}
