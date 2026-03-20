package com.testing.course.repository;

import com.testing.course.model.Visit;
import java.util.Collection;

public interface VisitRepository {
    Collection<Visit> findAll();
    Visit findById(Long id);
    void save(Visit visit);

    /**
     * Guarda y devuelve la misma visita.
     * <p>Ideal para demostrar AdditionalAnswers.returnsFirstArg()</p>
     */
    Visit saveAndReturn(Visit visit);
}
