package fr.ipme.sharencharge.controllers;

import fr.ipme.sharencharge.controllers.generic.GenericController;
import fr.ipme.sharencharge.pojos.Station;
import fr.ipme.sharencharge.pojos.User;
import fr.ipme.sharencharge.services.StationService;
import fr.ipme.sharencharge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController extends GenericController<User> {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping("/{id}/stations")
    public ResponseEntity<List<Station>> getUserStations(@PathVariable Long id){
        return ResponseEntity.ok(userService.findStationByUserId(id));
    }

    @GetMapping("/generate/users")
    public ResponseEntity<List<User>> generateUser(){
        userService.generateUser();
        return ResponseEntity.ok(userService.findAll());
    }

}
