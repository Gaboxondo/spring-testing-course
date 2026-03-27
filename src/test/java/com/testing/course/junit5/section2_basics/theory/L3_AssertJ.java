package com.testing.course.junit5.section2_basics.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * <h1>TEORÍA: AssertK</h1>
 *
 * <p><b>Qué hace:</b> Es una manera distinta de realizar assertions </p>
 *
 * <p><b>Por qué existe:</b> es mas leible ademas de que simplifica "a veces" realizar las aserciones</p>
 *
 */
@DisplayName("Sección 2 - L3: Assertions con AssertJ")
public class L3_AssertJ {

    public static class Usuario {
        private String nombre;
        private int edad;
        private String email;
        private boolean activo;
        private List<String> roles;

        // Constructor completo
        public Usuario(String nombre, int edad, String email, boolean activo, List<String> roles) {
            this.nombre = nombre;
            this.edad = edad;
            this.email = email;
            this.activo = activo;
            this.roles = roles;
        }

        // Getters (Necesarios para que AssertJ pueda "extraer" por nombre de propiedad)
        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }
        public String getEmail() { return email; }
        public boolean isActivo() { return activo; }
        public List<String> getRoles() { return roles; }

        // Setters opcionales para tus tests
        public void setNombre(String nombre) { this.nombre = nombre; }
        public void setEdad(int edad) { this.edad = edad; }
    }


        public static List<Usuario> prepararUsuariosParaTest() {
            // Usuario 1: Cumple con "Alice", 25 años, activa y con dos roles
            Usuario u1 = new Usuario( "Alice", 25, "alice@dev.com", true, Arrays.asList( "ADMIN", "USER" ) );

            // Usuario 2: Cumple con "Bob", 30 años, inactivo y con un rol
            Usuario u2 = new Usuario( "Bob", 30, "bob@dev.com", false, Arrays.asList( "USER" ) );

            return Arrays.asList( u1, u2 );
        }

    @Test
    @DisplayName("🧪 Demo 1: Ejemplos con AssertJ")
    void basicAssertionsDemo() {
        // 1. Strings (Cadenas)
        String texto = "JUnit 5 con AssertJ es genial";

        assertThat(texto)
            .startsWith("JUnit")
            .contains("AssertJ")
            .endsWith("genial")
            .hasSize(29)
            .isNotBlank();

        // 2. Números
        int resultado = 42;

        assertThat(resultado)
            .isPositive()
            .isGreaterThan(40)
            .isLessThan(50)
            .isEqualTo(42)
            .isIn(40, 41, 42, 43);

        // 3. Listas / Colecciones
        List<String> lenguajes = List.of("Java", "Kotlin", "Python");

        assertThat(lenguajes)
            .hasSize(3)
            .contains("Java")
            .containsExactly("Java", "Kotlin", "Python") // Orden estricto
            .containsAnyOf("C++", "Kotlin")
            .doesNotContain("PHP");

        // 4. Optionals (Muy útil en Java moderno)
        Optional<String> emptyOpt = Optional.empty();
        Optional<String> fullOpt = Optional.of("Hola");

        assertThat(emptyOpt).isEmpty();
        assertThat(fullOpt).isPresent().contains("Hola");

        // 5. Excepciones (Sin usar try-catch)
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("Dato no válido");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("no válido");

        List<Usuario> usuarios = prepararUsuariosParaTest();

        assertThat(usuarios)
            .extracting(Usuario::getNombre) // Extraemos solo el campo nombre
            .containsExactlyInAnyOrder("Alice", "Bob")
            .doesNotContain("Pedro");
    }
}
