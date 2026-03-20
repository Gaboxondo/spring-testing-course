package com.testing.course.junit5.section1_intro.exercises;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * <h1>EJERCICIO 1: Hola Mundo en JUnit 5</h1>
 * 
 * <p>El objetivo de este ejercicio es familiarizarse con la estructura básica de un test 
 * en JUnit 5 y entender cómo fallan y pasan las aserciones.</p>
 * 
 * <p><b>Por qué existe:</b> Es el primer paso para cualquier desarrollador de testing. 
 * Sin entender cómo funciona una aserción básica, no se pueden construir suites complejas.</p>
 * 
 * <p><b>Cómo usarlo/resolverlo:</b> 
 * 1. Quita el @Disabled de la clase (o de los métodos).
 * 2. Implementa la lógica de aserción usando assertTrue.
 * 3. Ejecuta el test desde el IDE o con 'mvn test'.</p>
 */
@Disabled("Ejercicio pendiente de resolver - Quitar esta anotación para empezar")
class EX1_HelloWorldExercise {

    /**
     * TAREA 1: Validación de expresión booleana.
     * <p>Usa <code>assertTrue(condicion)</code> para validar que 1 es menor que 10.</p>
     */
    @Test
    void testHelloWorld() {
        // TODO: Comprobar que 1 < 10 usando assertTrue
        // assertTrue(1 < 10);
    }

    /**
     * TAREA 2: Entendiendo el fallo intencionado.
     * <p>Usa <code>fail("mensaje")</code> para forzar un error al principio y observar cómo 
     * el motor de JUnit reporta el fallo y muestra el mensaje personalizado.</p>
     */
    @Test
    void testFailAlways() {
        // TODO: Usa fail("mensaje") para forzar un error al principio
        // fail("Este test falla a propósito");
    }
}
