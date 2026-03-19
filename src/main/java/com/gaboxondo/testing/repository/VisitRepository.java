package com.gaboxondo.testing.repository;

import com.gaboxondo.testing.model.Visit;
import java.util.Collection;

public interface VisitRepository {
    Collection<Visit> findAll();
    Visit findById(Long id);
    void save(Visit visit);
}
