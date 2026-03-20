package com.testing.course.repository;

import com.testing.course.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * <h1>REPOSITORIO: OwnerRepository</h1>
 * 
 * <p><b>Qué hace:</b> Proporciona el acceso a datos para la gestión de propietarios (Owners).</p>
 * 
 * <p><b>Por qué existe:</b> Permite buscar propietarios por criterios específicos como 
 * el apellido, facilitando la identificación de clientes en la base de datos.</p>
 * 
 * <p><b>Cómo se usa:</b> Es la puerta de entrada para persistir y buscar dueños de mascotas 
 * tanto en código de producción como en tests de persistencia (DataJpaTest).</p>
 */
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByLastName(String lastName);
}
