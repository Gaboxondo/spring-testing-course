package com.testing.course.junit5.section3_advanced.theory;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DisplayName;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * <h1>TEORÍA: Dynamic Tests (@TestFactory) en JUnit 5</h1>
 * 
 * <p>Los tests dinámicos son una potente característica de JUnit 5 que permite generar casos de prueba 
 * en tiempo de ejecución. A diferencia de los tests estándar (@Test), que son estáticos y 
 * definidos en tiempo de compilación, los Dynamic Tests se "fabrican" mientras el test se ejecuta.</p>
 * 
 * <h2>¿Por qué usar Dynamic Tests?</h2>
 * <ul>
 *   <li><b>Datos desconocidos:</b> Cuando los casos de prueba dependen de una base de datos, 
 *   archivos externos o una API externa que solo conocemos al ejecutar.</li>
 *   <li><b>Basados en lógica:</b> Si queremos generar tests basados en permutaciones, 
 *   combinaciones matemáticas o estados de un sistema.</li>
 *   <li><b>Evitar duplicidad:</b> Si tenemos una lógica de aserción compleja que se repite 
 *   para muchos inputs pero queremos verlos como tests individuales en el reporte.</li>
 * </ul>
 * 
 * <h2>Conceptos Fundamentales:</h2>
 * <ul>
 *   <li><b>@TestFactory:</b> Marca el método como una "fábrica" de tests. Debe retornar un 
 *   <code>Stream</code>, <code>Collection</code>, <code>Iterable</code> o <code>Iterator</code>.</li>
 *   <li><b>DynamicNode:</b> Es la clase base. Un test Factory puede devolver <code>DynamicTest</code> 
 *   (un test individual) o <code>DynamicContainer</code> (un grupo de tests).</li>
 *   <li><b>Ciclo de vida:</b> ⚠️ <b>IMPORTANTE:</b> Los métodos <code>@BeforeEach</code> y 
 *   <code>@AfterEach</code> <b>NO</b> se ejecutan para cada test dinámico individual, 
 *   sino solo una vez para el método @TestFactory completo.</li>
 * </ul>
 * 
 * @see <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests">Official JUnit 5 Documentation</a>
 */
@DisplayName("🚀 Teoría Avanzada: Dynamic Tests (@TestFactory)")
class L2_DynamicTestsTheory {

    /**
     * 🟢 EJEMPLO 1: Generación básica desde un Stream.
     * <p>Este es el uso más común. Transformamos una lista de datos en tests dinámicos.</p>
     * 
     * @return Stream de tests individuales.
     */
    @TestFactory
    @DisplayName("🧪 Ejemplo 1: Conversión simple de Datos a Tests")
    Stream<DynamicTest> simpleDynamicTests() {
        List<String> inputs = Arrays.asList("JUnit", "Mockito", "Spring");

        return inputs.stream()
            .map(input -> dynamicTest("Validando que '" + input + "' no sea nulo", () -> {
                // Lógica del test para cada elemento del stream
                assertNotNull(input);
                assertFalse(input.isEmpty());
            }));
    }

    /**
     * 🔵 EJEMPLO 2: Escenario Real - Validación de Dominio.
     * <p>Imagina que tenemos un 'OrderService' y queremos probar múltiples estados de un pedido.
     * En lugar de un solo test con un bucle (que fallaría entero al primer error), 
     * generamos un test por cada estado.</p>
     * 
     * @return Stream de tests que simulan validaciones de negocio.
     */
    @TestFactory
    @DisplayName("🛒 Ejemplo 2: Validación de Estados de Pedido (Real-World)")
    Stream<DynamicTest> orderValidationTests() {
        // Simulamos datos que podrían venir de un JSON o Base de Datos
        List<Order> ordersToTest = Arrays.asList(
            new Order(1L, "PENDING", 100.0),
            new Order(2L, "SHIPPED", 50.0),
            new Order(3L, "CANCELLED", 0.0)
        );

        return ordersToTest.stream()
            .map(order -> dynamicTest("Validando Pedido ID: " + order.id + " (" + order.status + ")", () -> {
                // Simulación de lógica de negocio compleja
                if ("CANCELLED".equals(order.status)) {
                    assertEquals(0.0, order.amount, "Un pedido cancelado debe tener importe 0");
                } else {
                    assertTrue(order.amount > 0, "Pedidos activos deben tener importe > 0");
                }
            }));
    }

    /**
     * 🟡 EJEMPLO 3: Jerarquía con DynamicContainer.
     * <p>Los contenedores permiten agrupar tests dinámicos en carpetas o niveles dentro 
     * del reporte de ejecución (IDE / Maven Report).</p>
     * 
     * @return Stream de nodos que contienen otros tests.
     */
    @TestFactory
    @DisplayName("📁 Ejemplo 3: Agrupación en Contenedores")
    Stream<DynamicNode> groupedDynamicTests() {
        return Stream.of("A", "B", "C")
            .map(category -> dynamicContainer("Categoría " + category, Stream.of(
                dynamicTest("Test 1 de " + category, () -> assertTrue(true)),
                dynamicTest("Test 2 de " + category, () -> assertTrue(true))
            )));
    }

    /**
     * 🔴 EJEMPLO 4: Generación Matemática Dinámica.
     * <p>Útil para tests de regresión o validación de algoritmos con rangos amplios.</p>
     * 
     * @return Iterable de tests generados por rango numérico.
     */
    @TestFactory
    @DisplayName("🔢 Ejemplo 4: Test de Rango Numérico (Algoritmo)")
    Iterable<DynamicTest> numericRangeTests() {
        return IntStream.rangeClosed(1, 5)
            .mapToObj(n -> dynamicTest("Test Fibonacci/Multiplo para: " + n, () -> {
                assertTrue(n > 0);
                assertEquals(0, (n * 2) % 2);
            }))
            .toList();
    }

    /**
     * 🟠 EJEMPLO 5: Permutaciones de Seguridad (Escenario Avanzado).
     * <p>En aplicaciones reales, a veces necesitamos probar que una combinación de 
     * Rol + Acción + Recurso funciona correctamente.</p>
     * 
     * @return Stream de tests que validan una matriz de permisos.
     */
    @TestFactory
    @DisplayName("🔐 Ejemplo 5: Matriz de Permisos (Combinatoria)")
    Stream<DynamicNode> securityMatrixTests() {
        List<String> roles = Arrays.asList("ADMIN", "USER", "GUEST");
        List<String> actions = Arrays.asList("READ", "WRITE", "DELETE");

        return roles.stream().map(role -> 
            dynamicContainer("Permisos para el Rol: " + role, 
                actions.stream().map(action -> 
                    dynamicTest("Verificando " + action, () -> {
                        // Lógica simulada de verificación de permisos
                        if ("ADMIN".equals(role)) {
                            assertTrue(true, "Admin siempre tiene permiso");
                        } else if ("GUEST".equals(role) && !"READ".equals(action)) {
                            // Simulamos que el test espera un fallo o validamos que no tenga permiso
                            System.out.println("Validando que Guest NO puede " + action);
                        }
                    })
                )
            )
        );
    }

    // --- CLASES AUXILIARES PARA EL EJEMPLO (Simulación de Dominio) ---

    /**
     * 🏗️ Clase interna para representar un modelo de datos (POJO) en los ejemplos.
     * <p>En un entorno real, esta sería una Entidad de JPA o un DTO de negocio.</p>
     * <p>Usamos clases internas en la teoría para que el ejemplo sea autocontenido y no dependa
     * de otros archivos, facilitando el aprendizaje del concepto principal.</p>
     */
    static class Order {
        /** Identificador único del Pedido. */
        Long id;
        /** Estado actual: "PENDING", "SHIPPED", "CANCELLED". */
        String status;
        /** Importe total del pedido. */
        Double amount;

        /**
         * Constructor para facilitar la creación de datos de prueba dinámicos.
         * @param id Identificador.
         * @param status Estado inicial.
         * @param amount Importe del pedido.
         */
        Order(Long id, String status, Double amount) {
            this.id = id;
            this.status = status;
            this.amount = amount;
        }
    }
}

