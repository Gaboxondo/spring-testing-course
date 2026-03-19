package com.testing.course.service;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import java.util.Collection;

public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public void save(Visit visit) {
        if (visit == null) {
            throw new IllegalArgumentException("La visita no puede ser nula");
        }
        if (visit.getDescription() == null || visit.getDescription().isBlank()) {
            throw new RuntimeException("Descripción obligatoria");
        }
        visitRepository.save(visit);
    }

    public Collection<Visit> findAll() {
        return visitRepository.findAll();
    }
}
