package com.gaboxondo.testing.service;

import com.gaboxondo.testing.model.Vet;
import com.gaboxondo.testing.repository.VetRepository;
import java.util.Collection;

public class VetService {
    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Collection<Vet> findAll() {
        return vetRepository.findAll();
    }

    public void save(Vet vet) {
        if (vet == null) {
            throw new IllegalArgumentException("Vet no puede ser nulo");
        }
        vetRepository.save(vet);
    }
}
