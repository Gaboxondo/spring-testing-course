package com.testing.course.spring.section1_context.exercises;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * Ejercicio L11: Crea tu propia Extensión de JUnit 5.
 * 
 * ¿Alguna vez te has preguntado cómo funcionan @ExtendWith(MockitoExtension.class)?
 * ¡Son simples interfaces que implementas!
 * 
 * OBJETIVO: Implementar una extensión llamada MyTimerExtension que imprima un mensaje 
 * en consola ANTES y DESPUÉS de cada método @Test.
 */

// TODO: Implementa las interfaces BeforeEachCallback y AfterEachCallback.
class MyTimerExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // TODO: Imprime un mensaje indicando el comienzo del test.
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // TODO: Imprime un mensaje indicando que el test ha finalizado.
    }
}

@ExtendWith(MyTimerExtension.class) // TODO: Aplica tu extensión a esta clase.
@DisplayName("Ej L11: Test de Extensión Personalizada")
@Disabled("Ejercicio pendiente de resolver")
class E3_CustomExtensionExercise {

    @Test
    @DisplayName("?? Probar si la extensión imprime datos")
    void testDummy() {
        System.out.println("Ejecutando cuerpo del test...");
    }
}


