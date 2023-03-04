package fr.ipme.sharencharge.repositories;

import fr.ipme.sharencharge.pojos.Rent;
import fr.ipme.sharencharge.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
//    @Query("SELECT u FROM Rent r JOIN Availability JOIN Station JOIN User u WHERE r.id = :id")
//    User findOwnerById(@Param("id") Long id);
}
