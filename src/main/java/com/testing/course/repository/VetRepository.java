package com.testing.course.repository;

import com.testing.course.model.Vet;
import java.util.Collection;

public interface VetRepository {
    Collection<Vet> findAll();
    Vet findById(Long id);
    void save(Vet vet);
}
