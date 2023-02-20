package fr.ipme.sharencharge.controllers;

import fr.ipme.sharencharge.controllers.generic.GenericController;
import fr.ipme.sharencharge.pojos.User;
import fr.ipme.sharencharge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends GenericController<User> {
    @Autowired
    private UserService userService;

    public UserController() {


    }
}
