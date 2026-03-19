package com.gaboxondo.testing.repository;

import com.gaboxondo.testing.model.Vet;
import java.util.Collection;

public interface VetRepository {
    Collection<Vet> findAll();
    Vet findById(Long id);
    void save(Vet vet);
}
