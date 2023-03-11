package fr.ipme.sharencharge.controllers;

import fr.ipme.sharencharge.controllers.generic.GenericController;
import fr.ipme.sharencharge.pojos.Station;
import fr.ipme.sharencharge.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/stations")
public class StationController extends GenericController<Station> {

    @Autowired
    private StationService stationService;

    public StationController() {
    }

}
