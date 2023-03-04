package fr.ipme.sharencharge.repositories;

import fr.ipme.sharencharge.pojos.Station;
import fr.ipme.sharencharge.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    List<Station> findByUser(User user);
}
