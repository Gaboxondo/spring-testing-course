package com.testing.course.service.section1;

import com.testing.course.model.Vet;
import java.util.List;

/**
 * <h1>SERVICIO DE APOYO: Matchers Avanzados</h1>
 * 
 * <p><b>Qué hace:</b> Proporciona métodos con múltiples parámetros para practicar 
 * el uso de <b>Argument Matchers</b> en Mockito.</p>
 * 
 * <p><b>Por qué existe:</b> Sirve como herramienta pedagógica para demostrar que, 
 * al usar matchers en métodos multi-argumento, Mockito exige usarlos para todos 
 * los parámetros (prohibición de mezcla).</p>
 * 
 * <p><b>Cómo se usa:</b> Es el mock principal en <code>L4_MatchersTheory</code>. 
 * Se recomienda practicar el uso de <code>eq(...)</code> con variables booleanas 
 * acompañadas de <code>anyString()</code>.</p>
 */
public interface MatchersSupportService {

    /**
     * Busca veterinarios por su especialidad y si están activos.
     * <p>Utilizado para demostrar la regla de mezcla de Matchers (Golden Rule).</p>
     * 
     * @param specialty La especialidad a buscar.
     * @param isActive Estado del facultativo.
     * @return Lista de veterinarios coincidentes.
     */
    List<Vet> findBySpecialtyAndActive(String specialty, boolean isActive);

    /**
     * Registra un nuevo veterinario con su edad.
     * <p>Utilizado para demostrar anyInt(), anyString(), etc.</p>
     * 
     * @param name Nombre y apellidos.
     * @param age Edad del profesional.
     * @param city Ciudad de residencia.
     */
    void register(String name, int age, String city);
}
