package fr.ipme.sharencharge.services;

import fr.ipme.sharencharge.pojos.User;
import fr.ipme.sharencharge.repositories.UserRepository;
import fr.ipme.sharencharge.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User> {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        setRepo(userRepository);
    }

}
