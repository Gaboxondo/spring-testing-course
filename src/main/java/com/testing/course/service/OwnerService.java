package com.testing.course.service;

import com.testing.course.model.Owner;
import com.testing.course.model.Pet;
import java.util.ArrayList;
import java.util.List;

public class OwnerService {
    private final List<Owner> owners = new ArrayList<>();

    public void save(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("El owner no puede ser nulo");
        }
        if (owner.getFirstName() == null || owner.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        owners.add(owner);
    }

    public Owner findByLastName(String lastName) {
        return owners.stream()
            .filter(o -> o.getLastName().equalsIgnoreCase(lastName))
            .findFirst()
            .orElse(null);
    }

    public void addPetToOwner(Owner owner, Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("La mascota no puede ser nula");
        }
        owner.getPets().add(pet.getName());
    }

    public int getOwnerCount() {
        return owners.size();
    }

    public void slowProcess() {
        try {
            Thread.sleep(500); // Tarea muy lenta
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
