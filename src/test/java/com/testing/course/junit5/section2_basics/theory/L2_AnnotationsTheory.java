package com.testing.course.junit5.section2_basics.theory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * <h1>TEORÍA: Control de Ejecución y Estandarización</h1>
 * 
 * <p><b>Qué hace:</b> Proporciona metadatos para mejorar la legibilidad del 
 * reporte de test y ofrece mecanismos para filtrar qué tests se ejecutan.</p>
 * 
 * <p><b>Por qué existe:</b> Permite documentar tests pendientes de corrección (@Disabled), 
 * personalizar nombres de tests complejos (@DisplayName) o restringir tests a entornos 
 * específicos del host (@EnabledOnOs).</p>
 */
@DisplayName("Sección 2 - L2: Anotaciones de Control y Metadatos")
class L2_AnnotationsTheory {

    /**
     * <h2>DEMO: Semántica de Informes</h2>
     * <p>Uso de <code>@DisplayName</code> para humanizar los nombres de los métodos técnicos.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Nombre legible en el informe de Maven / IDE")
    void customDisplayNameDemo() {
        System.out.println("Reporte customizado.");
    }

    /**
     * <h2>DEMO: Gestión de Tests Defectuosos (@Disabled)</h2>
     * <p>Estrategia oficial para gestionar tests que fallan por bugs conocidos 
     * sin romper el build general del proyecto.</p>
     */
    @Test
    @Disabled("Deshabilitado: Requiere refactorización de la lógica de balance")
    @DisplayName("🧪 Demo 2: Test marcador de posición (placeholder)")
    void disabledTestDemo() {
    }

    /**
     * <h2>DEMO: Afinidad de Plataforma</h2>
     * <p>Garantizamos que el test solo se ejecuta si el sistema operativo 
     * coincide con el declarado, evitando falsos negativos en CI/CD.</p>
     */
    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("🧪 Demo 3: Exclusividad para entorno Windows")
    void windowsOnlyDemo() {
        System.out.println("Entorno: Host Windows Detectado.");
    }
}
