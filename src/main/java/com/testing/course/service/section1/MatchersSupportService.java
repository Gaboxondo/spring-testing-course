package com.testing.course.service.section1;

import com.testing.course.model.Vet;
import java.util.List;

/**
 * <h1>SERVICIO DE APOYO: Matchers Avanzados</h1>
 * 
 * <p>Este servicio se utiliza para demostrar cómo manejar métodos con 
 * múltiples parámetros en Mockito y el uso de matchers específicos.</p>
 */
public interface MatchersSupportService {

    /**
     * Busca veterinarios por su especialidad y si están activos.
     * <p>Utilizado para demostrar la regla de mezcla de Matchers.</p>
     */
    List<Vet> findBySpecialtyAndActive(String specialty, boolean isActive);

    /**
     * Registra un nuevo veterinario con su edad.
     * <p>Utilizado para demostrar anyInt(), anyString(), etc.</p>
     */
    void register(String name, int age, String city);
}
