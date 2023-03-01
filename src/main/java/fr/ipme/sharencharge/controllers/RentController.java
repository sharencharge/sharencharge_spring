package fr.ipme.sharencharge.controllers;

import fr.ipme.sharencharge.controllers.generic.GenericController;
import fr.ipme.sharencharge.pojos.Rent;
import fr.ipme.sharencharge.pojos.User;
import fr.ipme.sharencharge.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rents")
public class RentController extends GenericController<Rent> {

    @Autowired
    private RentService rentService;

    public RentController() {
    }

    @GetMapping("/{id}/owner")
    public ResponseEntity<User> getRentOwner(@PathVariable Long id){
        return ResponseEntity.ok(rentService.findRentOwner(id));
    }
}
