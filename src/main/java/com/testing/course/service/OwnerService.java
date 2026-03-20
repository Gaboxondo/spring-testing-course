package com.testing.course.service;

import com.testing.course.model.Owner;
import com.testing.course.model.Pet;
import com.testing.course.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <h1>SERVICIO: OwnerService</h1>
 * 
 * <p><b>Qué hace:</b> Orquesta las operaciones sobre los propietarios y sus mascotas asociadas.</p>
 * 
 * <p><b>Por qué existe:</b> Soporta dos modos de operación para facilitar el aprendizaje:</p>
 * <ul>
 *   <li><b>Modo JPA:</b> Utiliza <code>OwnerRepository</code> para persistencia real.</li>
 *   <li><b>Modo In-Memory:</b> Usa una lista local para tests unitarios puros sin infraestructura pesada.</li>
 * </ul>
 * 
 * <p><b>Cómo se usa:</b> Se emplea en los primeros capítulos de JUnit 5 para practicar aserciones 
 * simples, aserciones agrupadas y manejo de excepciones.</p>
 */
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final List<Owner> inMemoryOwners = new ArrayList<>();
    private final boolean useRepository;

    /** 
     * Constructor para Spring (Inyección de dependencias).
     */
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
        this.useRepository = true;
    }

    /** 
     * Constructor sin argumentos para tests unitarios simples en memoria.
     */
    public OwnerService() {
        this.ownerRepository = null;
        this.useRepository = false;
    }

    /**
     * Guarda un propietario tras validarlo.
     */
    public void save(Owner owner) {
        validateOwner(owner);
        if (useRepository) {
            ownerRepository.save(owner);
        } else {
            inMemoryOwners.add(owner);
        }
    }

    /**
     * Lógica de validación obligatoria para el registro.
     * 
     * @throws IllegalArgumentException si los datos son inválidos.
     */
    public void validateOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("El owner no puede ser nulo");
        }
        if (owner.getFirstName() == null || owner.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
    }

    /**
     * Busca por apellido (no sensible a mayúsculas).
     */
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

    /**
     * Vincula una mascota a un propietario.
     */
    public void addPetToOwner(Owner owner, Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("La mascota no puede ser nula");
        }
        owner.getPets().add(pet.getName());
    }

    /**
     * Devuelve el recuento total de propietarios registrados.
     */
    public long getOwnerCount() {
        if (useRepository) {
            return ownerRepository.count();
        } else {
            return inMemoryOwners.size();
        }
    }

    /**
     * Simula un proceso pesado para demostrar tests de timeout.
     */
    public void slowProcess() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
