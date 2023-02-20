package fr.ipme.sharencharge.controllers;

import fr.ipme.sharencharge.controllers.generic.GenericController;
import fr.ipme.sharencharge.pojos.Availability;
import fr.ipme.sharencharge.services.AvaibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/availabilities")
public class AvaibilityController extends GenericController<Availability> {
    @Autowired
    private AvaibilityService avaibilityService;

    public AvaibilityController() {
    }
}
