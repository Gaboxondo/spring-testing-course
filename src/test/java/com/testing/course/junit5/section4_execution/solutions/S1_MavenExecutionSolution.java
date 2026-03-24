package com.testing.course.junit5.section4_execution.solutions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>Solución: Ejecución Selectiva con Maven Tags</h1>
 *
 * <p>Esta clase proporciona la resolución correcta del ejercicio {@link EX1_MavenExecutionExercise},
 * mostrando cómo etiquetar métodos de prueba para su filtrado mediante Maven.</p>
 *
 * <h2>Implementación</h2>
 * <ul>
 *   <li><b>Uso de {@link Tag}:</b> Permite agrupar tests bajo una categoría lógica.</li>
 *   <li><b>Maven Filtering:</b> Demuestra cómo Surefire interpreta estas etiquetas para incluir
 *   o excluir aserciones en el build.</li>
 * </ul>
 *
 * <h2>Reportes</h2>
 * <p>Al ejecutar <code>mvn surefire-report:report</code>, Maven genera una visualización HTML
 * detallada en la ruta <code>target/site/surefire-report.html</code>. Este reporte es esencial
 * en entornos de CI/CD para analizar fallos de forma visual.</p>
 */
@DisplayName("Sección 4: Solución Ejecución con Maven")
class S1_MavenExecutionSolution {

    /**
     * <h3>Resolución del Test Rápido</h3>
     * <p>Se ha aplicado la etiqueta <code>fast</code>. Este test será incluido al ejecutar
     * <code>mvn test -Dgroups="fast"</code>.</p>
     */
    @Test
    @Tag("fast")
    @DisplayName("🧪 Test Rápido (FAST)")
    void testFast() {
        assertTrue(true);
    }

    /**
     * <h3>Resolución del Test Lento</h3>
     * <p>Se ha aplicado la etiqueta <code>slow</code>. Se puede excluir del build diario
     * mediante el comando <code>mvn test -DexcludedGroups="slow"</code> para acelerar el desarrollo.</p>
     */
    @Test
    @Tag("slow")
    @DisplayName("🧪 Test Lento (SLOW)")
    void testSlow() {
        assertTrue(true);
    }
}


