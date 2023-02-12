package fr.ipme.sharencharge.services;

import fr.ipme.sharencharge.pojos.User;
import fr.ipme.sharencharge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }
    public User findById(Long id){
        Optional<User>  user = userRepository.findById(id);
        if(!user.isPresent()){
            //Exception UserNotFound InDB
        }
        return user.get();
    }
}
