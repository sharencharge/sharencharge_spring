package fr.ipme.sharencharge.services;

import fr.ipme.sharencharge.pojos.Rent;
import fr.ipme.sharencharge.pojos.User;
import fr.ipme.sharencharge.repositories.RentRepository;
import fr.ipme.sharencharge.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService extends GenericService<Rent> {
    private RentRepository rentRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public RentService(RentRepository rentRepository){
        super();
        setRepo(rentRepository);
    }

    public User findRentOwner(Long id) {
        return userService.findOwnerByRentId(id);
    }
}
