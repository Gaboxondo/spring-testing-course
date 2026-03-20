package com.testing.course.junit5.section2_basics.theory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * <h1>TEORÍA: Anotaciones de Ejecución Condicional y Control</h1>
 * 
 * <p>JUnit 5 permite un control fino sobre qué tests se ejecutan, 
 * bajo qué condiciones y cómo se presentan en los reportes.</p>
 * 
 * <h2>Anotaciones Clave:</h2>
 * <ul>
 *   <li><b>@DisplayName:</b> Permite definir un nombre legible para la clase o el método de test. 
 *   Soporta espacios, caracteres especiales e incluso emojis.</li>
 *   <li><b>@Disabled:</b> Se utiliza para deshabilitar un test o toda una clase de tests. 
 *   Es preferible a comentar el código, ya que JUnit informa que el test fue ignorado.</li>
 *   <li><b>@EnabledOnOs:</b> Permite que un test se ejecute solo en sistemas operativos específicos 
 *   (Windows, Linux, Mac, etc.).</li>
 * </ul>
 * 
 * @see org.junit.jupiter.api.condition.EnabledOnOs
 * @see org.junit.jupiter.api.Disabled
 * @since 1.0
 */
@DisplayName("Teoría: Control de Ejecución (Anotaciones)")
class L2_AnnotationsTheory {

    /**
     * TAREA DEMO 1: DisplayName.
     * <p>El uso de @DisplayName hace que los reportes de tests sean mucho 
     * más fáciles de leer para perfiles no técnicos.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Nombre personalizado con Emojis ✨")
    void customDisplayNameDemo() {
        System.out.println("Este test aparecerá con el nombre del DisplayName en el IDE.");
    }

    /**
     * TAREA DEMO 2: Test Deshabilitado.
     * <p>Ideal para tests que fallan por bugs conocidos o funcionalidades 
     * que aún no están implementadas.</p>
     */
    @Test
    @Disabled("Deshabilitado hasta que se corrija el BUG-123")
    @DisplayName("🧪 Demo 2: Test que no se ejecutará")
    void disabledTestDemo() {
        // Este código no se ejecutará.
    }

    /**
     * TAREA DEMO 3: Ejecución condicional por Sistema Operativo.
     * <p>Útil para tests que dependen de rutas de archivos o comandos 
     * específicos del SO.</p>
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
