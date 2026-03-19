package com.testing.course.junit5.section4_execution.solutions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución Sección 7: Ejecución Selectiva con Maven.
 * Basado en: Section 7: Test Execution - 85, 86.
 */
@DisplayName("Sección 7: Solución Ejecución con Maven")
class MavenExecutionSolution {

    @Test
    @Tag("fast")
    @DisplayName("🧪 Test Rápido (FAST)")
    void testFast() {
        // SOLUCIÓN: Etiqueta para ejecución ágil (mvn test -Dgroups="fast")
        assertTrue(true);
    }

    @Test
    @Tag("slow")
    @DisplayName("🧪 Test Lento (SLOW)")
    void testSlow() {
        // SOLUCIÓN: Etiqueta para excluirlos en compilaciones locales rápidas.
        // mvn test -DexcludedGroups="slow"
        assertTrue(true);
    }

    /**
     * GENERACIÓN DE REPORTES:
     * El comando 'mvn surefire-report:report' genera una visualización HTML de 
     * todos los tests ejecutados. Es ideal para documentar la calidad del proyecto.
     */
}
