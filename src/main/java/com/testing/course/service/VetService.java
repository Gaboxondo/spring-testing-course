package com.testing.course.service;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

/**
 * <h1>SERVICIO: VetService</h1>
 * 
 * <p><b>Qué hace:</b> Administra la información y el catálogo de veterinarios de la clínica.</p>
 * 
 * <p><b>Por qué existe:</b> Proporciona una API limpia para buscar y registrar profesionales, 
 * abstrayendo la complejidad de las consultas al repositorio JPA.</p>
 * 
 * <p><b>Cómo se usa:</b> Marcado con <code>@Service</code> para ser detectado por Spring. 
 * Se utiliza en tests de Mockito para demostrar inyección de dependencias y stubbing básico.</p>
 */
@Service
public class VetService {
    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    /**
     * Obtiene la lista completa de veterinarios.
     */
    public Collection<Vet> findAll() {
        return vetRepository.findAll();
    }

    /**
     * Registra un nuevo veterinario con validación de nulidad.
     */
    public void save(Vet vet) {
        if (vet == null) {
            throw new IllegalArgumentException("Vet no puede ser nulo");
        }
        vetRepository.save(vet);
    }

    /**
     * Elimina un veterinario por su identificador único.
     */
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    /**
     * Busca un veterinario por su ID devolviendo null si no existe.
     */
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }
}
