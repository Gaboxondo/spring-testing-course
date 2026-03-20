package com.testing.course.repository;

import com.testing.course.model.Visit;
import java.util.Collection;

/**
 * <h1>REPOSITORIO: VisitRepository</h1>
 * 
 * <p><b>Qué hace:</b> Interfaz para la persistencia del historial de visitas.</p>
 * 
 * <p><b>Por qué existe:</b> Centraliza las operaciones sobre las visitas médicas, 
 * permitiendo desacoplar el origen de datos de la lógica de negocio.</p>
 * 
 * <p><b>Cómo se usa:</b> Se inyecta en <code>VisitService</code> y es clave para 
 * demostrar el uso de <code>AdditionalAnswers</code> en las lecciones avanzadas de Mockito.</p>
 */
public interface VisitRepository {
    Collection<Visit> findAll();
    Visit findById(Long id);
    void save(Visit visit);

    /**
     * <h2>MÉTODO ESPECIAL: Echo Save</h2>
     * <p>Guarda y devuelve la misma instancia para facilitar el encadenamiento o stubbing.</p>
     * 
     * @param visit La visita a procesar.
     * @return La misma visita recibida (comportamiento Echo).
     */
    Visit saveAndReturn(Visit visit);
}
