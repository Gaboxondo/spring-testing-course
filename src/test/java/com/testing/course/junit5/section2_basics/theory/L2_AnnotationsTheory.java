package com.testing.course.junit5.section2_basics.theory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * <h1>TEORÍA: Anotaciones de Ejecución Condicional y Control</h1>
 * 
 * <p>JUnit 5 proporciona un control exhaustivo sobre el ciclo de vida, la visibilidad 
 * y la ejecución de los tests en el reporte final mediante anotaciones de metadatos.</p>
 * 
 * <h2>Principios Clave:</h2>
 * <ul>
 *   <li><b>@DisplayName:</b> Permite definir un nombre semántico y legible para la clase 
 *   o el método de test, soportando espacios, caracteres especiales y emojis.</li>
 *   <li><b>@Disabled:</b> Permite ignorar un test o toda una suite. Es la forma oficial 
 *   de JUnit 5 para "comentar" código de test temporalmente sin perder visibilidad en los reportes.</li>
 *   <li><b>@EnabledOnOs:</b> Ejecución condicional basada en el sistema operativo del host, 
 *   vital para tests que interactúan con recursos nativos.</li>
 * </ul>
 * 
 * <p><b>¿Cuándo usarlas?</b> Para organizar suites de tests complejas, documentar 
 * tests temporales o asegurar la compatibilidad multiplataforma en entornos de CI/CD.</p>
 * 
 * @see org.junit.jupiter.api.condition.EnabledOnOs
 * @see org.junit.jupiter.api.Disabled
 * @since 1.0
 */
@DisplayName("Teoría: Control de Ejecución (Anotaciones)")
class L2_AnnotationsTheory {

    /**
     * TAREA DEMO 1: Documentación Semántica con DisplayName.
     * <p>Muestra cómo asignar nombres legibles que sustituyan a los nombres 
     * técnicos de los métodos en los informes de ejecución.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Nombre personalizado con Emojis ✨")
    void customDisplayNameDemo() {
        System.out.println("Este test aparecerá con el nombre del DisplayName en el IDE.");
    }

    /**
     * TAREA DEMO 2: Control de Deuda Técnica con @Disabled.
     * <p>Muestra cómo deshabilitar un test defectuoso sin eliminarlo, 
     * manteniendo constancia del motivo mediante el atributo <code>value</code>.</p>
     */
    @Test
    @Disabled("Deshabilitado hasta que se corrija el BUG-123")
    @DisplayName("🧪 Demo 2: Test que no se ejecutará")
    void disabledTestDemo() {
        // Este código no se ejecutará.
    }

    /**
     * TAREA DEMO 3: Ejecución condicional por Sistema Operativo.
     * <p>Muestra cómo restringir la ejecución de un test a un SO específico, 
     * lo cual es esencial para tests de integración con el sistema de archivos o red.</p>
     */
    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("🧪 Demo 3: Test que solo corre en Windows")
    void windowsOnlyDemo() {
        System.out.println("Este test solo se ha ejecutado porque estás en Windows.");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("🧪 Demo 3 (bis): Test que solo corre en Linux")
    void linuxOnlyDemo() {
        System.out.println("Este test solo se ejecutaría en un entorno Linux.");
    }
}

