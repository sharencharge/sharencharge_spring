package fr.ipme.sharencharge.repositories;

import fr.ipme.sharencharge.pojos.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaibilityRepository extends JpaRepository<Availability, Long> {
}
