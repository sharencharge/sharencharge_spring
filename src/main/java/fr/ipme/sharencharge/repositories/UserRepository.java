package fr.ipme.sharencharge.repositories;

import fr.ipme.sharencharge.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    @Query("SELECT u FROM Rent r JOIN r.availabilities a JOIN  a.station s JOIN s.user u WHERE r.id = :id")
    User findOwnerById(@Param("id") Long id);

    User findByEmail(String email);
}
