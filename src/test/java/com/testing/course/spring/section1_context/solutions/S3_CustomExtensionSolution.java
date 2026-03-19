package com.testing.course.spring.section1_context.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * Solución L12: Crea tu propia Extensión de JUnit 5.
 */

class MyTimerExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // SOLUCIÓN: Imprimimos información del test antes de empezar.
        System.out.println(">>> Comienzo del Test: " + context.getDisplayName());
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // SOLUCIÓN: Imprimimos información después de terminar.
        System.out.println("<<< Fin del Test: " + context.getDisplayName());
    }
}

@ExtendWith(MyTimerExtension.class)
@DisplayName("Solución L12: Extensión Personalizada")
class S3_CustomExtensionSolution {

    @Test
    @DisplayName("🧪 Probar si la extensión imprime datos")
    void testDummy() {
        System.out.println("Ejecutando cuerpo del test...");
    }
}

