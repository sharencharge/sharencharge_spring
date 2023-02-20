package fr.ipme.sharencharge.repositories;

import fr.ipme.sharencharge.pojos.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
}
