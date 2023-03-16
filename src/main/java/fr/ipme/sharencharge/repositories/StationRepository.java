package fr.ipme.sharencharge.repositories;

import fr.ipme.sharencharge.pojos.Station;
import fr.ipme.sharencharge.pojos.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    List<Station> findByUser(User user);
    List<Station> findByAddress_CityContainsIgnoreCase(String city);
    Page<Station> findByAddress_CityContainsIgnoreCase(String city, Pageable page);

}
