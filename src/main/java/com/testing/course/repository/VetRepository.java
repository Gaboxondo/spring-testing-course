package com.testing.course.repository;

import com.testing.course.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>REPOSITORIO: VetRepository</h1>
 * 
 * <p><b>Qué hace:</b> Ofrece una interfaz de alto nivel para gestionar los datos de los veterinarios.</p>
 * 
 * <p><b>Por qué existe:</b> Permite desacoplar el acceso a datos (BD) de la lógica de negocio, 
 * facilitando el intercambio de implementaciones y el uso de Mocks.</p>
 * 
 * <p><b>Cómo se usa:</b> Al extender de <code>JpaRepository</code>, habilita automáticamente 
 * operaciones de guardado, borrado y búsqueda por ID.</p>
 */
public interface VetRepository extends JpaRepository<Vet, Long> {
}
