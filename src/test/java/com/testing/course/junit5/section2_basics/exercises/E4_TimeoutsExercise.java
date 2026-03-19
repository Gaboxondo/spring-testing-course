package com.testing.course.junit5.section2_basics.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 5: Control de Tiempo en Servicios.
 * Basado en: Section 5: Testing Java with JUnit 5 - 54.
 * 
 * PISTA: Consulta 'L1_AssertionsTheory.java' para ver la diferencia entre 
 * assertTimeout y assertTimeoutPreemptively.
 */
@Disabled("Ejercicio pendiente de resolver")
class E4_TimeoutsExercise {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    void testTimeoutOfService() {
        // TODO 1: Comprobar que al llamar a ownerService.slowProcess() no tarda más de 600ms.
        // Pista: usa assertTimeout(Duration.ofMillis(600), () -> { /* código a probar */ });
    }

    @Test
    void testTimeoutPreemptivelyOfService() {
        // TODO 2: Comprobar con 'assertTimeoutPreemptively' que 'slowProcess' no excede los 100ms.
        // (Nota: Este test fallará porque sabemos que el método tarda 500ms!)
    }
}


