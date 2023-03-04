package fr.ipme.sharencharge.repositories;

import fr.ipme.sharencharge.pojos.ERole;
import fr.ipme.sharencharge.pojos.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
