package com.testing.course.service;

import com.testing.course.model.Owner;
import com.testing.course.model.Pet;
import com.testing.course.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Owner.
 * Soporta dos modos:
 * 1. Con repositorio JPA (inyectado por Spring, para producción/integración).
 * 2. Sin repositorio (lista en memoria), para tests unitarios puros de las secciones JUnit5/Mockito.
 */
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    // Lista en memoria para tests unitarios que instancian new OwnerService()
    private final List<Owner> inMemoryOwners = new ArrayList<>();
    private final boolean useRepository;

    /** Constructor para Spring (inyección de dependencias vía JPA). */
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
        this.useRepository = true;
    }

    /** Constructor sin argumentos para tests unitarios puros (sin Spring ni BBDD). */
    public OwnerService() {
        this.ownerRepository = null;
        this.useRepository = false;
    }

    public void save(Owner owner) {
        validateOwner(owner);
        if (useRepository) {
            ownerRepository.save(owner);
        } else {
            inMemoryOwners.add(owner);
        }
    }

    public void validateOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("El owner no puede ser nulo");
        }
        if (owner.getFirstName() == null || owner.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
    }

    public Owner findByLastName(String lastName) {
        if (useRepository) {
            return ownerRepository.findByLastName(lastName).orElse(null);
        } else {
            return inMemoryOwners.stream()
                .filter(o -> o.getLastName() != null && o.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
        }
    }

    public void addPetToOwner(Owner owner, Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("La mascota no puede ser nula");
        }
        owner.getPets().add(pet.getName());
    }

    public long getOwnerCount() {
        if (useRepository) {
            return ownerRepository.count();
        } else {
            return inMemoryOwners.size();
        }
    }

    public void slowProcess() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
