package fr.ipme.sharencharge.controllers;

import fr.ipme.sharencharge.controllers.generic.GenericController;
import fr.ipme.sharencharge.pojos.Station;
import fr.ipme.sharencharge.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stations")
public class StationController extends GenericController<Station> {

    @Autowired
    private StationService stationService;

    public StationController() {
    }

    @GetMapping("/search")
    public ResponseEntity<List<Station>> getStationByCity(@RequestParam(required = false) String search,
                                                          @RequestParam(required = false) String limit,
                                                          @RequestParam(required = false) String page){
        return ResponseEntity.ok(stationService.findStationByCity(search, limit, page));
    }

}
