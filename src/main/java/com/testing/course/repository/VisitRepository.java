package com.testing.course.repository;

import com.testing.course.model.Visit;
import java.util.Collection;

public interface VisitRepository {
    Collection<Visit> findAll();
    Visit findById(Long id);
    void save(Visit visit);
}
