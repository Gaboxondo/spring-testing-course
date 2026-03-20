package com.testing.course.service;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import java.util.Collection;

/**
 * <h1>SERVICIO: VisitService</h1>
 * 
 * <p><b>Qué hace:</b> Gestiona la lógica de negocio relacionada con las visitas al veterinario.</p>
 * 
 * <p><b>Por qué existe:</b> Actúa como capa intermedia entre el repositorio y los controladores, 
 * encargándose de las validaciones de datos y reglas de negocio antes de la persistencia.</p>
 * 
 * <p><b>Cómo se usa:</b> Se instancia pasando un <code>VisitRepository</code>. Es el 
 * principal objetivo de los tests de Mockito en las lecciones de Argument Captors y Exceptions.</p>
 */
public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * Guarda una visita validando que no sea nula y contenga descripción.
     * 
     * @param visit La visita a persistir.
     * @throws IllegalArgumentException si la visita es nula.
     * @throws RuntimeException si la descripción está vacía.
     */
    public void save(Visit visit) {
        if (visit == null) {
            throw new IllegalArgumentException("La visita no puede ser nula");
        }
        if (visit.getDescription() == null || visit.getDescription().isBlank()) {
            throw new RuntimeException("Descripción obligatoria");
        }
        visitRepository.save(visit);
    }

    /**
     * Recupera todas las visitas registradas.
     * 
     * @return Colección de objetos <code>Visit</code>.
     */
    public Collection<Visit> findAll() {
        return visitRepository.findAll();
    }
}
