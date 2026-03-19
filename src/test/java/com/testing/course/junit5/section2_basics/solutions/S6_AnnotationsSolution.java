package com.testing.course.junit5.section2_basics.solutions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Solución 3: Anotaciones de Control (@Disabled, @DisplayName).
 * Basado en: Section 5: Testing Java with JUnit 5 - 51, 52.
 */
@DisplayName("Pruebas de ejemplo con Anotaciones JUnit 5")
class S6_AnnotationsSolution {

    @Test
    @DisplayName("🧪 Test: Validar un nombre amigable")
    void testMeaningfulName() {
        // ... (Este test ahora tiene un nombre legible en los reportes)
    }

    @Test
    @Disabled("Temporalmente deshabilitado: No tenemos mock del servicio aún")
    void testTBD() {
        // Este test será ignorado pero aparecerá listado como saltado.
    }
}

